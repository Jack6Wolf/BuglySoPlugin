# 内部实现原理

### 实际可以使用以下task代替
```groovy
//--------------------------Android so符号表自动上传-------------------------------
// 必须按照该路径放入debug so文件
def debugSoZip = 'debugso/obj.zip'
task unzipDebugSoZip(type: Copy) {
    File fileZip = file(debugSoZip)
    if (fileZip.exists()) {
        from zipTree(debugSoZip)
        into 'build/intermediates/bugly/release'
    } else {
        println '[UnzipDebugSoZip] <Warn> DebugSoZip Path Error！'
    }
}

tasks.whenTaskAdded { task ->
    if (task.name == 'assembleRelease') {
        task.dependsOn('unzipDebugSoZip')
    }
}
```