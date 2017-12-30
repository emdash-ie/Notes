---
title: "CS3506 Winter 2016: Solutions"
...

# Question 1

## Part (a)

You are asked to answer a series of short questions regarding IP addressing in the subnets containing hosts `A` and `B`, referred to as subnets `netA` and `netB` respectively.

### (i) How many IP addresses are needed in each of the two subnets?

Every node needs an IP address, as does each interface on the router, but the switches do not need IP addresses.

`netA` has 6 hosts, and one router interface, and so needs 7 IP addresses. `netB` has 5 hosts, and one router interface, and so needs 6 IP addresses.

However, there should also be a broadcast address for each subnet, consisting of the prefix followed by all ones, bringing the number of IP addresses in `netA` up to 8, and in `netB` up to 7.

### (ii) Assign an IP address to each of the two subnets. Your subnet addressings should use the smallest amount of address space possible.

We can assign subnet addresses with a precision of one bit in the IP address prefix – a prefix of 31 gives us 2 options, 30 gives 4, and 29 gives us 8 (because if 29 bits are fixed, 3 are free, giving 2^3 possible addresses). So a 29-bit prefix gives the smallest space that’s big enough.

To make things simple, I’m going with all-zero prefixes, giving 0.0.0.0/29 for `netA` and 0.0.0.8/29 for `netB`.

### (iii) Assign IP addresses in these ranges to each of the two hosts A and B.

* `A`: 0.0.0.3
* `B`: 0.0.0.10

To see why this is the case, look at the last byte in binary:

`netA` has the last byte 0000 0000, with the first 5 bits fixed, and the last 3 free to vary. Using the number 3 for `A` gives 0000 0011, which fits those rules.

`netB` has the last byte 0000 1000, with the first 5 bits fixed, and the last 3 free to vary. Using the number 10 for `B` gives 0000 1010, which also fits.

(`A` could have had any last digit from 0 to 6 inclusive (though not 7 because that would clash with the subnet broadcast address), and `B` could have had any from 8 to 14 inclusive – I picked these numbers just to show how it worked.)

### (iv) What IP address range can the router advertise to the outside for all of the hosts reachable in these two subnets?

It can advertise 0.0.0.0/28 – this means all but the last 5 digits are fixed at 0, and the rest can vary, which fits the addresses in the subnet.

(There will be 1 address that isn’t assigned to any host though, and is technically unreachable – I’m not sure how to square that one. I’m pretty sure this is still the correct answer, but if anyone has other suggestions, get on to me.)
