package com.serenibyss;

import com.serenibyss.nekodetector.Detector;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Set;

/**
 * Fractureiser malware detector Task
 */
public class ScanFractureiserTask extends DefaultTask {

    /**
     * Fractureiser malware scan task
     */
    @TaskAction
    public void scanFractureiser() {
        Project project = getProject();
        Set<File> depFiles = project.getConfigurations().getByName("runtimeClasspath").files();
        depFiles.addAll(project.getConfigurations().getByName("compileClasspath").files());

        Logger logger = project.getLogger();
        depFiles.forEach(file -> Detector.scan(file, logger, getErrorOnFound()));
    }

    /**
     * @return If this plugin should throw an exception on detection of potential malware
     */
    @Input
    public boolean getErrorOnFound() {
        return false;
    }
}
