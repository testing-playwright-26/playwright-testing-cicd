package PlaywrightScriptPractice;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.nio.file.Path;
import java.nio.file.Paths;
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
public class BrokenLinks_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
    
    //script to execute broken links
	@Test
	@Order(1)
    void Locators_BrokenLinks() throws InterruptedException {
		
		//getByAltText.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.evaluate("window.scrollTo(0, 500)");
        //imptxt.evaluate("el => el.style.backgroundColor = 'yellow'");
    	
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
        
        Allure.step("*** Broken link Execution***");
        System.out.println("***Broken link Execution***");
        Locator Totallinks=page.locator("div#broken-links a");
        
       // Totallinks.waitFor(); waits for single locator
        Totallinks.first().waitFor(); //waits for multiple locator ref for atleast first one
        int total=Totallinks.count();
        System.out.println("Total broken links: "+total);
        
       
        
        List<String> brokenlinks=new ArrayList<>();
        List<String> brokenlink_errorcode=new ArrayList<>();
        
        
       
        for(int i=0;i<Totallinks.count();i++)
        {
        	Locator blink=Totallinks.nth(i);
        	String innertxt=blink.innerText();
        	String href=blink.getAttribute("href");
        	brokenlinks.add(innertxt);
        	brokenlinks.add(href);
        	blink.click();
        	String title=page.title();
        	String errorcode=page.locator("Body").textContent();
        	System.out.println(innertxt+ " Title: " +title);
        	System.out.println(innertxt+ "Body content: " +errorcode);
        	brokenlink_errorcode.add(title);
        	brokenlink_errorcode.add(errorcode);
        	page.waitForTimeout(500);  // only to watch the error page

        	page.goBack();
        }
        
        for(int j=0;j<brokenlinks.size();j++)
        {
        	System.out.println(brokenlinks.get(j));
        }
        
        for(int j=0;j<brokenlink_errorcode.size();j++)
        {
        	System.out.println(brokenlink_errorcode.get(j));
        }
    
      
        

	
	
	}
	
	
	
}
