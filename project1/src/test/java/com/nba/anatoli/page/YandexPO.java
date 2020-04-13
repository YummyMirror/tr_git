package com.nba.anatoli.page;

import com.nba.anatoli.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPO extends BasePage {
    public YandexPO(WebDriver wd) {
        super(wd);
    }

    public void searchFor(String query) {
        input(By.id("text"), query);
        pressEnterKey();
    }
}
