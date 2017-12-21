% 2: Middleware in Action

# Example: Content Download on a Mobile Device

The client browser contacts the web server and issues a download request for a page.

There are a number of interacting devices involved:

- the mobile device
- network devices
    - access points
    - routers
- the web server

There are also a number of supporting services:

- DHCP
    - gives the device an IP address
- DNS
    - name resolution
- Content adaptation
- Caching
- Mobility management
    - handles the device moving between access points

These services are considered to be middleware services, because they:

- Support many applications/clients/devices
- Hide heterogeneity
- Remain hidden from the user

# Content Adaptation

Changing the delivered content for different users. May happen for a variety of reasons:

- Poor quality of the wireless link
- Limited resources of the mobile device
- User preference
    - E.g. users may want to decrease data usage so they don’t hit a cap
- Protocols supported by the mobile device

There are a number of techniques for content adaptation:

- Distillation and refinement
- Summarisation
- Filtering
- Trans-coding

## Distillation and Refinement

Distillation tries to eliminate unnecessary data while preserving the most important data.

Examples:

- scaling down images in each dimension
- reduction of the colour depth in images and video

Refinement involves selecting certain parts of the data in its original quality, and is often used with distillation.

## Summarisation and Filtering

In summarisation, selected parts of the original data are used, aiming for the least possible loss of information.

For example, to summarise a video you might use a sequence of still or moving pictures, with or without audio, that preserves the original message.

In filtering, you transform, drop, or delay data delivery by applying filters on the data path, according to network or device requirements.

## Trans-Coding

Trans-coding involves transforming the format and representation of content. It is commonly used for converting video formats (e.g. QuickTime to MPEG), or adjusting HTML and graphics files to mobile devices.

## Architectural Solutions

Server-side adaptation
    - All processing on the server and the client receives adapted content.
    - Device detection library is required
    - Full adaptation possible, fine-grained control
