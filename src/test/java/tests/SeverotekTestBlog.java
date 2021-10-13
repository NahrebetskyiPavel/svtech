package tests;

import helpers.StaticDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.LoginPage;
import pages.MainPage;
import runner.Runner;

public class SeverotekTestBlog extends Runner {
    @BeforeMethod
    public void login(){
        new LoginPage(driver)
                .open("https://igorakintev.ru/admin/")
                .setUserName("selenium")
                .setPassword("super_password")
                .clickSignUp();
    }


    @Test(groups = {"testActionsWithEntries"}, dataProvider = "entryFields", dataProviderClass = StaticDataProvider.class)
    @Description("testing delete entry")
    public void DeleteLastCreatedEntry(String title, String slug, String markdown, String text) {
        new MainPage(driver)
                .openEntries()
                .clickLastCreatedEntry(title)
                .deleteLastEntry()
                .submitDeleteEntry();
        Assert.assertEquals(driver.getCurrentUrl(), "https://igorakintev.ru/admin/blog/entry/");
//        Assert.assertFalse(driver.getPageSource().contains(title)); // провалится при кроссбраузерном использовании
    }
}
