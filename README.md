# Navigation with MapTrip Interface API for Android
## About MapTrip
MapTrip is a professional GPS navigation solution for industrial requirements. 

MapTrip provides different interfaces e.g. for truck navigation, waste management or fire departments.
And it can be integrated into simple or complex custom applications by interfaces (controlling with apps), a development kit (SDK) and remote APIs.

For more informations about MapTrip and its opportunities visit the GPS navigation homepage: https://www.maptrip.de

## About MapTrip Interface (MTI)
MTI is the acronym for MapTrip Interface. MTI is an easy to use interface which enables developers to control the MapTrip navigation app with few commands and requirements for development.

## About this tutorial
This tutorial shows how to use the MapTrip Interface API (MTI) to control the MapTrip navigation app with your Android app.
Step by step you will learn more about the communication between your app and MapTrip and the mechanism of MTI callbacks.

## Using this tutorial
This tutorial consists of different lessons. With every lesson you will build a simple app which interacts with MapTrip.
As is usual in tutorials, the first lesson starts with the basics and the following lessons become slightly more complex. Each lesson builds on the previous one. 
Accordingly, we recommend that you follow the given sequence. To keep this simple, every lesson has a ordinal in its name.

## The tutorial project structure
The tutorial is created and tested with Android Studio. It is also possible to follow the lessons using another development environment. Of course this depends to your experience.
Anyway, all explanations are related to Android Studio - we hope you are fine with this.

In Android Studio the lessons are modules so you have all lessons at a glance and can concentrate on one of them at a time.
Switching the project view between 'Android' and 'Project Files' helps to see only the code or all other related files like documentation.

Brief overview of the tutorial structure
* every lesson is an Android Studio module and can be generated as a runnable app
* every module has its own README file with a short explanation of the lesson's goal
* in every lesson module there is a folder _content_ which contains
  - a PDF file with instructions
  - code or configuration files (for controlling if something went wrong during your own implementation steps)

## Lessons overview
### lesson1_initialize
* Starting the MapTrip App
* Integrate MTI Library as Dependency
* Use Callbacks
* Initialize API

### lesson2_showapps
* Bring MapTrip to foreground
* Bring Tutorial App back to foreground

### lesson3_navigateWithCoordinates
* Add coordinates
* Start navigation guidance or (without available GPS) start simulation
* Switch to tutorial app when destination is reached

## Prerequisites
As mentioned before, this tutorial describes how to control the navigation app MapTrip. Therefore MapTrip has to be installed before you can start the lessons.
Please ensure that MapTrip runs at your device (or an emulation within your development environment). Otherwise it is hard to understand the lessons content.

If you are new in MapTrip you can get it by downloading here: https://www.maptrip.de
