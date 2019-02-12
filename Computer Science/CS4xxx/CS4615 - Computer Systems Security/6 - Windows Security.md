---
title: Windows Security
dates:
- 12/02/2019
...

# Intro

- When Windows transitioned from Windows 95 to Windows NT, a bunch of ideas were taken from UNIX
- Windows is now a bit of a mishmash of UNIX and old Windows
- Windows contains a lot of legacy stuff

# Access Token

Security based around this.

# Security Reference Monitor

Concept not unique to Windows, equivalent to stuff in Linux.

- Lives in the kernel
- Small implementation, to aid in verifying correctness
- Performs all permission checks, all access goes through here
- Generates audit message

# LSASS (Local Security Authority Subsystem

User-mode process running `Lsass.exe`, responsible for the local system security policy (which users are allowed to log on to the machine, password policies, privileges granted to users and groups, security auditing settings, etc.).

Responsible for user authentication, using Kerberos (domain login), or `Msv1_0` (local login).

Responsible for sending security audit messages to the event log.

The Local Security Authority service (`Lsasrv.dll`) implements most of this functionality – it’s a library that `LSASS` loads.

## LSASS Policy Database

Database that contains the local system security policy settings. Stored in the registry, in an ACL-protected area.

- In Linux this kind of configuration stuff is in the filesystem, in Windows it goes in the registry (which is a kind of database).

Includes information such as:

- What domains are entrusted to authenticate logon attemps
- Who has permission to access the system and how (interactive, network, etc.)
- Who is assigned which privileges
- What kind of security auditing is to be performed

It stores secrets including:

- Logon information used for cached domain logons
- Windows service user-account logons

# Security Accounts Manager (SAM) & SAM Database

- implemented as `Samsrv.dll`, loaded into the LSASS process
- SAM database contains local users and groups, along with passwords and other attributes

When a user logs on using a local account:

- SAM process (`SamSrv`) takes the logon information
- Performs a lookup against the SAM database
- [more here]

# Active Directory

Active Directory is Microsoft’s LDAP directory, implemented as `Ntdsa.dll`, running in the LSASS process. (LDAP is a standard for a remote-accessible filesystem (?).)

It’s a directory service that contains a database that stores information about objects in a domain.

A domain is a collection of computers and their associated security groups that are managed as a single entity. A domain controller is usually several machines, rather than one, to provide redundancy. Need to have replication, synchronisation, and etc. between them.

Active Directory stores information about the objects in the domain, including users, groups, and computers.

[more here]

# Logon Procedure

Winlogon:

- Launches LogonUI for entering passwords at logon
- Changing passwords
- Locking and unlocking the workstation
- Guarantees that an untrusted process can’t get control of the desktop during the above operations
  - e.g. a screen grabber trying to steal the password

Winlogon relies on credential providers

- Can replace these with other ones, e.g. using password, thumbprint, or smartcard.
- A third party might supply additional credential providers (e.g. thumbprint)

Steps:

- Winlogon gets username and password
- Calls LSASS to authenticate the user
- If authenticated, starts shell on behalf of that user
- LogonUI can support additional network provider DLLs
  - To perform secondary authentication
  - Allows multiple network providers to gather identification and authentication information during normal logon
  - A user logging on to a Windows system might simultaneously be authenticated on a UNIX server
  - Allows [more here]

## Local Logon

- `MSV1_0` takes the username and a hashed version of the password
- Sends a request to the SAM to retrieve the account information, including:
  - hashed password
  - user’s groups
  - account restrictions (e.g. hours or types of access)
- [more here]

[more here]

# Access Token Content

Shows up everywhere, passed to a lot of functions.

Contains:

- security identifier (SID) for the user
- SIDs of user’s groups
- logon SID that identifies the current logon session
- list of privileges held by user or groups
- whether the token is a primary or impersonation token
  - Used for remote login (want to run under your permissions, not those of the account on the remote machine)
- [more here]

# Security Identifiers

Format: `S-1-5-21-AAA-BBB-CCC-RRR`

[more here]

# Access Checks

When a process attempts to access a protected object, the OS performs and access check. The check is performed by the SRM (process uses a system call, which is hooked in the SRM).

Compares the user account and group information in the Access Token and the ACEs in the object’s ACL. (The object can be a file, another process, etc.)

If all the requested operations (e.g. read, write, delete) are granted, then access is granted. Otherwise, there’s an access-denied error status.

Granted means you receive a handle to the object with the requested capabilities.

# Discretionary Access Control Lists

- Combines ACLs with DAC

A DACL includes the SID of the object owner (usually the object creator), and a list of access control entries (ACEs). Each ACE includes an SID and an access mask. (An access mask specifies the ability to read, write, create, delete, and modify.

Example (human-readable representation – stored would be e.g. bitmask):

```
Owner: CORP\Blake
ACE[0]: Allow CORP\Paige Full Control
ACE[1]: Allow Administrators Full Control
ACE[2]: Allow CORP\Cheryl Read, Write, and Delete
```

- order matters – uses first that matches

Can also have `Deny` rules. When an explicit `Deny` is encountered, Windows stops evaluating the ACEs early. As this can make it confusing and difficult to debug, generally deny rules are left out.

# Impersonation

A process (program) may run multiple threads. Each thread inherits the Access Token. Impersonation means setting a different user token on a thread.

Example:

- A server with access to database and/or filesystem
- You would like connected users to user their own credentials, not the server’s credentials
- Impersonation is used to create an Access Token for the user

User has to give consent for impersonation (via protocols used to connect – does not work with your own designed protocol semantics)

# Mandatory Access Control

Windows uses an additional mechanism called Integrity Control, which limits operations that might change the object state.

Object and principals (users) are labeled:

- Low integrity
- Medium
- High
- System
