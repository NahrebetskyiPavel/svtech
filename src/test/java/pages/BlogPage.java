package pages;

import helpers.StableElementSearch;
import helpers.StaticDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage implements StableElementSearch {
    WebDriver driver;


    By submitButton = By.cssSelector("input[type='submit']");
    By deleteButton = By.cssSelector("a[class='deletelink']");
    By lastCreatedEntry = By.linkText("Title56435235"); //поменять в случае замены входных параметров dataProvider


//    By checkBoxLastEntry = By.xpath("//td//input[@value='']"); // or By.cssSelector("input.action-select[value='']")
//    By selector = By.cssSelector("select");
//    By executeButton = By.cssSelector("button.button");

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }


    public BlogPage clickLastCreatedEntry(String title) {
        driver.findElement(lastCreatedEntry).click();
        return new BlogPage(driver);
    }

    public BlogPage deleteLastEntry() {
        searchElementByCss(deleteButton).click();
        return this;
    }

    public MainPage submitDeleteEntry() {
        searchElementByCss(submitButton).click();
        return new MainPage(driver);
    }

}
