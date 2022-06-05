package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AppTest {

  private ChromeDriver driver;
  private String texto;

  @Before
  public void inicializa() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void acessar() {

    WebDriverWait wait = new WebDriverWait(driver,5);

    driver.get("https://www.facebook.com/");
    Assert.assertEquals("Facebook – entre ou cadastre-se", driver.getTitle());
  }

  @Test
  public void logar() {

    WebDriverWait wait = new WebDriverWait(driver,5);

    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).sendKeys("Testzappts QA");
    driver.findElement(By.id("pass")).sendKeys("@ZapptsTesteQA12");
    driver.findElement(By.name("login")).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")));

    Assert.assertEquals("Bem-vindo ao Facebook, Testzappts", driver.findElement(By.xpath("//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 qg6bub1s iv3no6db o0t2es00 f530mmz5 hnhda86s oo9gr5id']")).getText());
  }

  @Test
  public void logarError() {

    WebDriverWait wait = new WebDriverWait(driver,5);

    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).sendKeys("Testzappts QA2");
    driver.findElement(By.id("pass")).sendKeys("@ZapptsTesteQA123");
    driver.findElement(By.name("login")).click();

   Assert.assertEquals("Encontre sua conta e entre.", driver.findElement(By.cssSelector("a[href='https://facebook.com/login/identify/']")).getText());
  }


  @Test
  public void logarErrorSenha() {

    WebDriverWait wait = new WebDriverWait(driver,5);

    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).sendKeys("Testzappts QA");
    driver.findElement(By.name("login")).click();

    Assert.assertEquals("Encontre sua conta e entre.", driver.findElement(By.cssSelector("a[href='https://facebook.com/login/identify/']")).getText());
  }

  @Test
  public void logarErrorLogin() {

    WebDriverWait wait = new WebDriverWait(driver,5);

    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("pass")).sendKeys("@ZapptsTesteQA123");
    driver.findElement(By.name("login")).click();

    Assert.assertEquals("Encontre sua conta e entre.", driver.findElement(By.cssSelector("a[href='https://facebook.com/login/identify/']")).getText());
  }

  @After
  public void afterCenario(){
    driver.quit();
  }
  }

