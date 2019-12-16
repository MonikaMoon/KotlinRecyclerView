package com.monika.kotlinrecyclerview;

import org.junit.After;
import org.junit.Before;

import java.util.concurrent.CountDownLatch;

public class BaseViewModelTest {
    public CountDownLatch countDownLatch;

    @Before
    public void beforeTest() {
        countDownLatch = new CountDownLatch(1);
    }

    @After
    public void afterTest() {
        countDownLatch = null;
    }
}