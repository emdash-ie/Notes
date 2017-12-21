[…]

# Bit Manipulation (cont.)

We want to transmit a byte serially over a pin.

We define a rate and switch the output on the pin high or low according to the current bit.

We use a mask which has a 1 in the place we care about and a 0 everywhere else, and combine it with the data using a bitwise and – if the data bit in that place is 1, the result will be 1, otherwise it’ll be 0.
