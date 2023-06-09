package io.github.serenibyss;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import javax.annotation.Nonnull;

/**
 * Fractureiser malware detection plugin
 */
@SuppressWarnings("unused")
public final class FractureiserPlugin implements Plugin<Project> {

    @Override
    public void apply(@Nonnull final Project project) {
        ScanFractureiserTask scanTask = project.getTasks().create("scanFractureiser", ScanFractureiserTask.class);
        scanTask.setGroup("Verification");
        scanTask.setDescription("Scans builds for Fractureizer malware exploits");
        project.getTasks().getByName("build").finalizedBy(scanTask);
    }
}
