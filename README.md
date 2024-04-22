# junit4-5-asserts-bridge

The JUnit Jupiter (JUnit 5) release contained a breaking change that may be very painful for large, existing Java projects to overcome:
- The message input parameter was moved from the first to the last parameter location for asserts.

Unlike JUnit 5's annotation changes, which may quickly be overcome with some import changes and some find and replace logic,
the asserts changes may be slow and painful to overcome.

In an established Java project, there may be thousands of unit tests, each may have their own assert(s) to update with
inline parameter location changes.

This project aims to provide a bridge to allow Java projects to more quickly adopt JUnit 5, without the need to fully update all
test class's asserts in one sweep.  Instead, if the bridge is used, the imports can initially be changed from Junit 4 to
the bridge's asserts.

Then, as time permits, the team can circle back and update the location of each individual test's assert message parameters and
remove the bridge imports at that time.


## Usage

The JUnit 4 to 5 bridge can be used by the following steps.

### Dependency
Add the dependency to your pom.xml:
```xml

    <build>
        <plugins>
            <plugin>
                <groupId>com.codingchica</groupId>
                <artifactId>junit4-5-asserts-bridge</artifactId>
                <!-- Latest version available at: https://github.com/codingchica/junit4-5-asserts-bridge/releases -->
                <version>1.0.8</version>
                <scope>test</scope>
            </plugin>
            ...
        </plugins>
        ...
    </build>
```

### Change Imports
Update the existing JUnit 4 assert imports to the bridge's package:

| Find                                                                              | Replacement                                  |
|-----------------------------------------------------------------------------------|----------------------------------------------|
| [org.junit.Assert](https://junit.org/junit4/javadoc/latest/org/junit/Assert.html) | com.codingchica.junit5.asserts.bridge.Assert |

### Proceed with JUnit 5 migration
Perform the remainder of the [Migrating from JUnit 4](https://junit.org/junit5/docs/current/user-guide/#migrating-from-junit4) 
updates besides the following (as the junit4-5-asserts-bridge cares for the argument movement):
- 3.5 Failure Message Arguments

Ensure that the build is successful and that the build kicks off the JUnit 5 tests successfully.

### Removing the Bridge Methods
At a later time, on a test class by test class basis, the bridge's import and method calls can be removed in favor of JUnit 5 (Jupiter) versions:
- [org.junit.jupiter.api.Assertions](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

At that time, the failure message arguments will need to be moved to the final parameter position.
See:
- [Migrating from JUnit 4: 3.5 Failure Message Arguments](https://junit.org/junit5/docs/current/user-guide/#migrating-from-junit4-failure-message-arguments)

### Removing the Bridge Dependency
After all test classes have been updated, the `junit4-5-asserts-bridge` dependency can be removed from the pom.xml.
