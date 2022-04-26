package Non_Member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Login {

    private static WebDriver driver;


    @Test
    public void Login() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/jjong/Documents/Selenium/chromedriver");
        // create chrome instance

        driver = new ChromeDriver();
        driver.get("https://www.kurly.com/");
        sleep(5000);

        //페이지 상단 로그인 버튼 선택
        WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"userMenu\"]/ul/li[2]/a"));
        login_btn.click();
        sleep(1000);

        //아이디 입력
        WebElement id_input = driver.findElement(By.xpath("//*[@id=\"form\"]/input[5]"));
        id_input.sendKeys("jjongqa");
        sleep(1000);

        //패스워드 입력
        WebElement pw_input = driver.findElement(By.xpath("//*[@id=\"form\"]/input[6]"));
        pw_input.sendKeys("whdrhks12!");
        sleep(1000);

        //로그인 버튼 선택
        WebElement login_btn2 = driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
        login_btn2.click();
        sleep(2000);

        //로그인 확인
        WebElement longin_check = driver.findElement(By.xpath("//*[@id=\"userMenu\"]/ul/li[1]/a/span[2]/span[1]"));
        System.out.println(longin_check.getText());
        assert longin_check.getText().equals("안종관") : "기대결과값 :" + longin_check.getText() + "실제결과값 : 로그인 이슈";
        System.out.println("로그인 성공 확인");
        sleep(1000);

    }

    @AfterTest
    public void aftertest() throws InterruptedException {

        sleep(1000);
        driver.quit();
    }
}