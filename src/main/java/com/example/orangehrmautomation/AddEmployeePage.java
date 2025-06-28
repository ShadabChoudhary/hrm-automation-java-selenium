package com.example.orangehrmautomation;

import org.openqa.selenium.*;
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
    private By saveButton = By.cssSelector("button[type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addEmployee(String firstName, String lastName, String empId) {
        System.out.println("Waiting for First Name field...");
        WebElement firstNameFieldElement = wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameFieldElement.clear();
        firstNameFieldElement.sendKeys(firstName);

        System.out.println("Waiting for Last Name field...");
        WebElement lastNameFieldElement = wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        lastNameFieldElement.clear();
        lastNameFieldElement.sendKeys(lastName);

        if (!empId.isEmpty()) {
            System.out.println("Waiting for Employee ID field...");
            WebElement empIdFieldElement = wait.until(ExpectedConditions.elementToBeClickable(employeeIdField));
            empIdFieldElement.clear();
            empIdFieldElement.sendKeys(empId);
        }

        System.out.println("Waiting for Save button...");
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButtonElement);
        saveButtonElement.click();
        System.out.println("Clicked Save");

        // ⏱ Wait for a few seconds after clicking save
        try {
            Thread.sleep(5000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSaveButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
