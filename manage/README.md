# 后台简介

## 概况
实现了浏览器的访问，对于手机等小屏设备的兼容性可能不是那么好，毕竟我是打算直接出一个客户端的。

## 部署
> 首先要确保项目`utils`中的`httpRequest.js`文件中`url`的正确；其次，检查`Login.vue`文件中的id、用户名和数据库设置的是否一致

完成下列环境部署
- Node.js 8.0+
- WebStorm编辑器

### 开发环境
1. 导入项目，运行 `npm install`（如果失败，清空包后试试`cnpm install`）
2. 启动项目：`npm run dev` 或 `npm start`

### 打包部署

运行`npm build`得到`dist`文件夹即可