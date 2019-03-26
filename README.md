# LesDemo
Code van de les
Voor de datasource gebruik gemaakt van
https://www.codejava.net/servers/tomcat/configuring-jndi-datasource-for-database-connection-pooling-in-tomcat

Plaats dit in context.xml van in de conf van TomEE:
    <Resource
    name="jdbc/MySQLDB"
    auth="Container"
    type="javax.sql.DataSource"
    maxActive="100"
    maxIdle="30"
    maxWait="10000"
    driverClassName="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:8889/dea"
    username="root"
    password="root"
    />

En vergeet niet de mysql driver toe te voegen aan de lib map van TomEE
