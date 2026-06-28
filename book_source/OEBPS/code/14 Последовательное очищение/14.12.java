// Листинг 14.12
// Контекст: sage() { if (schema.length() > 0) return "-[" + schema + "]"; else return ""; } public String errorMessage() throws Exception { switch (errorCode) { case OK: throw new Exception("TILT: Should not get here."); case UNEXPECTED_ARGUMENT: return unexpectedArgumentMessage(); case MISSING_STRING: return String.format("Could not find string parameter for -%c.", errorArgumentId); case INVALID_INTEGER: return String.format("Argument -%c expects an integer but was '%s'.", errorArgumentId, errorParameter);

case MISSING_INTEGER:
return String.format("Could not find integer parameter for -%c.",
errorArgumentId);
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
Args.ArgumentMarshaler am = marshalers.get(arg);
boolean b = false;
try {
b = am != null && (Boolean) am.get();
} catch (ClassCastException e) {
b = false;
}
return b;
}

public String getString(char arg) {
Args.ArgumentMarshaler am = marshalers.get(arg);
try {
return am == null ? "" : (String) am.get();
} catch (ClassCastException e) {
return "";
}
}

public int getInt(char arg) {
Args.ArgumentMarshaler am = marshalers.get(arg);
try {
return am == null ? 0 : (Integer) am.get();
} catch (Exception e) {
return 0;
}
}

public boolean has(char arg) {
return argsFound.contains(arg);
}

public boolean isValid() {
return valid;
}
private class ArgsException extends Exception {
}

private abstract class ArgumentMarshaler {
public abstract void set(String s) throws ArgsException;
public abstract Object get();
}

private class BooleanArgumentMarshaler extends ArgumentMarshaler {
private boolean booleanValue = false;
public void set(String s) {
booleanValue = true;
}
public Object get() {
return booleanValue;
}
}

private class StringArgumentMarshaler extends ArgumentMarshaler {
private String stringValue = "";
public void set(String s) {
stringValue = s;
}
public Object get() {
return stringValue;
}
}

private class IntegerArgumentMarshaler extends ArgumentMarshaler {
private int intValue = 0;
public void set(String s) throws ArgsException {
try {
intValue = Integer.parseInt(s);
} catch (NumberFormatException e) {
throw new ArgsException();
}
}
public Object get() {
return intValue;
}
}
}