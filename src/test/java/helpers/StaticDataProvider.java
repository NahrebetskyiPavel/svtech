package helpers;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @BeforeGroups(value = {"SmokeSingUp"})
    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{{"selenium", "super_password"}};
    }

    @BeforeGroups(value = {"testActionsWithEntries"})
    @DataProvider(name = "entryFields")
    public Object[][] entryFields() {
        return new Object[][]
                {{"Title56435235", "Slug56435235", "Markdown56435235", "Text56435235"}};
    }

}
