# spring-cloud-learning
SpringCloud Sleuth提供了一套完整的服务跟踪的解决方案，并且在分布式系统中提供追踪解决方案并兼容支持了zipkin
--
> 我们可以清楚地知道一次调用经过了多少个微服务以及相应的耗时是多少;  
Zipkin提供一个Web前端可以轻松地收集和分析数据，例如用户每次请求服务的处理时间等，来方便的监测系统中存在的瓶颈

- 启动Zipkin Server

> ① 下载zipkin-server-2.12.9-exec.jar  
  地址:https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/  
 ② 启动ZipkinServer：java -jar zipkin-server-2.12.9-exec.jar  
  ③ 访问控制台：http://localhost:9411/zipkin/
  
- 名词解释
> Trace：类似于树结构的Span集合，表示一条调用链路，，存在唯一标识。  
  Span：表示调用链路来源，通俗的理解span就是一次请求信息
  
- 运行及结果
