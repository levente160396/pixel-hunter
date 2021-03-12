# pixel-hunter

This is just a simple SPRING-BOOT, JSF, PRIMEFACES project.
If you want to user. 
1. dowload WILDFLY 21 
2. add wildfly-21.0.1.Final\standalone\configuration\app-config\pixelhunting\mysql-database-configuration.properties 
3. ![image](https://user-images.githubusercontent.com/45422159/110942563-3e35ff00-833a-11eb-91e3-a67ab1668771.png)
4. Dowload mysql server.
5. Dowload mysql-connector-java-8.0.19.jar
6. add  module.xml and mysql connector wildfly-21.0.1.Final\modules\system\layers\base\com\mysql\main\
# Module.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<module xmlns="urn:jboss:module:1.5" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-8.0.19.jar" />
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```

7. Now you can start application.
