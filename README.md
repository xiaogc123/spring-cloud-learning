# spring-cloud-learning
## 注意：
- config-client模块的配置文件，需要用bootstrap，不然启动报错

- post请求http://localhost:8882/actuator/bus-refresh 响应404
 > 控制台有报 rabbit health check failed
 后面重新设置了一下用户的权限，请求可以成功了，不确定他们之间是否有关联