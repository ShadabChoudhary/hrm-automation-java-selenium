package com.example.orangehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By logoutDropdown = By.className("oxd-userdropdown-tab");
    private By logoutButton = By.xpath("//a[@href='/web/index.php/auth/logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutDropdown)).click();

        // Wait until logout option is visible, then click
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    public boolean isLogoutButtonVisible() {
        try {
            return driver.findElement(logoutButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
