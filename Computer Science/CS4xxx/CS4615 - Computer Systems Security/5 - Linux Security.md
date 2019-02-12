---
title: Linux Security
dates:
- 05/02/2019
- 11/02/2019
...

# Reading

- Red Hat Enterprise Linux 6. Security-Enhanced Linux (User Guide, 2017)

# Filesystem Abstraction

In UNIX, 1 filesystem. Hard drives are mounted at different points on this tree. Devices like keyboards, etc. are also represented as files.

## Permissions

### Set Identity Bit (S Bit)

If set, then when file is executed, it runs with the permission of the owner/group, rather than the person who executed it.

E.g. `passwd`, used to change password.

### Sticky Bit (t)

Files within a folder with the sticky bit set can only be renamed or deleted by their owner. Normally, they can be renamed or deleted by anyone with read/write permissons on the folder.

- Need to look this up.

## Processes

Processes inherit the UID and GID (group identifier) from their parent (unless the set identity bit is used).

## Extended DAC

Aim to break down root privilege, only assign the needed privilege to a program.

- POSIX Capabilities
  - Splits superuser into high-level abstractions
  - Process-based
  - Issues:
    - Privilege overlap and escalation
    - Difficult to reason about overall security policy
- POSIX Access Control Lists
  - Uses extended attributes API
  - Metadata on files
