// Листинг 14.13
// Контекст: IntPresent() throws Exception { Args args = new Args("x#", new String[]{"-x", "42"}); assertEquals(1, args.cardinality()); assertTrue(args.has('x')); assertEquals(42, args.getInt('x')); } public void testInvalidInteger() throws Exception { try { new Args("x#", new String[]{"-x", "Forty two"}); fail(); } catch (ArgsException e) { assertEquals(ArgsException.ErrorCode.INVALID_INTEGER, e.getErrorCode()); assertEquals('x', e.getErrorArgumentId()); assertEquals("Forty two", e.getErrorParameter()); } }

public void testMissingInteger() throws Exception {
try {
new Args("x#", new String[]{"-x"});
fail();
} catch (ArgsException e) {
assertEquals(ArgsException.ErrorCode.MISSING_INTEGER, e.getErrorCode());
assertEquals('x', e.getErrorArgumentId());
}
}

public void testSimpleDoublePresent() throws Exception {
Args args = new Args("x##", new String[]{"-x", "42.3"});
assertEquals(1, args.cardinality());
assertTrue(args.has('x'));
assertEquals(42.3, args.getDouble('x'), .001);
}

public void testInvalidDouble() throws Exception {
try {
new Args("x##", new String[]{"-x", "Forty two"});
fail();
} catch (ArgsException e) {
assertEquals(ArgsException.ErrorCode.INVALID_DOUBLE, e.getErrorCode());
assertEquals('x', e.getErrorArgumentId());
assertEquals("Forty two", e.getErrorParameter());
}
}

public void testMissingDouble() throws Exception {
try {
new Args("x##", new String[]{"-x"});
fail();
} catch (ArgsException e) {
assertEquals(ArgsException.ErrorCode.MISSING_DOUBLE, e.getErrorCode());
assertEquals('x', e.getErrorArgumentId());
}
}
}