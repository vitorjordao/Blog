# Basic concepts

## The "application.properties" file has been disabled because it contains sensitive authentication and database information.

### Examples "application.properties" to login

```properties
# Port
server.port=8002

# datasource
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:<db port>/<DB>
spring.datasource.username=<username>
spring.datasource.password=<password>

# Disable feature detection by this undocumented parameter. Check the org.hibernate.engine.jdbc.internal.JdbcServiceImpl.configure method for more details.
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false

# jpa
spring.jpa.database=POSTGRESQL
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=false

# Spring boot admin
spring.boot.admin.client.url=http://localhost:8000
management.endpoints.web.exposure.include=*

# JWT
jwt.expiration=<expiration time (miliseconds)>
```

### Examples "application.properties" to admin

```properties
# Port
server.port=8000
```
