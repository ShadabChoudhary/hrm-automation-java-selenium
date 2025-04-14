package com.example.orangehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for the fields and save button
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By employeeIdField = By.xpath("//label[contains(text(),'Employee Id')]/../following-sibling::div/input");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String firstName, String lastName, String empId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameFieldElement.sendKeys(firstName);

        // Wait for the last name field to be visible
        WebElement lastNameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameFieldElement.sendKeys(lastName);

        if (empId != null && !empId.isEmpty()) {
            WebElement empIdFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField));
            empIdFieldElement.clear();
            empIdFieldElement.sendKeys(empId);
        }

        // Wait for the save button to be clickable, then click it
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButtonElement.click();
    }

    public boolean isSaveButtonVisible() {
        try {
            return driver.findElement(saveButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
