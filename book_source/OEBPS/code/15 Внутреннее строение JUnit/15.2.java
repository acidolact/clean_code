// Листинг 15.2
// Контекст: l.length()); for (; fPrefix < end; fPrefix++) { if (fExpected.charAt(fPrefix) != fActual.charAt(fPrefix)) break; } } private void findCommonSuffix() { int expectedSuffix = fExpected.length() - 1; int actualSuffix = fActual.length() - 1; for (; actualSuffix >= fPrefix && expectedSuffix >= fPrefix; actualSuffix--, expectedSuffix--) { if (fExpected.charAt(expectedSuffix) != fActual.charAt(actualSuffix)) break; } fSuffix = fExpected.length() - expectedSuffix; } private String computeCommonPrefix() {

return (fPrefix > fContextLength ? ELLIPSIS : "") +
fExpected.substring(Math.max(0, fPrefix - fContextLength),
fPrefix);
}

private String computeCommonSuffix() {
int end = Math.min(fExpected.length() - fSuffix + 1 + fContextLength,
fExpected.length());
return fExpected.substring(fExpected.length() - fSuffix + 1, end) +
(fExpected.length() - fSuffix + 1 < fExpected.length() -
fContextLength ? ELLIPSIS : "");
}

private boolean areStringsEqual() {
return fExpected.equals(fActual);
}
}