# Classifications

1. Symmetric Encryption
    - Used to conceal contents of blocks or streams of data of any size
    - e.g. messages, files, keys, passwords
2. Asymmetric Encryption
    - Used to conceal small blocks of data
    - e.g. encryption keys and hash function values, which are used in digital signatures
    - Can also be used for the same purposes as symmetric encryption, but is less efficient
3. Data integrity algorithms
    - Used to protect blocks of data from alteration
4. Authentication protocols
    - Schemes designed to authenticate the identity of entities
    - Normally the first step of access to services
    - May be local e.g. fingerprint recognition on phone

# Areas

Network security consists of measures to do the following to security violations that involve the transmission of information:

1. Deter
2. Prevent
3. Detect
4. Correct

# Computer Security Objectives

There are three main objectives/properties:

1. Confidentiality
    i. Data confidentiality
        - assures confidential info not disclosed to unauthorised individuals
    ii. Privacy
        - assures individuals control their info (what’s collected, by who, and who they can tell)
        - e.g. we give location info to Google, but we have privacy expectations – not happy with our data being put up on a website for everyone to view
        - lecturer feels recent focus on privacy comes from privacy being threatened by digital devices and the ease of collection of this data
2. Integrity
    i. Data integrity
        - assures info and programs are only changed in an authorised manner
        - can tell whether something has been changed, and then whether the change was authorised
    ii. System integrity
        - assures a system performs unimpaired, free from (possibly non-deliberate) unauthorised manipulation
3. Availability
    - assures systems work promptly and service isn’t denied to authorised users
    - no point having security which removes the availability of a system

Accountability and authenticity are sometimes added to this list.

# Level of Impact

Also important to classify the level of impact of a specific breach, etc.

Cyber insurance may or may not be a good idea – since viruses etc. spread really rapidly, insurance companies may not have the money to handle the spread.

# Challenges

- Not simple
- Attacks on security features also need to be considered
- Requires constant monitoring (and timely application of countermeasures)
- Often an afterthought for companies
- Little benefit perceived until a security failure occurs
- Strong security often viewed as an impediment to efficient/user-friendly operation
- Procedures used to provide particular services are often counter-intuitive
- Security only as good as the weakest link in the chain

# OSI Security Architecture

-
- mechanism
- service

# Threat vs. Attack

Threat
:   A possible danger that might exploit a vulnerability

Attack
:   A threat that has been realised

By managing threats, you prevent and deter attacks.

# Passive vs. Active Attacks

Passive attack
:   Learns or uses information from the system, but doesn’t affect system resources

    Examples:
        - The release of message contents
        - Traffic analysis

Active attack
:   Attempts to alter system resources or affect their operation

## Active Attacks

Usually more harmful than passive attacks. Difficult to prevent because of variety of vulnerabilities, so goal is detection and recovery.

1. Masquerade attack
    - One entity pretends to be another
    - Usually includes another form of attack
2. Replay attack
    - Captures communication passively and retransmits it to produce an unauthorised effect
3. Modification of messages
    - Legitimate messages are altered, delayed, or reordered
4. Denial of service
    - Prevents or inhibits normal use

# Security Services

- Authentication
    - Single message: assures it’s from the source it claims
- Access control
- Data confidentiality

## Authentication

- For a single message, guaranteeing that it came from where it says it did
- For ongoing communication, …

## Access Control

The ability to limit and control the access to host systems and applications over communication links.

Entities must first be identified/authenticated, so that access rights can be tailored to the individual.

## Data Confidentiality

1. The protection of transmitted data from passive attacks
        - May protect all transmitted data over a period of time
        - Or just a single message or specific fields within a message
2. The protection of traffic flow from analysis
        - The attacker must not be able to observe the source, destination, frequency, length, or other characteristics of the traffic on a communications facility

## Data Integrity

Want to make sure information hasn’t been modified in transit.

Can be a stream of messages, a single message, or selected fields within a message.

Connection-oriented:
- Deals with a stream of messages
- Assures messages are received as sent without duplication, insertion, modification, reordering, or replays

Connectionless:
- Individual messages
- Protection against modification only

Can also be local instead of over a network, e.g. checking integrity of filesystem to detect viruses. Or may want to check that files stored on a cloud service have not been modified.

## Nonrepudiation

Prevents either sender or receiver from denying a transmitted message. The receiver can prove that the alleged sender did send the message. The sender can prove that the alleged receiver did receive the message.

## Availability

Protects a system to ensure its availability. Addresses security concerns raised by denial-of-service attacks. Depends on proper management and control of system resources and thus depends on access control service and other security services.

# Security Mechanisms

How to provide security properties? Should include security considerations in the design initially.

## Fundamental Security Design Principles

- Economy of mechanism
- Fail-safe defaults
- Complete mdeitation
- Open design
- Separation of privilege
- Least privilege
- Least common mechanism
- Psychological acceptability
- Isolation
- Encapsulation
- Modularity
- Layering
- Least astonishment

## Economy of Mechanism

Design of security measures should be as simple and small as possible.

Simple/small design is easier to test and verify.

Complex designs offer more opportunities for an adversary to discover subtle weaknesses that may be difficult to spot ahead of time.

## Fail-safe Defaults

Default settings should be safe.

Access decisions should be based on permission rather than exclusion. Default situation is lack of access, and the protection scheme identifies conditions under which access is permitted.

Most file systems and virtually all protected services on client/server use fail-safe defaults.

# Complete Mediation

If we have security measures, we should make sure that they are used continuously (e.g. access control should be implemented on every file access).

Systems should not rely on decisions retrieved from a cache.

This is resource-intensive and rarely used.

# Open Design

Design of a security mechanism shouldn’t be secret.

Public scrutiny improves the quality of the security mechanism.

Obfuscation (of e.g. PHP source code) doesn’t work because

# Separation of Privilege

Granularity of privilege. (?)

Ability to fine-tune the level of privilege.

# Least Privilege

Only the least amount of privilege needed for the task.

Decreases the attack surface.

# Least Common Mechanism

Design should minimise the functions shared by different users.

Reduces the number of unintended communication paths, and reduces the amount of hardware and software on which all users depend.

# Psychological Acceptability

Security mechanisms should not interfere unduly with the work of users, while meeting the needs of those who authorise access. Should be transparent to users, or introduce minimal obstruction.

Users will disregard/not accept things that frustrate them, and security will suffer.

Security procedures must also reflect the user’s mental model of protection.

# Isolation

Any system that can be isolated from its context, should be.

Three contexts:

- Public access systems should be isolated from critical resources to prevent disclosure or tampering.
- Processes and files of individual users should be isolated from one another.
- Security mechanisms should be isolated (i.e. access should be prevented).
