% 11: Communication Between Boards

# I2C

The I2C (Integrated Circuit to Integrated Circuit) bus is used for robust, quick, 2-way communication on 2 pins.

One comms line is the clock, and the other is the data. You can’t make the lines too long, as the signal will be lost/degraded. The lines are pulled high through pullup resisters to reduce noise.

## Leader/Follower

The bus leader initiates all communications – follower devices can only respond to requests sent from the leader. Follower devices can’t communicate directly with one another.

This protocol allows multiple devices to share the same data line without conflict.

Follower devices are distinguished by a unique ID number (7-bit address). These IDs may be selectable or they may be fixed at manufacturing time.

Some devices may have an address select pin – tying it to Vcc or ground, or letting it float, allows you to choose between three addresses.

### Protocol

1. Leader sends a start bit (typically by pulling the line low).
2. Leader sends a 7-bit address to identify the follower device it’s talking to.
3. Leader sends a read (1) or a write (0) bit to read from / write to the follower register.
4. Follower acknowledges command with a 0 bit.
5. If writing, leader sends 1 byte of data, waits for ACK, and then may send subsequent bytes, each ACKed in turn. If reading, leader receives 1 byte at a time and ACKs each.
6. When communication is completed, the leader sends a stop bit.

## Reading/Writing

Devices will have some number of registers (different for each device) that you can write to (e.g. to configure the device) or read from (e.g. to get the recorded temperature if the device is a thermometer).

# SPI Bus

The Serial Peripheral Interface bus uses separate lines for sending/receiving data and selecting follower devices, so you don’t need […].

There’s a select pin on each follower, and you run a separate line from the leader for each follower device, you use those to indicate which device you’re talking to (by pulling low the relevant line).

On every clock cycle a bit must be sent and received (but that bit doesn’t have to mean anything).
