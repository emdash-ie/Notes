* 16-bit addressing & 8-bit data

* address is unidirectional but data is bidirectional

* multiplexed address and data is because the data is folded into the address bus

* data is buffered out to where it needs to go

3. For interrupt vectoring see diagram in practical 3

    * RAM jump table

    * comes back to the last instruction + 1 at the end

4. Simple diagram

    * parallel interface

    * block of logical elements that convert parallel to serial when writing out

    * simplify

    * show the USARTs place in the system and what it might have inside (converts serial to parallel and vice-versa)

5. Crystal

    * value selected to give nice count values for baud rates

6. So we can more accurately determine the bit sample (centre of the thing)

    * want to make sure you're at the centrepoint of the data

7. CTS crosses over RTS

* DTR used as foldback for DSR (?)

8. Software vs. hardware

* one is more time-efficient (wired)

* software may get overrun (latency between buffer filling and sender receiving XOFF)

9.

* DSR is trying to detect if a piece of data is ready for input

10. Polling

If you didn't have interrupts you'd have to constantly poll things to see if things need to be done (is there data for me?)

* very inefficient – probably spend most of your time looping instead of progressing data
