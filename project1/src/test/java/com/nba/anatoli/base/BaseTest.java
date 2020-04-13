package com.nba.anatoli.base;

import com.nba.anatoli.application.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Application app = new Application();

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        app.init(browser);
    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        app.stop();
    }
}
