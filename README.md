[![GitHub stars](https://img.shields.io/github/stars/shakee93/fonoapi.svg)](https://github.com/shakee93/fonoapi/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/shakee93/fonoapi.svg)](https://github.com/shakee93/fonoapi/issues)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/shakee93/fonoapi/master/LICENSE)
[![Twitter](https://img.shields.io/twitter/url/https/github.com/shakee93/fonoapi/.svg?style=social)](https://twitter.com/intent/tweet?text=fonoApi - Mobile Device Description Api (https://github.com/shakee93/fonoapi/) so cool check it out)
# FonoApi - Mobile Device Description Api
https://fonoapi.freshpixl.com/

this is an Api which can provide mobile device descriptions such as model, brand, cpu, gpu, dimensions, release date etc...
it might be helpful if you are building a website lke gsmarena, phonearena or something similar to that. this api contains a database of a mobile device descriptions of android, apple, ios and old phones too.. :D

this is the php class to communicate with the api. it would be nice if someone can help with other languages though. ;)

### Api
Api Url : https://fonoapi.freshpixl.com/v1/

###### Method : getdevice (https://fonoapi.freshpixl.com/v1/getdevice)
available options
  - brand -
       pass the Mobile Device Brand (example : "samsung", "htc")
  - device* -
       pass nearly relevent mobile device name (example : "i9305", "A8")
       this might result multiple results at a time.
  - position -
       when a set of results is returned you can get a specific device by passing the position of your device on the result set. count starts from 0
  - token* -
    - you will need a token to access the Api. no registration, nothing, just grab the key.
      you can get it here https://fonoapi.freshpixl.com/token/generate

###### Method : getlatest (https://fonoapi.freshpixl.com/v1/getlatest)
available options
  - brand -
       It gives the latest you can filter the brand (example : "samsung", "htc")
  - limit -
       limit the result count (Max 100)
  - token* -
    - you will need a token to access the Api. no registration, nothing, just grab the key.
      you can get it here https://fonoapi.freshpixl.com/token/generate


### Wrapper client library

###### PHP
https://github.com/mtrung/fonoapi/tree/master/fonoapi-php

###### Python
Thanks @jesusperiago
Python Library is here : https://github.com/jesusperiago/fonoapi

###### jQuery
jQuery Plugin here: https://github.com/shakee93/fonoapi/tree/master/fonoapi-js

###### Node.js
Node.js lib here:
https://github.com/mtrung/fonoapi/tree/master/fonoapi-nodejs

### Result Array Description

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
- features_c (additional features separated by "-")
- battery_c (battery information)
- stand_by (standby time)
- talk_time (standby time)
- colors (available colors)
- sensors
- cpu
- internal (memory + RAM)
- os
- body_c (body features separated by "-")
- keyboard
- primary_ (primary camera)
- video
- secondary (secondary camera)
- 3g_bands
- speed
- network_c
- chipset
- features  (additional features separated by "-")
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
