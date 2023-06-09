# Fractureiser Detector Plugin

A Gradle Plugin to detect Fractureiser malware in project dependencies.

Uses detection logic from the manual detection program that can be found [here](https://github.com/MCRcortex/nekodetector).

The Fractureiser malware once you run it, infects any jar it is able to find. This tool will help you detect if you are infected by the malware by scanning every jar file in your computer and checking if it shows sign of infection. *For more information about the malware, please refer to the [information document](https://github.com/fractureiser-investigation/fractureiser/blob/main/README.md).*

### Configuration

How to add to your project:
In `build.gradle`:
```groovy
plugins {
    // ...
    id 'io.github.serenibyss.fractureiser-scanner' version '<version of your choosing>'
}
```

Information on what Maven host to use to pull this plugin coming once a suitable host Maven is determined.

Can be configured to either log when found (default) or error the build process when found.
In `build.gradle`:
```groovy
scanFractureiser {
    errorOnFound = true
}
```
