package com.nba.anatoli.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private WebDriverWait wait;

    public Waiter(WebDriver driver, int timeout) {
        this.wait = new WebDriverWait(driver, timeout);
    }

    public <T> T waitFor(ExpectedCondition<T> condition) {
        return wait.until(condition);
    }
}
