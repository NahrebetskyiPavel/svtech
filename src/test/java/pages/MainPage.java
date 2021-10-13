package pages;

import helpers.StableElementSearch;
import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class MainPage implements StableElementSearch {

    WebDriver driver;

    By addEntry = By.xpath("//a[@href='/admin/blog/entry/add/']");
    By addEntryTitle = By.cssSelector("input#id_title");
    By addEntrySlug = By.cssSelector("input#id_slug");
    By addEntryTextMarkdown = By.cssSelector("textarea#id_text_markdown");
    By addEntryText = By.cssSelector("textarea#id_text");
    By saveButton = By.xpath("//input[@name='_save']");
    By openEntries = By.linkText("Entries");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver setDriver() {
        return this.driver;
    }

    public MainPage open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return new MainPage(driver);
    }


    public MainPage clickButtonAddEntries() {
        searchElementByXpath(addEntry).click();
        return new MainPage(driver);
    }

    public MainPage setTitle(String title) {
        searchElementByCss(addEntryTitle).sendKeys(title);
        return new MainPage(driver);
    }

    public MainPage setSlug(String slug) {
        searchElementByCss(addEntrySlug).clear();
        searchElementByCss(addEntrySlug).sendKeys(slug);
        return new MainPage(driver);
    }

    public MainPage setMarkdown(String markdown) {
        searchElementByCss(addEntryTextMarkdown).sendKeys(markdown);
        return new MainPage(driver);
    }

    public MainPage setText(String text) {
        searchElementByCss(addEntryText).sendKeys(text);
        return new MainPage(driver);
    }

    public MainPage clickSaveButton() {
        searchElementByXpath(saveButton).click();
        return new MainPage(driver);
    }

    public BlogPage openEntries() {
        searchElementByCss(openEntries).click();
        return new BlogPage(driver);
    }

//    public MainPage clickCheckboxLastEntry(){
//        searchElementByXpath(checkBoxLastEntry).click();
//        return this;
//    }

//    public MainPage selectLastEntry() {
//        Select dpEntries = new Select(searchElementByCss(selector));
//        dpEntries.selectByVisibleText("Удалить выбранные Entries");
//        return this;
//    }

}
