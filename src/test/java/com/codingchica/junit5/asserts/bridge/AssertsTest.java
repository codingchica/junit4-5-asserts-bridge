package com.codingchica.junit5.asserts.bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.opentest4j.AssertionFailedError;

/** Unit tests for the Asserts class. */
class AssertsTest {
  private static final String MESSAGE = "My message goes here";
  private static final Object OBJECT1 = "Object 1 goes here";
  private static final Object OBJECT2 = "Object 2 goes here";
  private static final long LONG1 = Long.MIN_VALUE;
  private static final long LONG2 = Long.MAX_VALUE;
  private static final double DOUBLE1 = Double.MIN_VALUE;
  private static final double DOUBLE2 = Double.MAX_VALUE;
  private static final double DOUBLE_DELTA = 1;
  private static final float FLOAT1 = Float.MIN_VALUE;
  private static final float FLOAT2 = Float.MAX_VALUE;
  private static final float FLOAT_DELTA = 1;
  private static final Object[] OBJECTS1 =
      new Object[] {
        OBJECT1, OBJECT2,
      };
  private static final Object[] OBJECTS2 =
      new Object[] {
        OBJECT2,
      };
  private static final boolean[] BOOLEANS1 =
      new boolean[] {
        true,
      };
  private static final boolean[] BOOLEANS2 = new boolean[] {false, true};
  private static final byte[] BYTES1 = new byte[] {Byte.MIN_VALUE, Byte.MAX_VALUE};
  private static final byte[] BYTES2 = new byte[] {Byte.MAX_VALUE};
  private static final char[] CHARS1 =
      new char[] {
        Character.MIN_VALUE, Character.MAX_VALUE,
      };
  private static final char[] CHARS2 = new char[] {Character.MAX_VALUE};
  private static final short[] SHORTS1 = new short[] {Short.MIN_VALUE, Short.MAX_VALUE};
  private static final short[] SHORTS2 =
      new short[] {
        Short.MIN_VALUE,
      };
  private static final int[] INTS1 =
      new int[] {
        Integer.MIN_VALUE, Integer.MAX_VALUE,
      };
  private static final int[] INTS2 =
      new int[] {
        Integer.MAX_VALUE,
      };
  private static final long[] LONGS1 = new long[] {LONG1, LONG2};
  private static final long[] LONGS2 = new long[] {LONG2};
  private static final double[] DOUBLES1 = new double[] {DOUBLE1, DOUBLE2};
  private static final double[] DOUBLES2 = new double[] {DOUBLE2};
  private static final float[] FLOATS1 =
      new float[] {
        FLOAT1, FLOAT2,
      };
  private static final float[] FLOATS2 =
      new float[] {
        FLOAT2,
      };

  @Nested
  class AssertTrueTest {
    @Nested
    class AssertTrueWithMessageTest {
      @Test
      void assertTrue_whenInvokedWithTrue_thenThrowsNoException() {
        // Execution
        Executable executable = () -> Asserts.assertTrue(MESSAGE, true);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertTrue_whenInvokedWithFalse_thenThrowsException() {
        // Execution
        Executable executable = () -> Asserts.assertTrue(MESSAGE, false);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            MESSAGE + " ==> expected: <true> but was: <false>", exception.getMessage());
      }
    }

    @Nested
    class AssertTrueWithoutMessageTest {
      @Test
      void assertTrue_whenInvokedWithTrue_thenThrowsNoException() {
        // Execution
        Executable executable = () -> Asserts.assertTrue(true);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertTrue_whenInvokedWithFalse_thenThrowsException() {
        // Execution
        Executable executable = () -> Asserts.assertTrue(false);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals("expected: <true> but was: <false>", exception.getMessage());
      }
    }
  }

  @Nested
  class AssertFalseTest {
    @Nested
    class AssertFalseWithMessageTest {
      @Test
      void assertFalse_whenInvokedWithFalse_thenThrowsNoException() {
        // Execution
        Executable executable = () -> Asserts.assertFalse(MESSAGE, false);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertFalse_whenInvokedWithTrue_thenThrowsException() {
        // Execution
        Executable executable = () -> Asserts.assertFalse(MESSAGE, true);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            MESSAGE + " ==> expected: <false> but was: <true>", exception.getMessage());
      }
    }

    @Nested
    class AssertFalseWithoutMessageTest {
      @Test
      void assertFalse_whenInvokedWithFalse_thenThrowsNoException() {
        // Execution
        Executable executable = () -> Asserts.assertFalse(false);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertFalse_whenInvokedWithTrue_thenThrowsException() {
        // Execution
        Executable executable = () -> Asserts.assertFalse(true);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals("expected: <false> but was: <true>", exception.getMessage());
      }
    }
  }

  @Nested
  class FailTest {
    @Nested
    class FailWithMessageTest {

      @Test
      void fail_whenInvoked_thenThrowsException() {
        // Execution
        Executable executable = () -> Asserts.fail(MESSAGE);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(MESSAGE, exception.getMessage());
      }
    }

