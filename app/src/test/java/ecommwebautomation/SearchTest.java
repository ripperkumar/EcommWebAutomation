package ecommwebautomation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommwebautomation.pages.HomePage;
import ecommwebautomation.pages.LauncherPage;

public class SearchTest {
    
@Test
public void verifyIfSearchTermShowsRelevantResults() {
 String searchItem = "Product";
    String searchKey = "Product";
    WebDriver webDriver = null; //Dummy WebDriver declaration
    LauncherPage launcherPage = new LauncherPage(webDriver);
    launcherPage.navigateTo("https://web-playground.ultralesson.com/");

    //Act
    HomePage homepage = new HomePage(webDriver);
    homepage.search(searchItem);
    List<Item> searchItems = homepage.getSearchItems();

    //Assert
    Assert.assertEquals(4, searchItems.size());
    Assert.assertTrue(searchItems.stream().allMatch(item -> item.getName().contains(searchKey)));
 
}
}
