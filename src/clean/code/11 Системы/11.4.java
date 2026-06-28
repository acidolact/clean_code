// Листинг 11.4
// Контекст: декларативных конфигурационных файлов или API. Во многих случаях вы фактически определяете аспекты библиотек Spring или JBoss, а инфраструктура берет на себя всю механику использования посредников Java или библиотек байт-кода в режиме, прозрачном для пользователя. Объявления управляют контейнером внедрения зависимостей (DI), который создает экземпляры основных объектов и связывает их по мере необходимости. В листинге 11.4 приведен типичный фрагмент конфигурационного файла Spring V2.5 app.xml 44.

<beans>
...
<bean id="appDataSource"
class="org.apache.commons.dbcp.BasicDataSource"
destroy-method="close"
p:driverClassName="com.mysql.jdbc.Driver"
p:url="jdbc:mysql://localhost:3306/mydb"
p:username="me"/>

<bean id="bankDataAccessObject"
class="com.example.banking.persistence.BankDataAccessObject"
p:dataSource-ref="appDataSource"/>

<bean id="bank"
class="com.example.banking.model.Bank"
p:dataAccessObject-ref="bankDataAccessObject"/>
...
</beans>