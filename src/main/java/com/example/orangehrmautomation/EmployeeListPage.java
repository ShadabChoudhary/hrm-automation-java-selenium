package com.example.orangehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListPage {
    private WebDriverWait wait;
    private WebDriver driver;

    private By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By employeeRows = By.cssSelector("div.oxd-table-body div[role='row']");

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchEmployeeByName(String employeeName) {
        WebElement empInput = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField));
        empInput.clear();
        empInput.sendKeys(employeeName);
        driver.findElement(searchButton).click();

        //waiting until search result appears
        By employeeRow = By.xpath("//div[@role='row']//div[contains(text(), '" + employeeName + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeRow));
    }

    public boolean isEmployeePresent(String employeeName) {
        String[] parts = employeeName.split(" ");
        String firstName = parts[0].toLowerCase();
        String lastName = parts.length > 1 ? parts[1].toLowerCase() : "";

        List<WebElement> rows = driver.findElements(employeeRows);
        for (WebElement row : rows) {
            String rowText = row.getText().toLowerCase();
            if (rowText.contains(firstName) && rowText.contains(lastName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSearchFieldVisible() {
        try {
            return driver.findElement(employeeNameField).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
