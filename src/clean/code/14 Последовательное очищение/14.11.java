// Листинг 14.11
// Контекст: ормлены в виде вики-страниц в FitNesse. Я мог запустить эти тесты в любой момент по своему усмотрению, и если они проходили — можно было не сомневаться в том, что система работает именно так, как положено. И тогда я занялся внесением множества очень маленьких изменений. Каждое изменение продвигало структуру системы к концепции ArgumentMarshaler, но после каждого изменения система продолжала нормально работать. На первом этапе я добавил заготовку ArgumentMarshaller в конец месива (листинг 14.11).

private class ArgumentMarshaler {
private boolean booleanValue = false;

public void setBoolean(boolean value) {
booleanValue = value;
}

public boolean getBoolean() {return booleanValue;}
}

private class BooleanArgumentMarshaler extends ArgumentMarshaler {
}
private class StringArgumentMarshaler extends ArgumentMarshaler {
}

private class IntegerArgumentMarshaler extends ArgumentMarshaler {
}
}