// Листинг 14.3
// Извлечено из главы 14

public interface ArgumentMarshaler {
void set(Iterator<String> currentArgument) throws ArgsException;
}