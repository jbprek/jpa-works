MYSQL Scripts
=============


Create Database and user
------------------------
```

create database jpaworks;

create user 'jpaworks'@'localhost' identified by 'jpaworks';

grant all on jpaworks.* to 'jpaworks'@'localhost';

create database jpaapp;

create user 'jpaapp'@'localhost' identified by 'jpaapp';

grant all on jpaapp.* to 'jpaapp'@'localhost';

```
