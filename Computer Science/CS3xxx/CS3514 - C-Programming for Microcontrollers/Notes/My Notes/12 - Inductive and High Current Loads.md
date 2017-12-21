% Inductive and High Current Loads

# Intro

With a DC motor, you can get high voltages as the magnetic field collapses (e.g. 200V), which can damage your circuit if it’s not tolerant of high voltages.

Stepper motors don’t generate these voltages, but all DC motors need more power than the arduino can deliver, so you need to do two things:

1. Isolate the motor from the arduino
2. Power the motor independently with a secondary power supply

Motors can also create power spikes (that are harmful to electronics) due to their inductive nature.

# Circuit

The transistor acts as a switch – if there’s input to the base, then current flows from collector to emitter.

The transistor is run fully off/fully on, and not partway on. If partway on, some heat is generated in the transistor, which we don’t want.
