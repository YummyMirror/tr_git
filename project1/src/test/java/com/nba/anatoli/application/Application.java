package com.nba.anatoli.application;

import com.nba.anatoli.page.GooglePO;
import com.nba.anatoli.page.Navigator;
import org.openqa.selenium.WebDriver;

import static com.nba.anatoli.application.WebDriverFactory.create;

public class Application {
    private WebDriver wd;
    private GooglePO googlePO;
    private Navigator navigator;
    private YandexPO yandexPO;

    public void init(String browser) {
        wd = create(browser);
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
            wd = null;
        }
    }

    public GooglePO google() {
        if (googlePO == null) {
            googlePO = new GooglePO(wd);
        }
        return googlePO;
    }

    public Navigator navigateTo() {
        if (navigator == null) {
            navigator = new Navigator(wd);
        }
        return navigator;
    }
    
    public YandexPO yandex() {
        if (yandexPO == null) {
            yandexPO = new YandexPO(wd);
        }
        return yandexPO;
    }
}
