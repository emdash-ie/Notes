# Labs

Labs start next Thursday (the 23rd February) and last for five weeks. We'll be divided into two groups, 15:00–16:30 and 16:30–18:00. You can swap from your assigned group into the other group permanently if there's space – notify the demonstrators.

* No networking lectures next week.

## Network Programming Using the Socket API

The Socket API has been around since the 80s, and hasn't evolved a lot since then. It's used everywhere.

The socket is between the application layer and the transport layer. Generally everything from the socket down exists in the kernel space, and everything above exists in the user space.

Two popular transport services available via the socket API:

* TCP
* UDP

Server has a socket through which it receives and sends. Each client also needs a socket.

Sockets are bound to port numbers – the client needs to know the address of the server and also the port number of the server's socket.

### Example Application

1. Client reads a line of characters from its keyboard and sends the data to a server
2. Server converts it to uppercase and sends it back
[…]

### Socket Programming with UDP

[…]

### Socket Programming with TCP

[…]

* server creates a new socket for each client

* want to use parallelism to deal with multiple clients at once
