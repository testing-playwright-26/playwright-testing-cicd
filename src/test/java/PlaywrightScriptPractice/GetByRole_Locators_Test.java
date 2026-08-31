package PlaywrightScriptPractice;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class GetByRole_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_GetByRole() {
    	
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
        //String expected_title="Automation Testing Practice: PlaywrightPractice";
        //String OnclickSubmit_expected="Please select both start and end dates.";
        

        System.out.println("Actual title for playwright link:"+actualTitle);
        System.out.println("Expected title for playwright link: " + expectedTitle);

        Allure.step("Expected title after navigation: " +actualTitle);
        Allure.step("Actual title after navigation: " +expectedTitle);
        
        assertEquals(expectedTitle, actualTitle,"Page title mismatch");
        
       Allure.step("Verified Title match --" + expectedTitle);
       
       Allure.step("*** GetByRole: BUTTON execution****");
       Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Primary Action"));

    	System.out.println(button.textContent()+" is Visible: " + button.isVisible());
    	System.out.println(button.textContent()+ "is Enabled: " + button.isEnabled());
       
       if(button.isVisible())
       {
    	   System.out.println(button.textContent()+" is Visible");
    	   Allure.step(button.textContent()+" is Visible");
       }
       else
       {
    	   System.out.println(button.textContent()+" is not Visible");
    	   Allure.step(button.textContent()+ "is not Visible");
       }
        
       
       if(button.isEnabled())
       {
    	   System.out.println(button.textContent()+" is enabled");
    	   Allure.step(button.textContent()+" is enabled");
       }
       
       else
       {
    	   System.out.println(button.textContent()+" is not enabled");
    	   Allure.step(button.textContent()+ "is not enabled");
       }
    
    
	Locator toggle = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Toggle Button"));

	String pressed = toggle.getAttribute("aria-pressed");

	System.out.println(toggle.textContent()+"aria-pressed = " + pressed);
	//assertEquals(true, toggle.getAttribute(pressed),"Toggle is OFF");
	if(pressed.equalsIgnoreCase("true"))
    {
 	   System.out.println(toggle.textContent() +" is enabled");
 	   Allure.step(toggle.textContent() +" is enabled");
    }
    
    else
    {
    	System.out.println(toggle.textContent() +" is disabled");
  	   Allure.step(toggle.textContent() +" is disabled");
    }
    //System.out.println("Test passed!");
	
    Allure.step("*** GetByRole:TEXTBOX execution****");
	
	//Locator username = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile("username", Pattern.CASE_INSENSITIVE)));
	Locator username = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("username"));
	username.click();
	username.fill("Testing Pro 123");
	System.out.println("User name is " +username.inputValue());
	Allure.step("User name is: " +username.inputValue());
	
	Locator AcceptTerms = page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName(Pattern.compile("Accept terms", Pattern.CASE_INSENSITIVE)));
	AcceptTerms.scrollIntoViewIfNeeded();
	AcceptTerms.evaluate("element => element.scrollIntoView({behavior: 'smooth', block: 'center'})"
		);
	AcceptTerms.highlight();
	AcceptTerms.click();
	
	System.out.println(AcceptTerms.textContent() +" is checked");
	Allure.step(AcceptTerms.textContent() +" is checked");
	page.waitForTimeout(2000);
	
	Allure.step("*** GetByRole:MENUITEM execution****");
	
	Locator menuitems = page.getByRole(AriaRole.MENUITEM);
	
	System.out.println("Total menuitem count: "+menuitems.count() );
	for (int i = 0; i < menuitems.count(); i++) {

	    Locator menuitem = menuitems.nth(i);
	    Locator li = menuitem.getByRole(AriaRole.LINK);
	    String litxt=li.innerText();
	    System.out.println("Link innertext: "+li.innerText());
	    String href = li.getAttribute("href");
	    System.out.println("Href: " + li.getAttribute("href"));
	    String resolvedUrl = (String)page.evaluate("(href) => new URL(href, document.baseURI).href", href);
	    System.out.println("resolved url: "+resolvedUrl);
	    Page newTab = page.context().newPage();
	    newTab.navigate(resolvedUrl);
	    
	   
	    //li.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT)); //right click
	    page.waitForTimeout(1000);
	    System.out.println(li.innerText()+ " link(new tab) Title name is "+newTab.title());
	    page.waitForTimeout(1000);
	    Allure.step(li.innerText() +" link Title: "+newTab.title());
	  
	    
	    newTab.close(); 
	    Allure.step(litxt +" link closed ");
	}
	
	
}
	
	
	
	
}
