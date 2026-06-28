// Листинг 11.5
// Контекст:  «политика» все же проще сложной логики посредников и аспектов, скрытой от наших глаз и создаваемой автоматически. Архитектура выглядит настолько заманчиво, что инфраструктуры вроде Spring привели к полной переработке стандарта EJB для версии 3. EJB3 в значительной мере следует характерной для Spring модели декларативной поддержки поперечных областей ответственности с использованием конфигурационных файлов XML и/или аннотаций Java 5. В листинге 11.5 приведен объект Bank, переписанный для EJB346.

package com.example.banking.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "BANKS")
public class Bank implements java.io.Serializable {
@Id @GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Embeddable // Объект "встраивается" в запись базы данных Bank
public class Address {
protected String streetAddr1;
protected String streetAddr2;
protected String city;
protected String state;
protected String zipCode;
}

@Embedded
private Address address;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
mappedBy="bank")
private Collection<Account> accounts = new ArrayList<Account>();

public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}

public void addAccount(Account account) {
account.setBank(this);
accounts.add(account);
}

public Collection<Account> getAccounts() {
return accounts;
}

public void setAccounts(Collection<Account> accounts) {
this.accounts = accounts;
}
}