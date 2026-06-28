// Листинг 14.14
// Контекст: rgs("x##", new String[]{"-x", "Forty two"}); fail(); } catch (ArgsException e) { assertEquals(ArgsException.ErrorCode.INVALID_DOUBLE, e.getErrorCode()); assertEquals('x', e.getErrorArgumentId()); assertEquals("Forty two", e.getErrorParameter()); } } public void testMissingDouble() throws Exception { try { new Args("x##", new String[]{"-x"}); fail(); } catch (ArgsException e) { assertEquals(ArgsException.ErrorCode.MISSING_DOUBLE, e.getErrorCode()); assertEquals('x', e.getErrorArgumentId()); } } }

public class ArgsExceptionTest extends TestCase {
public void testUnexpectedMessage() throws Exception {
ArgsException e =
new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT,
'x', null);
assertEquals("Argument -x unexpected.", e.errorMessage());
}

public void testMissingStringMessage() throws Exception {
ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_STRING,
'x', null);
assertEquals("Could not find string parameter for -x.", e.errorMessage());
}

public void testInvalidIntegerMessage() throws Exception {
ArgsException e =
new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER,
'x', "Forty two");
assertEquals("Argument -x expects an integer but was 'Forty two'.",
e.errorMessage());
}

public void testMissingIntegerMessage() throws Exception {
ArgsException e =
new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER, 'x', null);
assertEquals("Could not find integer parameter for -x.", e.errorMessage());
}

public void testInvalidDoubleMessage() throws Exception {
ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE,
'x', "Forty two");
assertEquals("Argument -x expects a double but was 'Forty two'.",
e.errorMessage());
}

public void testMissingDoubleMessage() throws Exception {
ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE,
'x', null);
assertEquals("Could not find double parameter for -x.", e.errorMessage());
}
}