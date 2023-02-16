package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String ACCEPT_COOKIES = "//button[@title=\"Only allow essential cookies\"]";
    public static final String CREATE_NEW_ACCOUNT = "//a[@data-testid=\"open-registration-form-button\"]";
    public static final String FILL_DAY = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public static final String FILL_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public static final String FILL_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(" https://www.facebook.com/");

        WebElement acceptCookies = driver.findElement(By.xpath(ACCEPT_COOKIES));
        acceptCookies.click();

        WebElement createAccount = driver.findElement(By.xpath(CREATE_NEW_ACCOUNT));
        createAccount.click();

        Thread.sleep(2000);

        WebElement fillDay = driver.findElement(By.xpath(FILL_DAY));
        Select selectDay = new Select(fillDay);
        selectDay.selectByIndex(0);

        WebElement fillMonth = driver.findElement(By.xpath(FILL_MONTH));
        Select selectMonth = new Select(fillMonth);
        selectMonth.selectByIndex(0);

        WebElement fillYear = driver.findElement(By.xpath(FILL_YEAR));
        Select selectYear = new Select(fillYear);
        selectYear.selectByIndex(0);
    }
}
