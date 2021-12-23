# CommonCheck

## install
```xml
<dependency>
  <groupId>io.github.jacksontwu</groupId>
  <artifactId>commoncheck</artifactId>
  <version>1.0.0</version>
</dependency>
```

## how to use
```java
Req req = new Req();
Test t = new Test();
Rsp rsp = new ProcessProxy<Test,Req,Rsp>.process(req);
```
