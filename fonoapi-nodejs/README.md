[![GitHub stars](https://img.shields.io/github/stars/mtrung/fonoapi.svg)](https://github.com/mtrung/fonoapi/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/mtrung/fonoapi.svg)](https://github.com/mtrung/fonoapi/issues)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/mtrung/fonoapi/master/LICENSE)
[![Twitter](https://img.shields.io/twitter/url/https/github.com/mtrung/fonoapi/.svg?style=social)](https://twitter.com/intent/tweet?text=fonoApi - Mobile Device Description Api (https://github.com/mtrung/fonoapi/) so cool check it out)

# FonoApi for Node.js
https://github.com/mtrung/fonoapi

------
###### Node.js demo
```
var fonoapi = require('./fonoapi.node.js');
fonoapi.token = 'your_token';

// get devices
fonoapi.getDevices(myCallback, 'iphone', 'apple');

// get latest devices from apple (limit result to 5)
fonoapi.getLatest(myCallback, 5, 'apple');
```

###### Result Array Description

**Note** : Use a "_" before key if the key is starting with a number (example : _2g_bands, _4g_bands)

- DeviceName
- Brand
- technology
- 2g_bands
- gprs
- edge
- announced
- status
- dimensions
- weight
- sim
- type (display type)
- size
- resolution
- card_slot
- phonebook
- call_records
- camera_c (camera availablity)
- alert_types
- loudspeaker_
- 3_5mm_jack_
- sound_c (Sound Quality)
- wlan
- bluetooth
- gps
- infrared_port
- radio
- usb
- messaging
- browser
- clock
- alarm
- games
- languages
- java
- features_c (additional features sperated by "-")
- battery_c (battery information)
- stand_by (standby time)
- talk_time (standby time)
- colors (available colors)
- sensors
- cpu
- internal (memory + RAM)
- os
- body_c (body features seperated by "-")
- keyboard
- primary_ (primary camera)
- video
- secondary (secondary camera)
- 3g_bands
- speed
- network_c
- chipset
- features  (additional features seperated by "-")
- music_play
- protection
- gpu
- multitouch
- loudspeaker
- audio_quality
- nfc
- camera
- display
- battery_life
- 4g_bands
