package com.ybinsure.auth.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnowFlakeTest {

    @Test
    public void name() {
        SnowFlake snowFlake = new SnowFlake(0, 0);
        long id = snowFlake.nextId();
        System.out.println(id);
        System.out.println(Long.toBinaryString(id));
        SnowFlake snowFlake1 = new SnowFlake(0, 1);
        long id1 = snowFlake1.nextId();
        System.out.println(id1);
        System.out.println(Long.toBinaryString(id1));
    }
}