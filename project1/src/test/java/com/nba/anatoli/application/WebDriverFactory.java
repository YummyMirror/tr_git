package com.nba.anatoli.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class WebDriverFactory {
    private static final Map<String, Supplier<WebDriver>> browserMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);
    };

    private static final Supplier<WebDriver> ieSupplier = () -> {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        return new InternetExplorerDriver(ieOptions);
    };

    static {
        browserMap.put("chrome", chromeSupplier);
        browserMap.put("internet explorer", ieSupplier);
    }

    static synchronized WebDriver create(String browser) {
        ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
        webDriverThreadLocal.set(browserMap.get(browser).get());
        WebDriver driver = webDriverThreadLocal.get();
        if (driver instanceof InternetExplorerDriver) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
