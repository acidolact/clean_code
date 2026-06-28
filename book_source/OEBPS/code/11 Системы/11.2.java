// Листинг 11.2
// Контекст: ; void setState(String state) throws EJBException; void setZipCode(String zip) throws EJBException; Collection getAccounts() throws EJBException; void setAccounts(Collection accounts) throws EJBException; void addAccount(AccountDTO accountDTO) throws EJBException; } В интерфейс включены некоторые атрибуты адреса Bank, а также коллекция счетов, принадлежащих банку; данные каждого счета представляются отдельным EJB Account. В листинге 11.2 приведен соответствующий класс реализации компонента Bank.

package com.example.banking;
import java.util.Collections;
import javax.ejb.*;

public abstract class Bank implements javax.ejb.EntityBean {
// Бизнес-логика...
public abstract String getStreetAddr1();
public abstract String getStreetAddr2();
public abstract String getCity();
public abstract String getState();
public abstract String getZipCode();
public abstract void setStreetAddr1(String street1);
public abstract void setStreetAddr2(String street2);
public abstract void setCity(String city);
public abstract void setState(String state);
public abstract void setZipCode(String zip);
public abstract Collection getAccounts();
public abstract void setAccounts(Collection accounts);
public void addAccount(AccountDTO accountDTO) {
InitialContext context = new InitialContext();
AccountHomeLocal accountHome = context.lookup("AccountHomeLocal");
AccountLocal account = accountHome.create(accountDTO);
Collection accounts = getAccounts();
accounts.add(account);
}
// Логика контейнера EJB
public abstract void setId(Integer id);
public abstract Integer getId();
public Integer ejbCreate(Integer id) { ... }
public void ejbPostCreate(Integer id) { ... }
// Остальные методы должны быть реализованы, но обычно остаются пустыми:
public void setEntityContext(EntityContext ctx) {}
public void unsetEntityContext() {}
public void ejbActivate() {}
public void ejbPassivate() {}
public void ejbLoad() {}
public void ejbStore() {}
public void ejbRemove() {}
}