package ru.mp.demo0000.task2;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

@Slf4j
public class StationTaskTest {

    private StationTask task;

    private List<Station> stations;
    @Before
    public void setup(){
        stations = Arrays.asList(
                new Station("САНКТ-ПЕТЕРБУРГ"),
                new Station("САМАРА"),
                new Station("МОСКВА"),
                new Station("МОЗДОК"),
                new Station("МОЖГА")
        );
        task = new StationTask(stations);
    }


    @Test
    public void testOrderedSA(){
        final String prefix = "СА";
        final Collection<Station> result = task.getStationsByTwoFirstLetters(prefix);
        log.info("By 2 letters : {} ---> {}", prefix,result);
        assertThat(result,is(notNullValue()));
        assertThat(result,hasSize(2));
        assertThat(result,contains(stations.get(1), stations.get(0)));
    }

    @Test
    public void testOrderedMO(){
        final String prefix = "МО";
        final Collection<Station> result = task.getStationsByTwoFirstLetters(prefix);
        log.info("By 2 letters : {} ---> {}", prefix,result);
        assertThat(result,is(notNullValue()));
        assertThat(result,hasSize(3));
        assertThat(result,contains(stations.get(4), stations.get(3), stations.get(2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void  wrong1(){
        new StationTask(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void  wrong2(){
        new StationTask(new ArrayList<>());
    }

}
