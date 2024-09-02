package configurarNevegador;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class AccesosTest {
    protected WebDriver driver;

    @BeforeTest
        public void setupDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\soufy\\IdeaProjects\\PruebaTecnicaAbdel\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
        this.driver.quit();
    }

}
