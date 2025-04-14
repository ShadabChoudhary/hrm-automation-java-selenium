package com.example.orangehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeeListPage {
    private WebDriver driver;

    private By employeeNameField = By.name("Type for hints");
    private By searchButton = By.xpath("//button[@type='submit']");

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchEmployeeByName(String employeeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement empInput = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField));
        empInput.sendKeys(employeeName);
        driver.findElement(searchButton).click();
    }

    public boolean isEmployeePresent(String employeeName) {
        try {
            return driver.findElement(By.xpath("//td[contains(text(), '" + employeeName + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchFieldVisible() {
        try {
            return driver.findElement(employeeNameField).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
