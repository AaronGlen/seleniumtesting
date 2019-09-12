package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Admin\\IdeaProjects\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void singleInput() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement enterMessage = driver.findElementById("user-message");
        enterMessage.sendKeys("hello");
        Thread.sleep(5000);
        WebElement showMessage = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        showMessage.click();
        Thread.sleep(5000);
    }

    @Test
    public void twoInput() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement enterSum1 = driver.findElementById("sum1");
        enterSum1.sendKeys("1");
        Thread.sleep(5000);
        WebElement enterSum2 = driver.findElementById("sum2");
        enterSum2.sendKeys("2");
        Thread.sleep(5000);
        WebElement add = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
        add.click();
        Thread.sleep(5000);


    }


    @Test
    public void searchTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures");
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement linkToBiggerPicture = driver.findElementByLinkText("Images for funny cat");
        linkToBiggerPicture.click();
        Thread.sleep(5000);
        WebElement linktoPicture = driver.findElementById("npeDyM3edUSkxM:");
        linktoPicture.click();
        Thread.sleep(5000);



    }
    @Test
    public void singleCheckOut() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkBox = driver.findElementById("isAgeSelected");
        checkBox.click();
        Thread.sleep(5000);


    }

    @Test
    public void multiCheckOut() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkAll = driver.findElementById("check1");
        checkAll.click();
        Thread.sleep(5000);
        WebElement check = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input"));
        check.click();
        Thread.sleep(5000);



    }
    @Test
    public void checkGender() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement checkGender = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
        checkGender.click();
        Thread.sleep(5000);
        WebElement checkValue = driver.findElementById("buttoncheck");
        checkValue.click();
        Thread.sleep(5000);

    }
    @Test
    public void GroupRadioButtons() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement checkGender = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
        checkGender.click();
        Thread.sleep(5000);
        WebElement checkAge = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[3]/input"));
        checkAge.click();
        Thread.sleep(5000);
        WebElement buttonGetValues = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
        buttonGetValues.click();
        Thread.sleep(5000);



    }
    @Test
    public void selectList() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Thread.sleep(2000);
        WebElement checkValue = driver.findElementById("select-demo");
        checkValue.click();
        Thread.sleep(5000);
        WebElement getDay = driver.findElement(By.xpath("//*[@id=\"select-demo\"]/option[3]"));
        getDay.click();
        Thread.sleep(5000);
    }

    @Test
    public void multiSelectList() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Thread.sleep(2000);

        Select days = new Select(driver.findElementById("multi-select"));

        days.selectByValue("California");
        days.selectByIndex(2);
        days.selectByIndex(1);
        Thread.sleep(5000);
        WebElement checkValues = driver.findElementById("printAll");
        checkValues.click();
        Thread.sleep(5000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Thread.sleep(2000);

        WebElement drag1 = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
        WebElement box = driver.findElementById("mydropzone");
        new Actions(driver).dragAndDrop(drag1, box).perform();
        Thread.sleep(5000);

    }

    @Test
    public void dragSlider() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        Thread.sleep(2000);
        Actions drag = new Actions(driver);
        WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"slider1\"]/div/input"));
        drag.dragAndDropBy(slider1, 20,0).perform();
        Thread.sleep(2000);
        WebElement slider2= driver.findElement(By.xpath("//*[@id=\"slider2\"]/div/input"));
        drag.dragAndDropBy(slider2, -70,0).perform();
        Thread.sleep(2000);



    }
}