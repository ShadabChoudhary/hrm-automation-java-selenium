package com.example.orangehrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListButton = By.xpath("//a[normalize-space()='Employee List']");
    private By addEmployeeButton = By.xpath("//a[normalize-space()='Add Employee']");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPIMPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pimMenuElement = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        pimMenuElement.click();
    }

    public AddEmployeePage clickAddEmployee() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addEmployeeBtn = wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));
        addEmployeeBtn.click();

        return new AddEmployeePage(driver);
    }

    public void clickEmployeeList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement listBtn = wait.until(ExpectedConditions.elementToBeClickable(employeeListButton));
        listBtn.click();
    }

    public boolean isPIMPageVisible() {
        try {
            WebElement pimPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pimPageId")));
            return pimPage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
