# elasticsearchpluginsample

### elasticsearch 插件demo

### 部署方法
```
mvn clean install 
cp target/releases/firestEsPlugin-5.6.4.zip elasticsearch-5.6.4/plugins
cd elasticsearch-5.6.4/plugins
unzip firestEsPlugin-5.6.4.zip
mv elasticsearch firestEsPlugin
rm -fr firestEsPlugin-5.6.4.zip
```

### 启动es后输出
```
[2017-12-31T19:27:15,865][WARN ][r.s.f.MyFirstPlugin      ] This is my fisrt Plugin
```
