package ru.mp.demo0000.task2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class StatonTokenizerTest {
    @Test
    public void tokenizerTest(){
        {
            final Station station = new Station("САНКТ-ПЕТЕРБУРГ");
            final StationToken token = StatonTokenizer.makeToken(station);
            log.info("Tokenize {} ---> {}", station, token);
            assertThat(token, is(notNullValue()));
            assertThat(token.getFirstLetters(), is(equalTo("СА")));
        }
        {
            final Station station = new Station("Å");
            final StationToken token = StatonTokenizer.makeToken(station);
            log.info("Tokenize {} ---> {}", station, token);
            assertThat(token, is(notNullValue()));
            assertThat(token.getFirstLetters(), is(equalTo("Å")));
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void wrong1(){
        StatonTokenizer.makeToken(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrong2(){
        StatonTokenizer.makeToken(new Station(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrong3(){
        StatonTokenizer.makeToken(new Station("   "));
    }

}