    @Nested
    class RunFailWithOutMessageTest {

      @ParameterizedTest
      @NullSource
      void fail_whenInvoked_thenThrowsException(String message) {
        // Execution
        Executable executable = Asserts::fail;

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals("", exception.getMessage());
      }
    }
  }

  @Nested
  class AssertEqualsTest {
    @Nested
    class AssertEqualsObjectTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(OBJECT1, OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(OBJECT1, OBJECT2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", OBJECT1, OBJECT2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsObjectWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, OBJECT1, OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, OBJECT1, OBJECT2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <%s> but was: <%s>", MESSAGE, OBJECT1, OBJECT2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsObjectArrayWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, OBJECTS1, OBJECTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, OBJECTS1, OBJECTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsObjectArrayWithoutMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(OBJECTS1, OBJECTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(OBJECTS1, OBJECTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsLongWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, LONG1, LONG1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, LONG1, LONG2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <%s> but was: <%s>", MESSAGE, LONG1, LONG2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsLongWithoutMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(LONG1, LONG1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(LONG1, LONG2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", LONG1, LONG2), exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsDoubleWithDeltaWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, DOUBLE1, DOUBLE1, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, DOUBLE1, DOUBLE2, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <%s> but was: <%s>", MESSAGE, DOUBLE1, DOUBLE2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsDoubleWithDeltaWithoutMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(DOUBLE1, DOUBLE1, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(DOUBLE1, DOUBLE2, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", DOUBLE1, DOUBLE2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsDoubleWithoutDeltaWithoutMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(DOUBLE1, DOUBLE1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(DOUBLE1, DOUBLE2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", DOUBLE1, DOUBLE2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsFloatWithDeltaWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, FLOAT1, FLOAT1, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, FLOAT1, FLOAT2, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <%s> but was: <%s>", MESSAGE, FLOAT1, FLOAT2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertEqualsFloatWithoutDeltaWithMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, FLOAT1, FLOAT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, FLOAT1, FLOAT2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertTrue(exception.getMessage().contains(MESSAGE));
      }
    }

    @Nested
    class AssertEqualsFloatWithDeltaWithoutMessageTest {

      @Test
      void assertEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(FLOAT1, FLOAT1, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertEquals_whenNotEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(FLOAT1, FLOAT2, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", FLOAT1, FLOAT2), exception.getMessage());
      }
    }
  }

  @Nested
  class AssertNotEqualsTest {

    @Nested
    class AssertNotEqualsObjectWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, OBJECT1, OBJECT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, OBJECT1, OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, OBJECT1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsLongWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, LONG1, LONG2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, LONG1, LONG1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, LONG1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsDoubleWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, DOUBLE1, DOUBLE2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, DOUBLE1, DOUBLE1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, DOUBLE1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsFloatWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, FLOAT1, FLOAT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, FLOAT1, FLOAT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, FLOAT1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsDoubleWithDeltaWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable =
            () -> Asserts.assertNotEquals(MESSAGE, DOUBLE1, DOUBLE2, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable =
            () -> Asserts.assertNotEquals(MESSAGE, DOUBLE1, DOUBLE1, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, DOUBLE1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsObjectWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(OBJECT1, OBJECT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(OBJECT1, OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", OBJECT1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsDoubleWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(DOUBLE1, DOUBLE2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(DOUBLE1, DOUBLE1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", DOUBLE1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsDoubleWithDeltaWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(DOUBLE1, DOUBLE2, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(DOUBLE1, DOUBLE1, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", DOUBLE1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsFloatWithDeltaWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(FLOAT1, FLOAT2, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(FLOAT1, FLOAT1, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", FLOAT1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsLongWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(LONG1, LONG2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(LONG1, LONG1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", LONG1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsFloatWithOutMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(FLOAT1, FLOAT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(FLOAT1, FLOAT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not equal but was: <%s>", FLOAT1), exception.getMessage());
      }
    }

    @Nested
    class AssertNotEqualsFloatWithDeltaWithMessageTest {

      @Test
      void assertNotEquals_whenNotEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, FLOAT1, FLOAT2, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotEquals_whenEquals_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotEquals(MESSAGE, FLOAT1, FLOAT1, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not equal but was: <%s>", MESSAGE, FLOAT1),
            exception.getMessage());
      }
    }
  }

  @Nested
  class AssertNullTest {

    @Nested
    class AssertNullObjectWithMessageTest {

      @Test
      void assertNull_whenNull_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNull(MESSAGE, null);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNull_whenNotNull_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNull(MESSAGE, OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <null> but was: <%s>", MESSAGE, OBJECT1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNullObjectWithoutMessageTest {

      @Test
      void assertNull_whenNull_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNull(null);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNull_whenNotNull_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNull(OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <null> but was: <%s>", OBJECT1), exception.getMessage());
      }
    }
  }

  @Nested
  class AssertNotNullTest {

    @Nested
    class AssertNotNullObjectWithoutMessageTest {

      @Test
      void assertNotNull_whenNotNull_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotNull(OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotNull_whenNull_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotNull(null);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals("expected: not <null>", exception.getMessage());
      }
    }

    @Nested
    class AssertNotNullObjectWithMessageTest {

      @Test
      void assertNotNull_whenNotNull_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotNull(MESSAGE, OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotNull_whenNull_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotNull(MESSAGE, null);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not <null>", MESSAGE), exception.getMessage());
      }
    }
  }

  @Nested
  class AssertSameTest {
    @Nested
    class AssertSameObjectWithMessageTest {

      @Test
      void assertSame_whenSame_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertSame(MESSAGE, OBJECT1, OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertSame_whenNotSame_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertEquals(MESSAGE, OBJECT1, OBJECT2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: <%s> but was: <%s>", MESSAGE, OBJECT1, OBJECT2),
            exception.getMessage());
      }
    }

    @Nested
    class AssertSameObjectWithoutMessageTest {

      @Test
      void assertSame_whenSame_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertSame(OBJECT1, OBJECT1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertSame_whenNotSame_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertSame(OBJECT1, OBJECT2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: <%s> but was: <%s>", OBJECT1, OBJECT2),
            exception.getMessage());
      }
    }
  }

  @Nested
  class AssertNotSameTest {

    @Nested
    class AssertNotSameObjectWithMessageTest {

      @Test
      void assertNotSame_whenNotSame_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotSame(MESSAGE, OBJECT1, OBJECT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotSame_whenSame_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotSame(MESSAGE, OBJECT1, OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> expected: not same but was: <%s>", MESSAGE, OBJECT1),
            exception.getMessage());
      }
    }

    @Nested
    class AssertNotSameObjectWithoutMessageTest {

      @Test
      void assertNotSame_whenNotSame_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertNotSame(OBJECT1, OBJECT2);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertNotSame_whenSame_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertNotSame(OBJECT1, OBJECT1);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("expected: not same but was: <%s>", OBJECT1), exception.getMessage());
      }
    }
  }

  @Nested
  class AssertArrayEqualsTest {
    @Nested
    class AssertObjectArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(OBJECTS1, OBJECTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(OBJECTS1, OBJECTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertObjectArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, OBJECTS1, OBJECTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, OBJECTS1, OBJECTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertBooleanArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(BOOLEANS1, BOOLEANS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(BOOLEANS1, BOOLEANS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <1> but was: <2>", exception.getMessage());
      }
    }

    @Nested
    class AssertBooleanArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, BOOLEANS1, BOOLEANS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, BOOLEANS1, BOOLEANS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <1> but was: <2>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertByteArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, BYTES1, BYTES1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, BYTES1, BYTES2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertByteArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(BYTES1, BYTES1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(BYTES1, BYTES2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertCharArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(CHARS1, CHARS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(CHARS1, CHARS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertCharArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, CHARS1, CHARS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, CHARS1, CHARS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertShortArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(SHORTS1, SHORTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(SHORTS1, SHORTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertShortArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, SHORTS1, SHORTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, SHORTS1, SHORTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertIntArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(INTS1, INTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(INTS1, INTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertIntArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, INTS1, INTS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, INTS1, INTS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertLongArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(LONGS1, LONGS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(LONGS1, LONGS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertLongArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, LONGS1, LONGS1);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(MESSAGE, LONGS1, LONGS2);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertDoubleArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(DOUBLES1, DOUBLES1, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(DOUBLES1, DOUBLES2, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertDoubleArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable =
            () -> Asserts.assertArrayEquals(MESSAGE, DOUBLES1, DOUBLES1, DOUBLE_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable =
            () -> Asserts.assertArrayEquals(MESSAGE, DOUBLES1, DOUBLES2, DOUBLE_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }

    @Nested
    class AssertFloatArrayEqualsWithoutMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(FLOATS1, FLOATS1, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable = () -> Asserts.assertArrayEquals(FLOATS1, FLOATS2, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            "array lengths differ, expected: <2> but was: <1>", exception.getMessage());
      }
    }

    @Nested
    class AssertFloatArrayEqualsWithMessageTest {
      @Test
      void assertArrayEquals_whenEquals_thenNoException() {
        // Execution
        Executable executable =
            () -> Asserts.assertArrayEquals(MESSAGE, FLOATS1, FLOATS1, FLOAT_DELTA);

        // Validation
        Assertions.assertDoesNotThrow(executable);
      }

      @Test
      void assertArrayEquals_whenNotEqual_thenException() {
        // Execution
        Executable executable =
            () -> Asserts.assertArrayEquals(MESSAGE, FLOATS1, FLOATS2, FLOAT_DELTA);

        // Validation
        AssertionFailedError exception =
            Assertions.assertThrows(AssertionFailedError.class, executable);
        Assertions.assertEquals(
            String.format("%s ==> array lengths differ, expected: <2> but was: <1>", MESSAGE),
            exception.getMessage());
      }
    }
  }
}
