package ru.mp.demo0000.task1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

@Slf4j
public class VersionSorterTest {
    @Test
    public void testEmptySort() {
        {
            final List<String> result = VersionSorter.sortVersions(null);
            assertThat(result, is(notNullValue()));
            assertThat(result.size(), is(equalTo(0)));
        }
        {
            final List<String> result = VersionSorter.sortVersions(Collections.emptyList());
            assertThat(result, is(notNullValue()));
            assertThat(result.size(), is(equalTo(0)));
        }
    }

    @Test
    public void sampleSort() {
        final List<String> given = Arrays.asList("3.0", "3.0.13", "1.2.3", "2.4.31", "1.0", "1.2");
        log.info("Given versions list : {}", given);
        final List<String> result = VersionSorter.sortVersions(given);
        log.info("Sorted versions list : {}", result);
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(given.size())));
        assertThat(result, contains("1.0", "1.2", "1.2.3", "2.4.31", "3.0", "3.0.13"));
    }

    @Test
    public void sampleSortWithSnapshot() {
        final List<String> given = Arrays.asList("3.0", "3.0.13", "1.2.3", "2.4.31", "1.0", "1.2",
                "1.0-SNAPSHOT", "1.2-SNAPSHOT");
        log.info("Given versions list : {}", given);
        final List<String> result = VersionSorter.sortVersions(given);
        log.info("Sorted versions list : {}", result);
        assertThat(result, is(notNullValue()));
        assertThat(result.size(), is(equalTo(given.size())));
        assertThat(result, contains("1.0-SNAPSHOT", "1.0", "1.2-SNAPSHOT", "1.2", "1.2.3", "2.4.31", "3.0", "3.0.13"));
    }
}
