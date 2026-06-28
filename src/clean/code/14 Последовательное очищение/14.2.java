// Листинг 14.2
// Контекст: } private void validateSchemaElementId(char elementId) throws ArgsException { if (!Character.isLetter(elementId)) throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null); } private void parseArgumentStrings(List<String> argsList) throws ArgsException { for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) { String argString = currentArgument.next(); if (argString.startsWith("-")) { parseArgumentCharacters(argString.substring(1)); } else { currentArgument.previous();

break;
}
}
}

private void parseArgumentCharacters(String argChars) throws ArgsException {
for (int i = 0; i < argChars.length(); i++)
parseArgumentCharacter(argChars.charAt(i));
}

private void parseArgumentCharacter(char argChar) throws ArgsException {
ArgumentMarshaler m = marshalers.get(argChar);
if (m == null) {
throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
} else {
argsFound.add(argChar);
try {
m.set(currentArgument);
} catch (ArgsException e) {
e.setErrorArgumentId(argChar);
throw e;
}
}
}

public boolean has(char arg) {
return argsFound.contains(arg);
}

public int nextArgument() {
return currentArgument.nextIndex();
}

public boolean getBoolean(char arg) {
return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
}

public String getString(char arg) {
return StringArgumentMarshaler.getValue(marshalers.get(arg));
}

public int getInt(char arg) {
return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
}

public double getDouble(char arg) {
return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
}

public String[] getStringArray(char arg) {
return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
}
}