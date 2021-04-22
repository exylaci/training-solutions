package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsLengthTest {

    @Test
    void statisticParameter1(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->
              new WordsLength().getStatistic(null));
        assertEquals("The parameter is a must!",exception.getMessage());
    }

    @Test
    void statisticParameter2(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("");
        assertEquals(0,result.size());
    }

    @Test
    void statistic1(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Write a method called wordLengths that accepts a Scanner representing an input file as its argument. Your method should read from the given file, count the number of letters in each token in the file, and output a result diagram of how many words contain each number of letters. Use tabs before the asterisks so that they'll line up. If there are no words of a given length, omit that line from the output.");
        assertEquals(null,result.get(0));
        assertEquals(4,result.get(1));
        assertEquals(12,result.get(2));
        assertEquals(10,result.get(3));
        assertEquals(17,result.get(4));
        assertEquals(9,result.get(5));
        assertEquals(11,result.get(6));
        assertEquals(7,result.get(7));
        assertEquals(1,result.get(8));
        assertEquals(1,result.get(9));
        assertEquals(1,result.get(11));
        assertEquals(1,result.get(12));
    }

    @Test
    void statistic2(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Ez", "is", "jó","lett!");
        assertEquals(3,result.get(2));
        assertEquals(1,result.get(4));
    }

    @Test
    void statistic3(){
        Map<Integer, Integer> result = new WordsLength().getStatistic(new String[]{"Tegnap","kaptam","egy","e-mailt."});
        assertEquals(1,result.get(3));
        assertEquals(2,result.get(6));
        assertEquals(1,result.get(7));
    }
    @Test
    void statistic4(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Vajon, ezt meg tudja-e jól számolni ?");
        assertEquals(3,result.get(3));
        assertEquals(1,result.get(5));
        assertEquals(1,result.get(7));
        assertEquals(1,result.get(8));
    }

    @Test
    void statistic5(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Ez","","is"," ","jó","  ","eredményt ","ad","?");
        assertEquals(4,result.get(2));
        assertEquals(1,result.get(9));
    }

    @Test
    void statistic6(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Nézzünk egy \"idézetet\"!");
        assertEquals(1,result.get(3));
        assertEquals(1,result.get(7));
        assertEquals(1,result.get(8));
    }

    @Test
    void statistic7(){
        Map<Integer, Integer> result = new WordsLength().getStatistic("Mi van, ha van közte egy",null,"is?");
        assertEquals(3,result.get(2));
        assertEquals(3,result.get(3));
        assertEquals(1,result.get(5));
    }
}