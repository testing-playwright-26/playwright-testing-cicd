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
public class GetByTestID_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_GetByTestID() {
    	
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
        
        Locator getByAltText=page.getByText("getByTestId()");
        getByAltText.scrollIntoViewIfNeeded();
        //getByAltText.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.evaluate("window.scrollTo(0, 500)");
        //imptxt.evaluate("el => el.style.backgroundColor = 'yellow'");
        page.waitForTimeout(1000);
        Allure.step("*** getByTestID Test execution****");
        Locator profilename=page.getByTestId("profile-name");
      
        System.out.println("Profile name: "+  profilename.textContent());
        Locator profilemail=page.getByTestId("profile-email");
        
        System.out.println("Profile email: "+ profilemail.textContent());
        
        Locator profiledit=page.getByTestId("edit-profile-btn");
        profiledit.click();
        Locator productgrid=page.getByTestId("product-grid");
        Locator tot_products=productgrid.locator("div.card");
        System.out.println("Total data-Products"+ tot_products.count());
        for(int i=0;i<tot_products.count();i++)
        {
        	String productname=tot_products.nth(i).getByTestId("product-name").textContent();
        	String productprice=tot_products.nth(i).getByTestId("product-price").textContent();
        	System.out.println("Product name: "+productname);
        	Allure.step("Product name: "+productname);
        	System.out.println("Product price: "+productprice);
        	Allure.step("Product price: "+productprice);
        }
        
         Locator mainnag=page.getByTestId("main-navigation");
         //mainnag.scrollIntoViewIfNeeded();
         mainnag.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
         Locator lists=mainnag.locator("[data-testid]");
         System.out.println("Total list: "+lists.count());
         for(int i=0;i<lists.count();i++)
         {
        	 Locator list=lists.nth(i).getByRole(AriaRole.LINK);
        	 list.highlight();
        	 list.evaluate("el => el.style.backgroundColor = 'yellow'");
        	 String name=list.textContent();
        	 System.out.println("Link text name: "+name);
        	 list.click();
        	 System.out.println(name + " Title: "+page.title());
        	 
        	 page.goBack();
        	 page.waitForTimeout(1000);
        	 
         }
        
        page.getByTitle("Back to top").click();
        
        
        page.waitForTimeout(3000);
}
	
	
	
	
}
