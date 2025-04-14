package com.example.orangehrmautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    static WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PIMPage pimPage;
    AddEmployeePage addEmployeePage;
    EmployeeListPage employeeListPage;

    @BeforeAll
    public static void setUpAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @BeforeEach
    public void setUp(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        addEmployeePage = new AddEmployeePage(driver);
        employeeListPage = new EmployeeListPage(driver);
    }

    @Test
    public void testLogin(){
        loginPage.login("Admin", "admin123");
        String title = driver.getTitle();
        Assertions.assertTrue(dashboardPage.isLogoutButtonVisible(), "Login failed - Dashboard not visible");
    }

    @Test
    public void testNavigateToPIM(){
        pimPage.navigateToPIMPage();
        Assertions.assertTrue(pimPage.isPIMPageVisible(), "PIM page is not visible after navigation");
    }

    @Test
    public void testAddMultipleEmployees() {
        String[][] employeeData = {
                {"Shadab", "Choudhary", "01095"},
                {"Shadab", "Khan", "01096"},
                {"Shadab", "Shaikh", "01097"},
                {"Shadab", "Malik", "01098"}
        };

        // Loop through the employee data and add employees
        for (String[] employee : employeeData) {
            String firstName = employee[0];
            String lastName = employee[1];
            String empId = employee[2];

            // Click the Add Employee link and wait for the page to load
            AddEmployeePage addEmployeePage = pimPage.clickAddEmployee();
            Assertions.assertTrue(addEmployeePage.isSaveButtonVisible(), "Add Employee page is not visible");

            // Add employee details
            addEmployeePage.addEmployee(firstName, lastName, empId);
        }
    }


    @Test
    public void testEmployeeListPage(){
        employeeListPage.searchEmployeeByName("Shadab Choudhary");
        Assertions.assertTrue(employeeListPage.isEmployeePresent("Shadab Choudhary"),
                                                            "Employee not found int the List");
    }

    @Test
    public void testLogout() {
        dashboardPage.logout();
        String title = driver.getTitle();
        Assertions.assertTrue(loginPage.isLoginButtonVisible(), "Logout failed - Login button not visible");
    }

    @AfterAll
    public static void tearDownAll() {
        driver.quit();
    }
}
