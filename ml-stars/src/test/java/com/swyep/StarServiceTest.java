package com.swyep;

import org.junit.Before;
import org.junit.Test;

public class StarServiceTest {

    private StarService starService;

    @Before
    public void setup() {
        starService = new StarService();
    }

    @Test
    public void getCorrectStars() {
        System.out.println("--------------------");
        System.out.println(starService.getStars(1));
        System.out.println("--------------------");
        System.out.println(starService.getStars(2));
        System.out.println("--------------------");
        System.out.println(starService.getStars(3));
        System.out.println("--------------------");
        System.out.println(starService.getStars(4));
        System.out.println("--------------------");
        System.out.println(starService.getStars(5));
        System.out.println("--------------------");
        System.out.println(starService.getStars(10));
    }

}
