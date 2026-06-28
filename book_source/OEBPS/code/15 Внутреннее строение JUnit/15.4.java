// Листинг 15.4
// Контекст: я было выбрано неудачно. Это относится и к prefixIndex, хотя в данном случае «индекс» и «длина» являются синонимами. Несмотря на это, использование термина «длина» выглядит более последовательно. Проблема в том, что значение переменной suffixIndex отсчитывается не от 0, а от 1, так что называть его «длиной» не совсем коррект­но­ (кстати, этим же обстоятельством объясняются загадочные прибавления +1 в computeCommonSuffix [G33]). Давайте исправим этот недостаток. Результат показан в листинге 15.4.

public class ComparisonCompactor {
...
private int suffixLength;
...
private void findCommonPrefixAndSuffix() {
findCommonPrefix();
suffixLength = 0;
for (; !suffixOverlapsPrefix(suffixLength); suffixLength++) {
if (charFromEnd(expected, suffixLength) !=
charFromEnd(actual, suffixLength))
break;
}
}

private char charFromEnd(String s, int i) {
return s.charAt(s.length() - i - 1);
}

private boolean suffixOverlapsPrefix(int suffixLength) {
return actual.length() - suffixLength <= prefixLength ||
expected.length() - suffixLength <= prefixLength;
}

...
private String compactString(String source) {
String result =
DELTA_START +
source.substring(prefixLength, source.length() - suffixLength) +
DELTA_END;
if (prefixLength > 0)
result = computeCommonPrefix() + result;
if (suffixLength > 0)
result = result + computeCommonSuffix();
return result;
}
...
private String computeCommonSuffix() {
int end = Math.min(expected.length() - suffixLength +
contextLength, expected.length()
);
return
expected.substring(expected.length() - suffixLength, end) +
(expected.length() - suffixLength <
expected.length() - contextLength ?
ELLIPSIS : "");
}