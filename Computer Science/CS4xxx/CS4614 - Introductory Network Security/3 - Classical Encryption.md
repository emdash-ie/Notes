---
title: Classical Encryption
---

# Definitions

Plaintext
:       Original message

Ciphertext
:       The coded message

Enciphering/encryption
:       Process of converting from plaintext to ciphertext

Deciphering/decryption
:       ciphertext -> plaintext

Cryptographic cipher
:       A scheme

Cryptography
:       The area of study of the many schemes used for encryption (more specific than cryptology)

Cryptanalysis
:       Techniques for deciphering a message without knowledge of the enciphering details (in particular without the key)

Cryptology
:       Cryptography and cryptanalysis

# Symmetric Cipher Model

Two requirements:

- A strong encryption algorithm
- Sender and receiver have obtained and agreed identical keys in advance

Usually when we model this, the key is transmitted over a secure channel (e.g. a face-to-face meeting where the key is agreed upon).

# Cryptographic Systems

These are characterised along three independent dimensions:

1) The type of operations used for transforming plaintext to ciphertext
        - substitution
        - transposition
2) The number of keys used
   - Symmetric, single-key, secret-key, conventional encryption
   - Asymmetric, two-key, public-key encryption
3) The way in which the plaintext is processed
   - Block cipher
        - Encrypts blocks separately
   - Stream cipher
        - Encrypts bit-by-bit

# Cryptanalysis and Brute-Force Attack

Brute-force:

- try every possible key
- May be helped by knowing some information already, cutting down the keyspace

Cryptanalysis:

- Use the nature of the algorithm plus knowledge of the general characteristics of the plaintext
- Exploits characteristics of the algorithm to deduce a specific plaintext of the key being used

# Attacks

There are a number of attacks, which require different things to be known to the cryptanalyst.

- Ciphertext only
        - Encryption algorithm
        - Ciphertext
- Known plaintext
        - Encryption algorithm
        - Ciphertext
        - One or more plaintext-cipher pairs formed with the secret key
        - E.g. known or guessed email headers
- Chosen plaintext
        - Encryption algorithm
        - Ciphertext
        - Plaintext message chosen by cryptanalyst, together with its corresponding ciphertext generated with the secret key
        - E.g. a server echoing back the question you sent it, but encrypted
- Chosen ciphertext
        - Encryption algorithm
        - Ciphertext
        - Ciphertext chosen by cryptanalyst, together with its decorypted plaintext generated with the secret key
- Chosen text
        - Encryption algorithm
        - Ciphertext
        - Plaintext message chosen by cryptanalyst, together with corresponding ciphertext
        - Chosen ciphertext with corresponding plaintext

A modern cipher must provide security in all of these scenarios. Some historical ciphers were only focusing on the first couple of scenarios.

# Encryption Scheme Security

Two classifications of security:

- Unconditionally secure
        - No matter how much time an opponent has, it is impossible for them to decrypt the ciphertext (because the required information is not there)
        - These exist (e.g. the one-time pad), but are very strict in their requirements, or difficult to implement
- Computationally secure
        - The cost of breaking the encryption exceeds the value of the encrypted information
        - The time required to break the cipher exceeds the useful lifetime of the information

# Basic Techniques

## Substitution

The letter of plaintext are replaced by other letters, numbers, or symbols. If the plaintext is viewed as a sequence of bits, then substitution involves replacing plaintext bit patterns with ciphertext bit patterns.

### Caesar Cipher

Keyspace is only the length of the alphabet, so not many guesses are needed to brute-force it. However, there are also other attacks possible – the small key length is not the only problem.
