## 校花社区

## 工具
[flyway](https://flywaydb.org/getstarted/firststeps/maven)

- flyway命令 mvn flyway:migrate

[lombok](https://projectlombok.org/setup/maven)

## 资料
[Github OAuth 文档](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[visual paradigm](https://www.visual-paradigm.com/cn/)

[mysql菜鸟教程](https://www.runoob.com/mysql/mysql-update-query.html)

[mybatis](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)

[devtools](https://docs.spring.io/spring-boot/docs/2.1.0.BUILD-SNAPSHOT/reference/htmlsingle/#using-boot-devtools)



```SQL
CREATE CACHED TABLE USER(
    "ID" INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    "ACCOUNT_ID" VARCHAR(100),
    "NAME" VARCHAR(50),
    "TOKEN" CHAR(36),
    "GMT_CREATE" BIGINT,
    "GMT_MODIFIED" BIGINT
);

alter table USER
	add bio varchar(256);

```


