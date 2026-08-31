package PlaywrightScriptPractice;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.microsoft.playwright.options.MouseButton;

import io.qameta.allure.Allure;
@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetByText_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_GetByText() {
    	
		System.out.println("---Locators Testing---");
    	
      
    	Allure.step("Test script flow started !!!");
    	   	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
    	
    	Allure.step("Navigate to https://testautomationpractice.blogspot.com");
    	Allure.step("*** GetByRole: LINK execution****");
    	Locator link=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PlaywrightPractice"));
    	System.out.println("link "+link.textContent()+" clicked");
        //Locator submit_but=page.locator(".submit-btn");
        //submit_but.scrollIntoViewIfNeeded();
    	link.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.waitForTimeout(2000);
        link.waitFor();
        link.highlight();
        link.click();
        Allure.step("Playwright Link clicked");
        actualTitle=page.title();
           

        System.out.println("Actual title for playwright link:"+actualTitle);
        System.out.println("Expected title for playwright link: " + expectedTitle);

        Allure.step("Expected title after navigation: " +actualTitle);
        Allure.step("Actual title after navigation: " +expectedTitle);
        
        assertEquals(expectedTitle, actualTitle,"Page title mismatch");
       Allure.step("Verified Title match --" + expectedTitle);
       
       Allure.step("*** GetByText: Locator execution****");
       Locator imptxt=page.locator("strong", new Page.LocatorOptions().setHasText("Important"));
       imptxt.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
       imptxt.evaluate("el => el.style.backgroundColor = 'yellow'");
       imptxt.highlight();
       page.waitForTimeout(1000);
       assertTrue(imptxt.isVisible(),"***Strong Text(bold) is not visible***");
       
   	   System.out.println("Strong Text(bold) is visible: "+imptxt.isVisible());
   	   
   	   Allure.step("Strong Text(bold) is visible");
       Locator coltxt = page.locator("[style='color: red']", new Page.LocatorOptions().setHasText("colored text"));
             
       page.waitForTimeout(1000);
       System.out.println("Colored Text(style font) is visible: "+coltxt.isVisible());
     
       assertTrue(coltxt.isVisible(),"***Colored Text(style font) is not visible***");
       
       coltxt.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
       coltxt.highlight();
       coltxt.evaluate("el => el.style.backgroundColor = 'yellow'");
       Allure.step("Colored Text(style font) is visible");
       
    	
       page.waitForTimeout(1000);
       
       Locator item = page.locator("//section[@id='text-locators']/ul/li");
       for(int i=0;i<item.count();i++)
       {
    	   System.out.println("Inner text: "+item.nth(i).innerText());
    	   item.nth(i).evaluate("el => el.style.backgroundColor = 'yellow'");
    	   if(item.nth(i).innerText().contains("List item 2"))
    	   {
    		   item.nth(i).locator("a").click();
    		   System.out.println(item.nth(i).innerText()+" Page title:"+ page.title());
    		   page.waitForTimeout(1000);
    		   page.goBack();    		   
    	   }
    	   page.waitForTimeout(1000);
    	    Allure.step("Inner text: "+item.nth(i).innerText() +" highlighted with yellow background");
       }
	   page.waitForTimeout(1000);
	   Locator button=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit Form"));
	   button.hover();
	   Allure.step("Mouse mov hover on Submit form button");
	   String color = (String) button.evaluate("el => getComputedStyle(el).backgroundColor");
	   System.out.println("Button background color: " + color);
	   Allure.step("Button Colour change to: "+ color);
	   button.click();
	   Allure.step("Clicked on Submit Form button");
	   page.waitForTimeout(1000);
	   System.out.println(page.locator("//section[@id='text-locators']/div[@class='card'][2]/p").textContent());
       //item.evaluateAll("el => el.style.backgroundColor = 'blue'");
       
       //page.waitForTimeout(1000);
}
	
	
	
	
}
