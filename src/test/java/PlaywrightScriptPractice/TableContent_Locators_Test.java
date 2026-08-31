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
public class TableContent_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_TableContent() {
		
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
        
        Allure.step("*** Reading Table values***");
        System.out.println("***Reading Table values***");
        Locator tablerows=page.locator("//table[@name='BookTable']/tbody/tr");
        System.out.println("No of rows: " + tablerows.count());
        for(int i=0;i<tablerows.count();i++)
        {
        	
        	//System.out.println("row content: " + tablerows.nth(i).textContent());
        	
        	Locator colms=tablerows.nth(i).locator("td");
        	
        	 System.out.println("No of colms: " + colms.count());
        	 
        	 
        	 
        	 
        	    
        	 for (int j = 0; j < colms.count(); j++) {

        	        String bookname = colms.nth(j).innerText();

        	        if (bookname.contains("Master In Selenium")) {

        	            String author = colms.nth(1).innerText();

        	            assertEquals(
        	                "Mukesh",
        	                author,
        	                "Author mismatch for Playwright"
        	            );
        	            
        	            Allure.step("***Author name for a specific book is verified**");
        	        }
        	 
        	 }
        	 
        }
        
        
         page.waitForTimeout(5000);
        
        
}
	
	
	
	
}
