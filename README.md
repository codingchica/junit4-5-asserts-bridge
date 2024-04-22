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
