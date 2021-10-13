package pages;

import helpers.StableElementSearch;
import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class LoginPage implements StableElementSearch {

    WebDriver driver;

    By usernameField = By.cssSelector("input#id_username"); // or By.xpath("//input[@id='id_username']")
    By passwordField = By.cssSelector("input#id_password"); // or By.xpath("//input[@id='id_password']")
    By signUpButton = By.xpath("//input[@type='submit']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

//    public LoginPage sendApi() throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//        RequestBody body = RequestBody.create(mediaType, "csrfmiddlewaretoken=VxtzH0TDnpXcahKPzBeYsqCtuAzfPhdC&next=/admin/&password=super_password&this_is_the_login_form=1&username=selenium");
//        Request request = new Request.Builder()
//                .url("https://igorakintev.ru/admin/")
//                .method("POST", body)
//                .addHeader("Upgrade-Insecure-Requests", "1")
//                .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36")
//                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
//                .addHeader("Cookie", "_ym_d=1610636579; _ym_uid=161063657915541878; _ym_isad=1; csrftoken=hAAQxAJuAnS1RrQfdBnU294crACtmvHL; sessionid=fx2pcsz7exp5849qgnrc96514ksxznuq")
//                .build();
//        Response response = client.newCall(request).execute();
//        return new LoginPage(driver);
//    }

    public LoginPage open(String URL) {
        driver.get(URL);
        driver.manage().window().maximize();
        return new LoginPage(driver);
    }

    public LoginPage setUserName(String username) {
        searchElementByCss(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        searchElementByCss(passwordField).sendKeys(password);
        return this;
    }

    public MainPage clickSignUp() {
        searchElementByXpath(signUpButton).click();
        return new MainPage(driver);
    }
}
