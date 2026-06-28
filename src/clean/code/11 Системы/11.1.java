// Листинг 11.1
// Контекст: лжного разделения областей ответственности и поэтому создавали лишние барьеры для естественного роста. Возьмем хотя бы компонент-сущность (Entity Bean) для постоянного (persistent) класса. Компонентом-сущностью называется представление реляционных данных (иначе говоря, записи таблицы) в памяти. Для начала необходимо определить локальный (внутрипроцессный) или удаленный (на отдельной JVM) интерфейс, который будет использоваться клиентами. Возможный локальный интерфейс представлен в листинге 11.1.

package com.example.banking;
import java.util.Collections;
import javax.ejb.*;

public interface BankLocal extends java.ejb.EJBLocalObject {
String getStreetAddr1() throws EJBException;
String getStreetAddr2() throws EJBException;
String getCity() throws EJBException;
String getState() throws EJBException;
String getZipCode() throws EJBException;
void setStreetAddr1(String street1) throws EJBException;
void setStreetAddr2(String street2) throws EJBException;
void setCity(String city) throws EJBException;
void setState(String state) throws EJBException;
void setZipCode(String zip) throws EJBException;
Collection getAccounts() throws EJBException;
void setAccounts(Collection accounts) throws EJBException;
void addAccount(AccountDTO accountDTO) throws EJBException;
}