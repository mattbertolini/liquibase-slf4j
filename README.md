# liquibase-slf4j
Version 1.1.0
Written by Matt Bertolini

## How to Use
Grab the library from Maven Central and place it in your classpath.

```xml
<dependency>
    <groupId>com.mattbertolini</groupId>
    <artifactId>liquibase-slf4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

## License
liquibse-slf4j is licensed under the [MIT License](http://www.opensource.org/licenses/mit-license.php)

## Notes
This logger has a priority number of 5. If you have more than one Liquibase logger on your classpath the one with the
highest priority will be used.

## Bugs
Please report any bugs in the issue tracker above. Please be as detailed as possible in your report so I can create
unit tests to verify the problem is fixed.

## Release Notes

**1.1.0 - 2013-08-10**

* Upgrade Liquibase version to 3.0.x.
* Backward-compatible with previous version.

**1.0.0 - 2012-04-04**

* Initial release.
* Supports Liquibase 2.0.x.