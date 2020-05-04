# MyWeibo

**一个社恐的个人微博**

正是为了不让无意义的杠精阻碍我的表达才有了这个项目

虽然我写的是社恐的微博，但是也许每个人都是在杠精的教育下「被社恐」。我不希望在发表了一些评论后引来无意义的争辩，因此这个项目是我表达欲的最后防线。

## 简介

这是一个基于Springboot2.x，vue2.x的前后端分离的开源微博系统，提供 前端界面+管理界面+后台服务 的整套系统源码。

- 你可以拿它作为前端Vue2.x学习的练手教程；
- 你也可以把它作为springboot2.x技术的学习项目；
- 你也可以将其视为一个前后端分离的项目实践；
- ...

当然我的想法绝不仅仅在网页上，我还希望未来可以把 Android 、 iOS 、 macOS 的客户端都完成，但不保证啥时间动工😅！

## 使用技术

- SpringBoot 2.x 后台基本框架
- Vue 2.x 前端基本框架
- ElementUI：后台管理页面UI库
- Vuetify：前端UI库
- Shiro 鉴权层
- Redis 缓存层
- Swagger 文档
- Mybaits-Plus 好用的mybatis框架
- lombox getter setter插件
- druid 数据库连接池
- jasypt 加密

## 站点演示

[https://weibo.zhuhe.site](https://weibo.zhuhe.site)

## 项目部署

由于各个模块的部署需要相互耦合，在此处仅给出部署顺序，具体部署步骤可以进入子文件夹查看README

```
db -> backend -> front -> manage
```
首先要部署数据库、其次是后端服务、最后是两个前端页面


## TODD

- [x] 完成后端
- [x] 完成前端
- [ ] 完成 Android
- [ ] 完成 iOS
- [ ] 完成 macOS

## Something

从 19 年开始学习编程，到现在也有一年的时间了，学习这个纯粹是兴趣（当然，能挣钱就更好了）。如果可以的话，在看过这个项目之后可以请我喝杯茶

![赞助](https://oss.zhuhe.site/blog-sponsor.png)
