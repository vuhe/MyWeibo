# 后端简介

## 概况

后端完成了查询和权限管理的功能

## 部署
> 首先要确保环境中可以访问`redis`、`mysql`并配置完成，并更新`/src/main/resources/application.yml`中的配置

如需获取密码可以在测试文件中`new Sha256Hash("${密码}", "${用户名}")`修改对应位置参数，并执行测试得到

完成下列环境部署
- JDK 11
- Mysql
- Redis
- IDEA编译器
- Lombox插件

### 开发环境
在保证上述操作完成的前提下，在`idea`中直接运行，或执行`WeiboApplication.java`中的`main`函数。

### 打包部署

使用`maven`的`package`命令打包即可生成`jar`文件