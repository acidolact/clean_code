// Листинг 14.12
// Извлечено из главы 14

package com.objectmentor.utilities.getopts;

import java.text.ParseException;
import java.util.*;

public class Args {
private String schema;
private String[] args;
private boolean valid = true;
private Set<Character> unexpectedArguments = new TreeSet<Character>();
private Map<Character, ArgumentMarshaler> marshalers =
new HashMap<Character, ArgumentMarshaler>();
private Set<Character> argsFound = new HashSet<Character>();
private int currentArgument;
private char errorArgumentId = '\0';
private String errorParameter = "TILT";

private ErrorCode errorCode = ErrorCode.OK;
private enum ErrorCode {
OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, UNEXPECTED_ARGUMENT}
public Args(String schema, String[] args) throws ParseException {
this.schema = schema;
this.args = args;
valid = parse();
}

private boolean parse() throws ParseException {
if (schema.length() == 0 && args.length == 0)
return true;
parseSchema();
try {
parseArguments();
} catch (ArgsException e) {
}
return valid;
}

private boolean parseSchema() throws ParseException {
for (String element : schema.split(",")) {
if (element.length() > 0) {
String trimmedElement = element.trim();
parseSchemaElement(trimmedElement);
}
}
return true;
}

private void parseSchemaElement(String element) throws ParseException {
char elementId = element.charAt(0);
String elementTail = element.substring(1);
validateSchemaElementId(elementId);
if (isBooleanSchemaElement(elementTail))
marshalers.put(elementId, new BooleanArgumentMarshaler());
else if (isStringSchemaElement(elementTail))
marshalers.put(elementId, new StringArgumentMarshaler());
else if (isIntegerSchemaElement(elementTail)) {
marshalers.put(elementId, new IntegerArgumentMarshaler());
} else {
throw new ParseException(String.format(
"Argument: %c has invalid format: %s.", elementId, elementTail), 0);
}
}

private void validateSchemaElementId(char elementId) throws ParseException {
if (!Character.isLetter(elementId)) {
throw new ParseException(
"Bad character:" + elementId + "in Args format: " + schema, 0);
}
}

private boolean isStringSchemaElement(String elementTail) {
return elementTail.equals("*");
}

private boolean isBooleanSchemaElement(String elementTail) {
return elementTail.length() == 0;
}

private boolean isIntegerSchemaElement(String elementTail) {
return elementTail.equals("#");
}