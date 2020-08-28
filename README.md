# BuglySoPlugin

由于Bugly的So符号表自动上传，只支持项目以Module依赖形式。而以jar/lib依赖形式无效。
该项目就是为了解决这个痛点进行的一个Plugin。



## 使用

- project bugld.gradle add


```groovy
 classpath 'com.jack.bugly:buglysoupload:1.0.0'
```

- module build.gradle add
```groovy
apply plugin: 'so.upload'
```

- create the "debugso" directory under the Module directory
>1. 文件按照obj->abi版本（eg:arm6-v8a、...）->xxx.so命名排放
>2. 文件压缩成zip包，命名obj
>3. 产生新的so库（包含新版本、新包）请覆盖原obj.zip
