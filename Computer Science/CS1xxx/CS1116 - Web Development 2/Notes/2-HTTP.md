# HTTP

* In 95% of requests, the message body is empty.
* All headers are optional.
* The body of the response provides what was requested, when it can be provided.
* Embedded content requires a new request for each item, e.g. each stylesheet, each picture.
* HTTP 2.0 may allow servers to anticipate these requests, potentially speeding everything up.