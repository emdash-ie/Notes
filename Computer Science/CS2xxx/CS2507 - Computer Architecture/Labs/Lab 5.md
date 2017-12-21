* using COM1 in async mode

* doing our own interrupts – have to define which input is an interrupt

* baud rate factor sets clock rate relative to baud rate

    * x16 means count to the 8th clock cycle, sample, then wait 8 cycles, then repeat

    * always sampling in the middle of the bit

    * similar for x64

    * normally we go for x16

* U12 generates the clock for U15

* default to 8 bits for the character length

* use 2 bits for stop

* not using parity

* addressing

    * only need E4 - E5

        * address space allows for more addresses than needed, and repeats the ones there are

* clock rate of the machine is half the clock rate of the crystal (inside the metal canister) – half of app. 4 MHz

    * this is halved coming out of U6 (EPLD) into U12 (8253) because it has to be less than 2 MHz

* binary coded decimal counter counts to ten and then resets

* CTS linked to DTR to ensure we're always ready to send (?)

* count value is ~ when the counter resets (depending on mode)
