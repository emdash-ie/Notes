% Project: Build a Burglar Alarm
%
% Thursday 2nd of November, 2017

# Project Description

The project is to build a burglar alarm.

Done in groups of 2 or 3.

Expected output:

- individual project report
- code
- demonstration
    - this is in the last week
- presentation by selected groups

It’s a lot of work to do in a month, but there’s nothing there that we can’t do. If you’re making a good effort, you will do well, so don’t worry about the results – enjoy it!

# Dates

- Demonstration in the lab on 27/11
- Presentation in class on 30/11
- Reports & code due to the CS office by 8/12
    - if you really need this date pushed out, he’ll do that on a case-by-case basis
    - don’t limit yourself – the report can be 60 pages or more if you want

# Functionality

1. Time of day
    - logging times of events (e.g. people entering, exiting)
    - displayed by default on LCD
        - this will be covered in the next lab
    - include functionality to set time
    - display date/time
    - ability to set date

2. Alarm zones
    - an alarm zone is a wired area being monitored by some sensors, and typically you can turn them on and off

### Basic functionality

4 zones with programmable zone types:

- entry/exit
- alarm digital
    - transition from 0 to 1 or 1 to 0 makes the alarm go off
- alarm analogue
    - e.g. amount of force on a window, light level in a greenhouse, potentiometer
- continuous monitoring
    - if someone cuts a wire, the alarm goes off

Programmable: zone 1 could be entry/exit at some time, another type another time, zones 3 and 4 could both be alarm analogue, etc.

### Entry/Exit

- set user password
- set exit/enter time
    - time to enter password before full alarm goes off
- require password to set/reset
    - also maybe quick set which sets immediately instead of allowing exit time

### Alarm Digital

- set active high or active low

### Alarm Analogue

- set threshold value
- also maybe sensing many rapid gentle taps

### Continuous Monitoring

- activate alarm on H->L transition

Extended functionality:
- require engineer password to change settings
- set engineer password

## When an Alarm Happens

Basic Functionality:

- record zone, date, time in the EERPOM memory
- activate alarm

## Saving Settings

- when zone settings are changed, they should be saved in the EEPROM (so that reboot works)

## Remote Control

- entering enter/exit passwords
- navigating menus (on the lcd)
