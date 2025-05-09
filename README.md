


          
# PostgreSQL MyBatis 示例项目

## 项目简介

这是一个展示 PostgreSQL 与 MyBatis 集成的示例项目，重点演示了如何在 Spring Boot 应用中处理 PostgreSQL 的各种数据类型。项目使用 MyBatis 作为 ORM 框架，实现了与 PostgreSQL 数据库的交互。

## 主要特性

- 支持 PostgreSQL 的多种数据类型映射到 Java 对象
- 使用自定义 TypeHandler 处理特殊数据类型
- 实现了完整的 CRUD 操作
- 基于 Spring Boot 和 MyBatis Plus 构建

## 数据类型支持

项目演示了以下 PostgreSQL 数据类型与 Java 类型的映射：

- 基本数值类型 (int, smallint, bigint, decimal, numeric, real, double)
- 货币类型 (money)
- 字符类型 (char, varchar, text)
- 日期/时间类型 (date, time, timestamp, timestamptz, interval)
- 布尔类型 (boolean)
- 枚举类型 (enum)
- 几何类型 (point, line, box, circle)
- 网络地址类型 (inet, cidr, macaddr)
- 文本搜索类型 (tsvector)
- XML 类型
- UUID 类型
- JSON 类型 (json, jsonb)
- 数组类型 (int[], text[])
- 范围类型 (int range, timestamp range)
- 复合类型

## 自定义类型处理器

为了正确处理 PostgreSQL 特有的数据类型，项目实现了多个自定义 TypeHandler：

- MoneyTypeHandler - 处理 PostgreSQL money 类型
- DurationTypeHandler - 处理 interval 类型
- MoodEnumTypeHandler - 处理自定义枚举类型
- PGpointTypeHandler, PGlineTypeHandler, PGboxTypeHandler, PGcircleTypeHandler - 处理几何类型
- UUIDTypeHandler - 处理 UUID 类型
- JsonNodeTypeHandler - 处理 JSONB 类型
- IntegerArrayTypeHandler, StringArrayTypeHandler - 处理数组类型

## 技术栈

- Spring Boot
- MyBatis / MyBatis Plus
- PostgreSQL
- Gradle

## 快速开始

1. 确保已安装 PostgreSQL 数据库
2. 修改 `application.yml` 中的数据库连接信息
3. 运行 SQL 脚本创建表结构和测试数据
4. 启动应用程序

```bash
./gradlew bootRun
```

## API 接口

项目提供了 RESTful API 接口用于测试：

- POST `/api/pg-type-demo/mybatis` - 创建新记录
- GET `/api/pg-type-demo/mybatis/{id}` - 根据 ID 查询记录
- GET `/api/pg-type-demo/mybatis` - 查询所有记录
- DELETE `/api/pg-type-demo/mybatis/{id}` - 删除记录

## 参考文档

* [MyBatis 官方文档](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [PostgreSQL 官方文档](https://www.postgresql.org/docs/)
* [Spring Boot 文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)
