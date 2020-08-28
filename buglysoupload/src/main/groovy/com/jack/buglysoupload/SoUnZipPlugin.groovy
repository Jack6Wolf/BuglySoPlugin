package com.jack.buglysoupload

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy

class SoUnZipPlugin implements Plugin<Project> {
    private static final String DEBUGSO_ZIP_PATH = 'debugso/obj.zip'
    private static final String OUT_PATH = 'build/intermediates/bugly/release'

    @Override
    void apply(Project project) {
        project.task('unzipDebugSoZip', type: Copy) {
            File fileZip = project.file(DEBUGSO_ZIP_PATH)
            if (fileZip.exists()) {
                from project.zipTree(DEBUGSO_ZIP_PATH)
                into OUT_PATH
            } else {
                println '[UnzipDebugSoZip] <Warn> DebugSoZip Path Error！'
            }
        }

        project.tasks.whenObjectAdded { task ->
            if (task.name == 'assembleRelease') {
                task.dependsOn('unzipDebugSoZip')
            }
        }
    }
}