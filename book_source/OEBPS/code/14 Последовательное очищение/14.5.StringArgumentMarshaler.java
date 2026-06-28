// Листинг 14.5
// Извлечено из главы 14

import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;

public class StringArgumentMarshaler implements ArgumentMarshaler {
private String stringValue = "";

public void set(Iterator<String> currentArgument) throws ArgsException {
try {
stringValue = currentArgument.next();
} catch (NoSuchElementException e) {
throw new ArgsException(MISSING_STRING);
}
}

public static String getValue(ArgumentMarshaler am) {
if (am != null && am instanceof StringArgumentMarshaler)