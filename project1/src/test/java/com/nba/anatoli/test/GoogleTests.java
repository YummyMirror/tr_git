package com.nba.anatoli.test;

import com.nba.anatoli.base.BaseTest;
import org.testng.annotations.Test;

public class GoogleTests extends BaseTest {
    @Test
    public void searchTest() {
        app.navigateTo().google();
        app.google().searchFor("Selenium");
    }
}
