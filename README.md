# 项目介绍
微言聊天室是基于前后端分离，采用SpringBoot+Vue框架开发的网页版聊天室。

项目预览地址：http://www.javahai.top/index.html

前端工程源码地址：https://github.com/JustCoding-Hai/subtlechat-vue

后端工程源码地址：https://github.com/JustCoding-Hai/subtlechat

## 项目技术栈
### 后端技术栈
1. Spring Boot
2. Spring Security
3. MyBatis
4. MySQL
5. WebSocket
6. RabbitMQ
7. Redis

### 前端技术栈
1. Vue
2. ElementUI
3. axios
4. vue-router
5. Vuex
6. WebSocket
7. vue-cli4
...

## 项目预览图
客户端界面-群聊主界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108163850583.png)

客户端界面-私聊界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020110816390059.png)

管理端界面-用户管理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108163906854.png)

管理端界面-群聊消息管理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108163912953.png)


## 部署流程
1. clone 项目到本地
2. 在本地 MySQL 中创建一个空的数据库 subtlechat，在该数据库中运行提供的数据库脚本subtlechat.sql,完成表的创建和数据的导入。
3. 提前准备好Redis，在项目中的mail模块的 application.yml 文件中，将 Redis 配置改为自己的。
4. 提前准备好RabbitMQ，在项目中的mail模块的 application.yml 文件中和web模块中的 application-dev.properties，将 RabbitMQ 的配置改为自己的。
5. 注册邮箱的授权码，在项目中的mail模块的 application.yml 文件中填入

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108165225396.png)

6. 搭建fastdfs服务器，fastdfs-client.properties文件改成自己的。

7. 在 IntelliJ IDEA 中打开subtlechat项目，先启动 mail模块，再启动web模块。

8. 启动vue项目。

## 文档
请点击这个查看wiki的文档.
[项目文档](https://github.com/JustCoding-Hai/subtlechat/wiki)

## 最后
本人QQ：1258398543,期待与你交流！

如果该项目对你有帮助，跪求star！！！
