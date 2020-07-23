# liquibase-slf4j
Version 3.0.0<br/>
Written by Matt Bertolini

[![Maven Central](https://img.shields.io/maven-central/v/com.mattbertolini/liquibase-slf4j.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.mattbertolini%22%20AND%20a:%22liquibase-slf4j%22)
[![Build Status](https://travis-ci.org/mattbertolini/liquibase-slf4j.svg?branch=master)](https://travis-ci.org/mattbertolini/liquibase-slf4j)

An implementation of the Liquibase logger that delegates directly to SLF4J.

Liquibase has a logging mechanism that delegates to `java.util.logging`. It works great with SLF4J out of the box if 
you use `jul-to-slf4j` library. Unfortunately, there is a known 
[performance impact](http://www.slf4j.org/legacy.html#jul-to-slf4j) when bridging `java.util.logging` to SLF4J. This 
library helps to eliminate that performance impact by logging Liquibase directly to SLF4J. 

## How to Use
Grab the library from Maven Central and place it in your classpath.

**Maven:**

```xml
<dependency>
    <groupId>com.mattbertolini</groupId>
    <artifactId>liquibase-slf4j</artifactId>
    <version>3.0.0</version>
    <scope>runtime</scope>
</dependency>
```

**Gradle:**

```groovy
runtimeOnly 'com.mattbertolini:liquibase-slf4j:3.0.0'
```

**Ivy**

```xml
<dependency org="com.mattbertolini" name="liquibase-slf4j" rev="3.0.0"/>
```

## License
liquibase-slf4j is licensed under the [MIT License](http://www.opensource.org/licenses/mit-license.php)

## Notes
This logger has a priority number of 5. If there is more than one Liquibase logger on the classpath the one with the
highest priority will be used. The priority number can be changed by setting the system property 
`com.mattbertolini.liquibase.logging.slf4j.Slf4jLogService.priority` to an integer value of your choice.

Version 4 of Liquibase introduced a new plugin loading mechanism based on the Java 
[ServiceLoader](https://docs.oracle.com/javase/8/docs/api/java/util/ServiceLoader.html). Version 3.0.0 of this logger 
conforms to this new loader mechanism. If you are using Liquibase versions lower than 4, continue to use version 2.0.0 
of this library.

Liquibase version 3.4.0 had an issue loading third party loggers in some situations. This logger may not work on that 
version. It is recommended to upgrade to Liquibase 3.4.1 which addresses this issue.

### Log Level Mappings

<table>
    <tr>
        <th>Liquibase Level</th>
        <th>SLF4J Level</th>
    </tr>
    <tr>
        <td>~~Debug~~ (Deprecated)</td>
        <td>Debug</td>
    </tr>
    <tr>
        <td>Fine</td>
        <td>Debug</td>
    </tr>
    <tr>
        <td>Config</td>
        <td>Info</td>
    </tr>
    <tr>
        <td>Info</td>
        <td>Info</td>
    </tr>
    <tr>
        <td>Warning</td>
        <td>Warn</td>
    </tr>
    <tr>
        <td>Severe</td>
        <td>Error</td>
    </tr>
</table>

## Build and Test
### Requirements
* [Apache Ant](http://ant.apache.org/) - Version 1.10.6 or higher.
* JDK 8 or higher (Compiled with 1.8 source and target).

### Build
To build this project, clone the repo and run the ```ant``` command:
```
$ git clone https://github.com/mattbertolini/liquibase-slf4j.git
$ cd liquibase-slf4j
$ ant
```

The distributable jar files will be located in the ```dist``` folder. The build reports (unit test, coverage, etc.) 
will be located in the ```build/reports``` dir.

To list all available tasks:
```
$ ant -p
```

## Bugs
Please report any bugs in the issue tracker above. Please be as detailed as possible in the report, so I can create
unit tests to verify the problem is fixed.

## Release Notes

**3.0.0 - 2020-07-23**

- Upgraded to Liquibase version 4.0.0. This is a breaking change as the logging API changed significantly. Use version 
2.x if you are using Liquibase versions lower than 4.0.0.
- Upgraded to SLF4J 1.7.30.
- Added the ability to change the priority number of the logger by setting a Java property. To change the priority, set 
  the `com.mattbertolini.liquibase.logging.slf4j.Slf4jLogService.priority` property to an integer value.
- Repackaged logger now that package name is no longer used for locating third-party loggers.
- Java 8 is now the minimum supported JDK version.
- Added an `Automatic-Module-Name` to support the Java 9+ module system. The module name is `com.mattbertolini.liquibase.logging.slf4j`.
- Overhauled build files.


**2.0.0 - 2015-12-16**

- Switched the dependency scope of SLF4J and Liquibase to `provided`. This is because most users are already including 
  their own versions of these libraries and the versions are often much newer than what is defined in this library. By 
  marking them as `provided` it helps prevent version conflicts and extra exclusions in project files. For an example of 
  this, check out the POM file from [Dropwizard](https://github.com/dropwizard/dropwizard/blob/a0bdb73053872e73762af4f940b893f78a363c2e/dropwizard-bom/pom.xml#L145-L159)
- The minimum required Liquibase version is now 3.2.0. This is done to take advantage of updates to `AbstractLogger`.

**1.2.1 - 2013-10-12**

- Only printing the changeLogName and changeSetName if they are provided. This gets rid of the annoying nulls printed
in logs.

**1.2.0 - 2013-09-30**

- Upgrading to Liquibase version 3.0.5 to add new required methods.

**1.1.0 - 2013-08-10**

- Upgrade Liquibase version to 3.0.x.
- Backward-compatible with previous version.

**1.0.0 - 2012-04-04**

- Initial release.
- Supports Liquibase 2.0.x.
