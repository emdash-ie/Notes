- Why use sigmoid and not just clip to [0, 1]?
  - Sigmoid function is smooth, and therefore easier to differentiate (which we see later) than a non-continuous function.

- one-versus-one only uses the examples for the classes it’s currently checking, which is what may make it more feasible in practice
