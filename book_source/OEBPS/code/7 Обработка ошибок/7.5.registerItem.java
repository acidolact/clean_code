// Листинг 7.5 — Не возвращайте null
//
// На первый месте в списке неправильных действий программистов,
// провоцирующих ошибки, стоит возвращение null.
//
// Я видел бесчисленное множество приложений, в которых едва ли не
// каждая строка начиналась с проверки null.
//
// Возвращая null, мы фактически создаем для себя лишнюю работу,
// а для вызывающей стороны — лишние проблемы. Стоит пропустить
// всего одну проверку null, и приложение «уходит в штопор».
//

public void registerItem(Item item) {
  if (item != null) {
    ItemRegistry registry = persistentStore.getItemRegistry();
    if (registry != null) {
      Item existing = registry.getItem(item.getID());
      if (existing.getBillingPeriod().hasRetailOwner()) {
        existing.register(item);
      }
    }
  }
}

class Item {
  String getID() { return ""; }
  BillingPeriod getBillingPeriod() { return new BillingPeriod(); }
  void register(Item item) {}
}

class BillingPeriod {
  boolean hasRetailOwner() { return false; }
}

class ItemRegistry {
  Item getItem(String id) { return null; }
}

class PersistentStore {
  ItemRegistry getItemRegistry() { return null; }
}
