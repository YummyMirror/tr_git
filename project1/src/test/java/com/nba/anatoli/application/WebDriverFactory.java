package com.nba.anatoli.application;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class WebDriverFactory {
    private static final Map<String, Supplier<ThreadLocal<WebDriver>>> browserMap = new HashMap<>();

    private static final Supplier<ThreadLocal<WebDriver>> chromeSupplier = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return ThreadLocal.withInitial(() -> new ChromeDriver(chromeOptions));
    };

    private static final Supplier<ThreadLocal<WebDriver>> ieSupplier = () -> {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        return ThreadLocal.withInitial(InternetExplorerDriver::new);
    };

    private static final Supplier<ThreadLocal<WebDriver>> firefoxSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return ThreadLocal.withInitial(FirefoxDriver::new);
    };

    private static final Supplier<ThreadLocal<WebDriver>> edgeSupplier = () -> {
        WebDriverManager.edgedriver().setup();
        return ThreadLocal.withInitial(EdgeDriver::new);
    };

    static {
        browserMap.put("chrome", chromeSupplier);
        browserMap.put("internet explorer", ieSupplier);
        browserMap.put("firefox", firefoxSupplier);
        browserMap.put("edge", edgeSupplier);
    }

    static synchronized WebDriver create(String browser) {
        WebDriver driver = browserMap.get(browser).get().get();
        if (driver instanceof InternetExplorerDriver) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
