package com.nba.anatoli.page;

import com.nba.anatoli.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePO extends BasePage {
    public GooglePO(WebDriver wd) {
        super(wd);
    }

    public void searchFor(String query) {
        input(By.name("q"), query);
        pressEnterKey();
    }
}
