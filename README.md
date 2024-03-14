

## 1. 概述

一个基于Java开发的用户管理系统，包括用户注册、登录、信息修改、伪删除等功能。系统采用MD5加密保护用户密码安全，支持通过用户名进行用户的伪删除操作。

## 2. 功能需求

### 2.1 用户注册

- 用户能够通过输入用户名、密码、昵称和电话号码进行注册。
- 系统需校验注册信息的完整性，并对密码进行MD5加密存储。
- 注册前需验证输入的验证码是否正确。
- 系统需检查用户名是否已存在，避免重复注册。

### 2.2 用户登录

- 用户通过输入用户名和密码登录系统。
- 登录信息需通过MD5加密后与数据库存储的密码进行比对。
- 登录前需验证输入的验证码是否正确。

### 2.3 用户信息查询

- 登录后的用户可以查询自己的基本信息，包括用户名、昵称和电话号码。

### 2.4 用户信息修改

- 登录后的用户可以修改自己的昵称和电话号码。
- 修改信息时需重新输入密码进行验证。

### 2.5 用户伪删除

- 提供一个功能，允许用户通过输入要删除的用户名，并在验证账号密码及验证码通过后进行伪删除。
- 伪删除操作不会从数据库中实际删除记录，而是将用户记录标记为已删除状态。

## 3. 技术需求

### 3.1 技术栈

- Java：主要开发语言。
- MySQL：用于数据存储。
- JDBC：Java数据库连接，用于实现Java应用与数据库的交互。

### 3.2 数据库设计

#### 用户表（User）

| 字段名          | 数据类型         | 描述              |
| ------------- | -------------- | ----------------- |
| user_id       | INT            | 用户ID，主键，自增 |
| username      | VARCHAR(50)    | 用户名，唯一       |
| password      | VARCHAR(100)   | 加密后的密码       |
| nickname      | VARCHAR(50)    | 昵称              |
| phone         | VARCHAR(20)    | 电话号码           |
| membership_days | INT          | 会员天数           |
| isDelete      | TINYINT(1)     | 是否被伪删除       |

### 3.3 加密需求

- 使用MD5算法对用户密码进行加密处理。

### 3.4 验证码校验

- 注册、登录和执行敏感操作前需进行验证码校验。

## 4. 系统架构

- **视图层（View）**：处理用户界面和用户输入。
- **控制器层（Controller）**：处理业务逻辑。
- **服务层（Service）**：提供用户操作的业务实现。
- **数据访问对象层（DAO）**：负责数据库的直接操作。

## 5. 安全需求

- 系统中所有用户密码在存储和传输时必须加密处理。
- 通过验证码验证用户操作的合法性，增加系统安全性。

## 6. 运行环境

- Java
- mysql

## 7. 附件

- 数据库建表脚本。
- MD5加密工具类代码。
- 示例验证码实现
