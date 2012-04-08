liquibase-slf4j
===============
Version 1.0.0
Writen by Matt Bertolini

How to Use
----------
Grab the library from Maven Central and place it in your classpath.
```xml
<dependency>
    <groupId>com.mattbertolini</groupId>
    <artifactId>liquibase-slf4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

License
-------
liquibse-slf4j is licensed under the [MIT License](http://www.opensource.org/licenses/mit-license.php)

Notes
-----
This logger has a priority number of 5. If you have more than one Liquibase logger on your classpath the one with the
highest priority will be used.

Bugs
----
Please report any bugs in the issue tracker above. Please be as detailed as possible in your report so I can create
unit tests to verify the problem is fixed.