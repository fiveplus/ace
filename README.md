# 1.ace项目简介 (spring-boot 2.0.0 M3)

1.基于spring-boot 2.0.0 M3开发，集成spring-boot-starter-web,spring-boot-starter-thymeleaf,spring-boot-starter-security,mybatis,durid相关框架开发。

2.包含基础菜单权限组后台基本框架，页面基于Ace-admin后台框架

3.spring-boot内部集成tomcat，最终打包为jar。

4.集成aliyun.durid监控

默认访问地址：http://yourdomain/druid/login.html

user=admin,password=admin

# 2.部署为Unix/Linux Service

1.设置为系统服务

将你的应用打成jar包，部署到服务器，假设部署路径为/var/app，包名为app.jar，通过如下方式将应用设置为一个系统服务：
sudo ln -s /var/app/app.jar /etc/init.d/app

2.赋予可执行权限

chmod u+x app.jar

3.以系统服务的方式管理

接下来，就可以使用我们熟悉的service foo start|stop|restart来对应用进行启停等管理了
sudo service app start|stop
命令将得到形如Started|Stopped [PID]的结果反馈

默认PID文件路径：/var/run/appname/appname.pid
默认日志文件路径：/var/log/appname.log

这可能是我们更熟悉也更常用的管理方式。

## 自定义参数

在这种方式下，我们还可以使用自定义的.conf文件来变更默认配置，方法如下：

在jar包相同路径下创建一个.conf文件，名称应该与.jar的名称相同，如appname.conf

在其中配置相关变量，如：
JAVA_HOME=/usr/local/jdk
JAVA_OPTS=-Xmx1024M
LOG_FOLDER=/custom/log

## 安全设置

作为应用服务，安全性是一个不能忽略的问题，如下一些操作可以作为部分基础设置参考：

为服务创建一个独立的用户，同时最好将该用户的shell绑定为/usr/sbin/nologin

赋予最小范围权限：chmod 500 app.jar

阻止修改：sudo chattr +i app.jar

对.conf文件做类似的工作：chmod 400 app.conf,sudo chown root:root app.conf

