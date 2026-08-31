package PlaywrightScriptPractice;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.MouseButton;

import io.qameta.allure.Allure;
@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetByTitle_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_GetByTitle() {
    	
		System.out.println("---Locators Testing---");
    	
       	Allure.step("Test script flow started !!!");
    	   	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(1000);
    	Allure.step("Navigate to https://testautomationpractice.blogspot.com");
    	
    	
    	Locator link=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PlaywrightPractice"));
    	link.click();
    	System.out.println("link "+link.textContent()+" clicked");
    	Allure.step("*** Playwright option clicked****");
    	actualTitle=page.title();
    	System.out.println("Actual title after clicking playwright option:"+actualTitle);
        System.out.println("Expected title for playwright link: " + expectedTitle);

        Allure.step("Expected title after navigation: " +actualTitle);
        Allure.step("Actual title after navigation: " +expectedTitle);
        
        assertEquals(expectedTitle, actualTitle,"Page title mismatch");
        Allure.step("Verified Title match --" + expectedTitle);
        
        Locator getByAltText=page.getByText("getByTitle()");
        getByAltText.scrollIntoViewIfNeeded();
        //getByAltText.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.evaluate("window.scrollTo(0, 500)");
        //imptxt.evaluate("el => el.style.backgroundColor = 'yellow'");
        page.waitForTimeout(1000);
        Allure.step("*** getByTitle Test execution****");
         Allure.step("Clicked on Playwirght Logo");
        Locator titleHome=page.getByTitle("Home page link");
        String hometxt=titleHome.textContent();
        System.out.println(" Title txt: "+hometxt);
        //assertTrue(imptxt.isVisible(),"***Strong Text(bold) is not visible***");
        assertThat(titleHome).hasText("Home"); //playwright assertion
        assertTrue(hometxt.contains("Home"),"***Expected text is available***"); //java
       //locate all elements with title attribute
        Locator titles_card=page.locator("//div[@class='card']/ul");
        Locator titles=titles_card.locator("[title]");
        for(int i=0;i<titles.count();i++)
        {
        	
        	String titletxt=titles.nth(i).getAttribute("title");
        	//Locator title=titles.nth(i).getByTitle(titletxt);
        	Locator title=titles_card.getByTitle(titletxt);
        	/*
        	Locator element=page.getByTitle(titletxt);
        	
        	element.hover();
        	element.highlight();
        	element.evaluate("el => el.style.backgroundColor = 'yellow'");
        	*/
        	System.out.println("Title txt: "+titletxt);
        	
        	title.evaluate("el => el.style.backgroundColor = 'yellow'");
        	page.waitForTimeout(1000);
        }
        
        page.getByTitle("Click to save your changes").click();
        
        page.waitForTimeout(3000);
}
	
	
	
	
}
