// Листинг 15.1
// Контекст: (2, "abc", "abbc").compact(null); assertEquals("expected:<ab[]c> but was:<ab[b]c>", failure); } public void testComparisonErrorOverlapingMatches2() { String failure= new ComparisonCompactor(0, "abcdde", "abcde").compact(null); assertEquals("expected:<...[d]...> but was:<...[]...>", failure); } public void testComparisonErrorOverlapingMatches2Context() { String failure= new ComparisonCompactor(2, "abcdde", "abcde").compact(null); assertEquals("expected:<...cd[d]e> but was:<...cd[]e>", failure); }

public void testComparisonErrorWithActualNull() {
String failure= new ComparisonCompactor(0, "a", null).compact(null);
assertEquals("expected:<a> but was:<null>", failure);
}

public void testComparisonErrorWithActualNullContext() {
String failure= new ComparisonCompactor(2, "a", null).compact(null);
assertEquals("expected:<a> but was:<null>", failure);
}

public void testComparisonErrorWithExpectedNull() {
String failure= new ComparisonCompactor(0, null, "a").compact(null);
assertEquals("expected:<null> but was:<a>", failure);
}

public void testComparisonErrorWithExpectedNullContext() {
String failure= new ComparisonCompactor(2, null, "a").compact(null);
assertEquals("expected:<null> but was:<a>", failure);
}

public void testBug609972() {
String failure= new ComparisonCompactor(10, "S&P500", "0").compact(null);
assertEquals("expected:<[S&P50]0> but was:<[]0>", failure);
}
}