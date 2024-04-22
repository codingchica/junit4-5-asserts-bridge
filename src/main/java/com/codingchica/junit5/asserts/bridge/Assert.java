package com.codingchica.junit5.asserts.bridge;

import org.junit.jupiter.api.Assertions;

/**
 * Assert functions to aid in quickly bridging the gap during migrations between JUnit 4 (where
 * messages are provided as the first parameter) and JUnit 5 (where messages are provided as the
 * last parameter). This class covers most of the methods within
 * https://github.com/junit-team/junit4/blob/main/src/main/java/org/junit/Assert.java and moves the
 * message parameter, if any, to the last parameter location.
 */
public class Assert {
  /** Private constructor, so the class is not accidentally instantiated. */
  private Assert() {
    // Do not instantiate.
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param condition The condition to check.
   * @see Assertions#assertTrue(boolean, String)
   */
  public static void assertTrue(String message, boolean condition) {
    Assertions.assertTrue(condition, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param condition The condition to check.
   * @see Assertions#assertTrue(boolean)
   */
  public static void assertTrue(boolean condition) {
    Assertions.assertTrue(condition);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param condition The condition to check.
   * @see Assertions#assertFalse(boolean, String)
   */
  public static void assertFalse(String message, boolean condition) {
    Assertions.assertFalse(condition, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param condition The condition to check.
   * @see Assertions#assertFalse(boolean)
   */
  public static void assertFalse(boolean condition) {
    Assertions.assertFalse(condition);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param message The message to display if the assertion fails.
   * @see Assertions#fail(String)
   */
  public static void fail(String message) {
    Assertions.fail(message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @see Assertions#fail()
   */
  public static void fail() {
    Assertions.fail();
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param expected The expected value.
   * @param actual The actual value.
   * @see Assertions#assertEquals(Object, Object, String)
   */
  public static void assertEquals(String message, Object expected, Object actual) {
    Assertions.assertEquals(expected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value.
   * @param actual The actual value.
   * @see Assertions#assertEquals(Object, Object)
   */
  public static void assertEquals(Object expected, Object actual) {
    Assertions.assertEquals(expected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertNotEquals(Object, Object, String)
   */
  public static void assertNotEquals(String message, Object unexpected, Object actual) {
    Assertions.assertNotEquals(unexpected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertNotEquals(Object, Object)
   */
  public static void assertNotEquals(Object unexpected, Object actual) {
    Assertions.assertNotEquals(unexpected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertNotEquals(Object, Object, String)
   */
  public static void assertNotEquals(String message, long unexpected, long actual) {
    Assertions.assertNotEquals(unexpected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertNotEquals(long, long)
   */
  public static void assertNotEquals(long unexpected, long actual) {
    Assertions.assertNotEquals(unexpected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param message The message to display if the assertion fails.
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertNotEquals(double, double, double, String)
   */
  public static void assertNotEquals(
      String message, double unexpected, double actual, double delta) {
    Assertions.assertNotEquals(unexpected, actual, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertNotEquals(double, double, double)
   */
  public static void assertNotEquals(double unexpected, double actual, double delta) {
    Assertions.assertNotEquals(unexpected, actual, delta);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param unexpected The unexpected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertNotEquals(float, float, float)
   */
  public static void assertNotEquals(float unexpected, float actual, float delta) {
    Assertions.assertNotEquals(unexpected, actual, delta);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(Object[], Object[], String)
   */
  public static void assertArrayEquals(String message, Object[] expecteds, Object[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(Object[], Object[])
   */
  public static void assertArrayEquals(Object[] expecteds, Object[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(boolean[], boolean[], String)
   */
  public static void assertArrayEquals(String message, boolean[] expecteds, boolean[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(boolean[], boolean[])
   */
  public static void assertArrayEquals(boolean[] expecteds, boolean[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(boolean[], boolean[], String)
   */
  public static void assertArrayEquals(String message, byte[] expecteds, byte[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(byte[], byte[])
   */
  public static void assertArrayEquals(byte[] expecteds, byte[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(byte[], byte[], String)
   */
  public static void assertArrayEquals(String message, char[] expecteds, char[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(char[], char[])
   */
  public static void assertArrayEquals(char[] expecteds, char[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(short[], short[], String)
   */
  public static void assertArrayEquals(String message, short[] expecteds, short[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(short[], short[])
   */
  public static void assertArrayEquals(short[] expecteds, short[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(int[], int[], String)
   */
  public static void assertArrayEquals(String message, int[] expecteds, int[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(int[], int[])
   */
  public static void assertArrayEquals(int[] expecteds, int[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(long[], long[], String)
   */
  public static void assertArrayEquals(String message, long[] expecteds, long[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(long[], long[])
   */
  public static void assertArrayEquals(long[] expecteds, long[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertArrayEquals(double[], double[], double, String)
   */
  public static void assertArrayEquals(
      String message, double[] expecteds, double[] actuals, double delta) {
    Assertions.assertArrayEquals(expecteds, actuals, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertArrayEquals(double[], double[], double)
   */
  public static void assertArrayEquals(double[] expecteds, double[] actuals, double delta) {
    Assertions.assertArrayEquals(expecteds, actuals, delta);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param delta The acceptable difference allowed for the comparison.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(float[], float[], float, String)
   */
  public static void assertArrayEquals(
      String message, float[] expecteds, float[] actuals, float delta) {
    Assertions.assertArrayEquals(expecteds, actuals, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertArrayEquals(float[], float[], float)
   */
  public static void assertArrayEquals(float[] expecteds, float[] actuals, float delta) {
    Assertions.assertArrayEquals(expecteds, actuals, delta);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertEquals(double, double, double, String)
   */
  public static void assertEquals(String message, double expected, double actual, double delta) {
    Assertions.assertEquals(expected, actual, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertEquals(double, double, double, String)
   */
  public static void assertEquals(String message, float expected, float actual, float delta) {
    Assertions.assertEquals(expected, actual, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param unexpected The expected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertNotEquals(float, float, float, String)
   */
  public static void assertNotEquals(String message, float unexpected, float actual, float delta) {
    Assertions.assertNotEquals(unexpected, actual, delta, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertEquals(long, long)
   */
  public static void assertEquals(long expected, long actual) {
    Assertions.assertEquals(expected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertEquals(long, long, String)
   */
  public static void assertEquals(String message, long expected, long actual) {
    Assertions.assertEquals(expected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertEquals(double, double)
   */
  @Deprecated
  public static void assertEquals(double expected, double actual) {
    Assertions.assertEquals(expected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertEquals(double, double, String)
   */
  @Deprecated
  public static void assertEquals(String message, double expected, double actual) {
    Assertions.assertEquals(expected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertEquals(double, double, double)
   */
  public static void assertEquals(double expected, double actual, double delta) {
    Assertions.assertEquals(expected, actual, delta);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param delta The acceptable difference allowed for the comparison.
   * @see Assertions#assertEquals(double, double)
   */
  public static void assertEquals(float expected, float actual, float delta) {
    Assertions.assertEquals(expected, actual, delta);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param object The value to compare against null.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertNotNull(Object, String)
   */
  public static void assertNotNull(String message, Object object) {
    Assertions.assertNotNull(object, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param object The value to compare against null.
   * @see Assertions#assertNotNull(Object)
   */
  public static void assertNotNull(Object object) {
    Assertions.assertNotNull(object);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param object The value to compare against null.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertNotNull(Object, String)
   */
  public static void assertNull(String message, Object object) {
    Assertions.assertNull(object, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param object The value to compare against null.
   * @see Assertions#assertNull(Object)
   */
  public static void assertNull(Object object) {
    Assertions.assertNull(object);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertSame(Object, Object, String)
   */
  public static void assertSame(String message, Object expected, Object actual) {
    Assertions.assertSame(expected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expected The expected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertSame(Object, Object)
   */
  public static void assertSame(Object expected, Object actual) {
    Assertions.assertSame(expected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param unexpected The expected value to compare against.
   * @param actual The actual value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertNotSame(Object, Object, String)
   */
  public static void assertNotSame(String message, Object unexpected, Object actual) {
    Assertions.assertNotSame(unexpected, actual, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param unexpected The expected value to compare against.
   * @param actual The actual value.
   * @see Assertions#assertNotSame(Object, Object)
   */
  public static void assertNotSame(Object unexpected, Object actual) {
    Assertions.assertNotSame(unexpected, actual);
  }

  /**
   * Invoke JUnit 5's assertion, moving the message parameter to the final input.
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @param message The message to display if the assertion fails.
   * @see Assertions#assertArrayEquals(Object[], Object[], String)
   */
  @Deprecated
  public static void assertEquals(String message, Object[] expecteds, Object[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals, message);
  }

  /**
   * Invoke JUnit 5's assertion with the same name and parameters. Provided for convenience when
   * migrating between JUnit 4 and Junit 5 (with breaking changes).
   *
   * @param expecteds The expected array value to compare against.
   * @param actuals The actual array value.
   * @see Assertions#assertArrayEquals(Object[], Object[])
   */
  @Deprecated
  public static void assertEquals(Object[] expecteds, Object[] actuals) {
    Assertions.assertArrayEquals(expecteds, actuals);
  }
}
