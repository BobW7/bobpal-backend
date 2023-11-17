package com.bob.test;

import com.bob.bobpal.utils.AlgorithmUtil;
import org.junit.jupiter.api.Test;

public class AlgorithmUtilsTest {

    @Test
    public void test(){
        String st1 = "Bob is A";
        String st2 = "Bob is not AB";
        String st3 = "Bob is AB";
        int score1 = AlgorithmUtil.minDistance(st1, st2);
        int score2 = AlgorithmUtil.minDistance(st2, st3);
        System.out.println(score1);
        System.out.println(score2);
    }
}
