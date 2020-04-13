package com.nba.anatoli.page;

import com.nba.anatoli.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Navigator extends BasePage {
    public Navigator(WebDriver wd) {
        super(wd);
    }

    public void google() {
        open("https://www.google.by/");
    }
    
    public void yandex() {
        open("https://yandex.by/");
    }
}
