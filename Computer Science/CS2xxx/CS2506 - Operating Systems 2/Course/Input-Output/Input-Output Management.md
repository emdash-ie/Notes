# I/O Devices

* Main issue is heterogeneity
    * there's a vast range of I/O devices, and they can have very different forms and performance

* Each has a driver to help operate it
    * driver forms part of the kernel
    * driver provides *only* the direct control of the device.
    * driver works directly with the controller of the device
    * .. makes sure the device is operated correctly by the OS

But we may have classes of devices of the same type, and so cost-effective operation requires more from the OS. (don't understand what this means)

* Class of device may be whether it's block or character.

We can create virtual copies of devices in memory to act as buffers, so that one device can be allocated to different processes simultaneously, with each waiting on the physical resource – gives a performance gain over each waiting to connect to the specific device with no virtual representation.

It is also possible to virtualise two cores with one physical core.

* additional software layer
    * allows homogeneous representation of I/O devices
        * this is better (it's an engineering principle)
    * I/O space is brought in line with the file system
        * same set of operations executed with files and I/O devices
            * major benefit
* need same or similar namespace
    * qualified names used to address a device
    * so now each process can have a name and an operation, where the name can be a file or an I/O device, and the operations are the same for both

Broadly two classes of I/O device – character and block.

Have also a major and minor device number (minor device number selects instance of a resource).

Major number used to identify position in character or block table, where there are pointers to op procedures (entry points in the driver).

* disk controller handles waiting on sectors, etc.

I/O schedulers operate in the kernel, in co-operation with the drivers.

# (Week 8)

In Linux we have block and character devices, and I/O control is different for the two.

## Example

* application running on the computer wants to write using the parallel port

* there's a file descriptor that has all the details required to manage that connection

* `write()` calls `lp_write()` which prepares for the output operation

    * "prepares" as in for the specific device

        * e.g. split the output into basic operations (i.e. one operation corresponds to a buffer)

        * buffer-size data transfers will occur

        * need a starting pointer and the amount of data to be printed

* driver in kernel memory space, controller separate

* controller uses an interrupt to tell the computer when each page is finished (then the next page is sent)

* also need a lock mechanism to uniquely allocate a printer to a particular process, for the duration of the print operation

    * printer is then unlocked after

    * other requests for the resource are queued until they can be processed

Interrupt handler can take some steps to complete, so is divided into upper half and lower half.

* the upper half detects what has happened and acknowledges it

    * only does quick things

* the lower half does any further processing required

# Sensors on Mobile Computing Devices

## Sensors

Three categories:

1. motion sensors
2. environmental sensors
3. position sensors

Most sensors have an official sensor type. There can be several sensors of the same type, e.g. two proximity sensors or two accelerometers.

Some sensors are hardware but some are software sensors – these consider input from different hardware sensors.

The OS allows users to get the raw data from sensors and use it in applications.

For any sensor, the two important parameters are the sampling rate and the accuracy.

### Android Sensor Subsystem

* Application framework is different, as are libraries

#### Applications Framework

* One sensor can be connected to several applications.

* important that applications might not get the latency and sampling rate they expect

* when the last application unregisters from a sensor, the framework sends a request to the HAL to deactivate the sensor (de-allocate resources such as buffers and flags)

## Use of Sensors in Applications

* need a listener for changes to the sensor

### Sensor Events

### Event Reporting Modes

### Further Developments

* external sensors e.g. sensors in the environment
