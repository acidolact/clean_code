// Листинг 14.10
// Контекст: tring arg) { if (arg.startsWith("-")) parseElements(arg); } private void parseElements(String arg) { for (int i = 1; i < arg.length(); i++) parseElement(arg.charAt(i)); } private void parseElement(char argChar) { if (setArgument(argChar)) argsFound.add(argChar); else { unexpectedArguments.add(argChar); valid = false; } } private boolean setArgument(char argChar) { boolean set = true; if (isBoolean(argChar)) setBooleanArg(argChar, true); else if (isString(argChar)) setStringArg(argChar, ""); else

set = false;
return set;
}

private void setStringArg(char argChar, String s) {
currentArgument++;
try {
stringArgs.put(argChar, args[currentArgument]);
} catch (ArrayIndexOutOfBoundsException e) {
valid = false;
errorArgument = argChar;
errorCode = ErrorCode.MISSING_STRING;
}
}

private boolean isString(char argChar) {
return stringArgs.containsKey(argChar);
}

private void setBooleanArg(char argChar, boolean value) {
booleanArgs.put(argChar, value);
}

private boolean isBoolean(char argChar) {
return booleanArgs.containsKey(argChar);
}

public int cardinality() {
return argsFound.size();
}

public String usage() {
if (schema.length() > 0)
return "-[" + schema + "]";
else
return "";
}

public String errorMessage() throws Exception {
if (unexpectedArguments.size() > 0) {
return unexpectedArgumentMessage();
} else
switch (errorCode) {
case MISSING_STRING:
return String.format("Could not find string parameter for -%c.",
errorArgument);
case OK:
throw new Exception("TILT: Should not get here.");
}
return "";
}
private String unexpectedArgumentMessage() {
StringBuffer message = new StringBuffer("Argument(s) -");
for (char c : unexpectedArguments) {
message.append(c);
}
message.append(" unexpected.");
return message.toString();
}

public boolean getBoolean(char arg) {
return falseIfNull(booleanArgs.get(arg));
}

private boolean falseIfNull(Boolean b) {
return b == null ? false : b;
}

public String getString(char arg) {
return blankIfNull(stringArgs.get(arg));
}

private String blankIfNull(String s) {
return s == null ? "" : s;
}

public boolean has(char arg) {
return argsFound.contains(arg);
}

public boolean isValid() {
return valid;
}
}