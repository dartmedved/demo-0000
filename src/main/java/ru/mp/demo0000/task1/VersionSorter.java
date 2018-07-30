package ru.mp.demo0000.task1;

import lombok.experimental.UtilityClass;
import org.apache.maven.artifact.versioning.ComparableVersion;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class VersionSorter {
    public List<String> sortVersions(final List<String> unsortedVersions) {
        if (unsortedVersions == null || unsortedVersions.isEmpty()) {
            return Collections.emptyList();
        }

        return unsortedVersions.stream()
                .map(ComparableVersion::new)
                .sorted()
                .map(ComparableVersion::toString)
                .collect(Collectors.toList());
    }
}
