// Листинг 11.3
// Извлечено из главы 11

// Bank.java (подавление имен пакетов...)
import java.utils.*;

// Абстрактное представление банка.
public interface Bank {
Collection<Account> getAccounts();
void setAccounts(Collection<Account> accounts);
}

// BankImpl.java
import java.utils.*;

// POJO-объект ("Plain Old Java Object"), реализующий абстракцию.
public class BankImpl implements Bank {
private List<Account> accounts;
public Collection<Account> getAccounts() {
return accounts;
}
public void setAccounts(Collection<Account> accounts) {
this.accounts = new ArrayList<Account>();
for (Account account: accounts) {
this.accounts.add(account);
}
}
}

// BankProxyHandler.java
import java.lang.reflect.*;
import java.util.*;

// Реализация InvocationHandler, необходимая для API посредника.
public class BankProxyHandler implements InvocationHandler {
private Bank bank;

public BankHandler (Bank bank) {
this.bank = bank;
}

// Метод, определенный в InvocationHandler
public Object invoke(Object proxy, Method method, Object[] args)
throws Throwable {
String methodName = method.getName();
if (methodName.equals("getAccounts")) {
bank.setAccounts(getAccountsFromDatabase());
return bank.getAccounts();
} else if (methodName.equals("setAccounts")) {
bank.setAccounts((Collection<Account>) args[0]);
setAccountsToDatabase(bank.getAccounts());
return null;
} else {
...
}
}

// Подробности:
protected Collection<Account> getAccountsFromDatabase() { ... }
protected void setAccountsToDatabase(Collection<Account> accounts) { ... }
}

// В другом месте...
Bank bank = (Bank) Proxy.newProxyInstance(
Bank.class.getClassLoader(),
new Class[] { Bank.class },
new BankProxyHandler(new BankImpl()));