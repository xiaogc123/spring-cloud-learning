# nacos-config
## 注意：

```yaml
spring:
  application:
    name: nacos-config
  cloud:
    nacos:
      config:
        #配置中心地址
        server-addr: 127.0.0.1:8848
        file-extension: yaml
#  ${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
# Data ID: nacos-config.yaml

```