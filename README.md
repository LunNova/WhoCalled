WhoCalled [![Build Status](http://nallar.me/buildservice/job/WhoCalled/badge/icon)](http://nallar.me/buildservice/job/WhoCalled/)
====
Which class called me?

High performance library for retrieving the class which called your code in Java.

Copyright &copy; 2016, nallar <ross@nallar.me>

Usage
---

Main.java:
```

```

Example.java:
```
public static void exampleMethod() {
	Class<?> callingClass = WhoCalled.$.getCallingClass();
	// callingClass = Main.class
}
```

Maven
---
WhoCalled is available on the jcenter maven server as me.nallar:WhoCalled:1.0

Download
---
Download the latest builds from [Jenkins].

License
---
WhoCalled is licensed under the MIT license.

Compiling
---
WhoCalled is built using Gradle.

* Install the Java Development Kit
* Run `./gradlew build`

Coding and Pull Request Formatting
---
* Generally follows the Oracle coding standards.
* Tabs, no spaces.
* Pull requests must compile and work.
* Pull requests must be formatted properly.

Please follow the above conventions if you want your pull requests accepted.

[Jenkins]: http://nallar.me/buildservice
