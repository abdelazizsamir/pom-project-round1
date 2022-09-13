package tests;

import fileReaderManager.ReadFromFiles;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationBarPage;
import pages.ProductDetailsPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;


public class ProductDetailsTests extends BaseTests_Parent{
    String productDetailsTestData = "productdetails.json" ;
    NavigationBarPage navigationBarPage;
    String productTitle ;
    @BeforeClass
    public void loadTestData ()
    {
        productTitle = getJsonValueByKey ( productDetailsTestData, "productName") ;
    }
//    @BeforeMethod
//    public void loginToApp ()
//    {
//        navigationBarPage = new NavigationBarPage(driver);
//        LoginPage loginPage = navigationBarPage.clickLoginFromNavigationBar();
//        loginPage.loginToAppWithValidCredentials((String) ReadFromFiles.getPropertyByKey("configData.properties"
//                        , "EMAIL"),
//                (String) ReadFromFiles.getPropertyByKey("configData.properties" , "PASSWORD"));
//    }


    @Test
    public void checkProductDetailsDisplayed ()
    {
        navigationBarPage = new NavigationBarPage(driver);
        ProductDetailsPage productDetailsPage = navigationBarPage.searchForProduct(productTitle);
        Assert.assertEquals(productDetailsPage.getProductTitle(), productTitle );
    }
}
