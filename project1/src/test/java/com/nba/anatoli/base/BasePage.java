package com.nba.anatoli.base;

import com.nba.anatoli.helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class BasePage {
    protected WebDriver wd;
    protected Waiter wait;
    protected Actions actions;

    public BasePage(WebDriver wd) {
        this.wd = wd;
        this.wait = new Waiter(wd, 10);
        this.actions = new Actions(wd);
    }

    protected void open(String url) {
        if (url != null && !url.isEmpty()) {
            if (!wd.getCurrentUrl().equals(url)) {
                wd.navigate().to(url);
                wait.waitFor(urlContains(url));
            }
        }
    }

    protected void input(By locator, String value) {
        if (value != null && !value.isEmpty()) {
            WebElement element = wd.findElement(locator);
            if (!element.getAttribute("value").equals(value)) {
                element.click();
                element.clear();
                element.sendKeys(value);
            }
        }
    }

    protected void click(By locator) {
        wait.waitFor(elementToBeClickable(locator)).click();
    }

    protected void pressEnterKey() {
        actions.sendKeys(ENTER)
               .build()
               .perform();
    }

    protected boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }
}
