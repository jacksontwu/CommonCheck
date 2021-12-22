# CommonCheck

## how to use
```java
Req req = new Req();
Test t = new Test();
Rsp rsp = new ProcessProxy<Test,Req,Rsp>.process(req);
```