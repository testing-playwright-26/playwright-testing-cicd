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
public class Pagination_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
    
    //Find the currently active page → inspect only that page's product rows → find product → click the checkbox in that row.
	@Test
	@Order(1)
    void Locators_activePageSearch() {
		
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
        
        Allure.step("*** Pagination Execution***");
        System.out.println("***Pagination Execution***");
        Locator TotalPages=page.locator("ul#pagination li");
        System.out.println("Total Pages: "+TotalPages.count());
        
        Locator totalrows=page.locator("table#productTable tbody tr");
        System.out.println("Total rows: "+totalrows.count());
      // 
    	//System.out.println("Active page: " + TotalPages.innerText());
        for(int i=0;i<TotalPages.count();i++)
        {
        	
        	Locator activePage=TotalPages.locator("a.active");
            
        	if(activePage.isEnabled())
        	{
        	       for(int j=0;j<totalrows.count();j++)
        	      {
        		  
        	    	   Locator row=totalrows.nth(j);
        	   
        	    	   if(row.innerText().contains("Smart"))
        	    	   {
       			
        		    Locator colms=totalrows.nth(j).locator("td");
        		    Locator checkbox=colms.locator("input[type='checkbox']");
        		    checkbox.scrollIntoViewIfNeeded();
        		    checkbox.check();
        		    page.waitForTimeout(3000);  
        	        //System.out.println("Smartphone checkbox selected");

        	        
        		   
       		           }
        		
        	    	   //break; //exit from row loop
        	      }
        		
        	   }
              
         break;    //exit pagination loop
        }
        
     
    page.waitForTimeout(2000);       
        

	
	
	}
	
	@Test
	@Order(2)
   void Locators_allPageSearch() {
		
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
        
        Allure.step("*** Pagination Execution***");
        System.out.println("***Pagination Execution***");
        Locator TotalPages=page.locator("ul#pagination li");
        System.out.println("Total Pages: "+TotalPages.count());
        
        Locator totalrows=page.locator("table#productTable tbody tr");
        System.out.println("Total rows: "+totalrows.count());
      // 
    	//System.out.println("Active page: " + TotalPages.innerText());
        for(int i=0;i<TotalPages.count();i++)
        {
        	
        	boolean productFound=false;
        	
        	       for(int j=0;j<totalrows.count();j++)
        	      {
        		  
        	    	   Locator row=totalrows.nth(j);
        	   
        	    	   if(row.innerText().contains("Desktop Computer"))
        	    	   {
       			
        		    Locator colms=totalrows.nth(j).locator("td");
        		    Locator checkbox=colms.locator("input[type='checkbox']");
        		    checkbox.scrollIntoViewIfNeeded();
        		    checkbox.check();
        		    page.waitForTimeout(3000);  
        	        //System.out.println("Smartphone checkbox selected");

        		    productFound=true;
        		   
       		           }
        		
        	    	
        	        }
        	       
        	    
        	       if (productFound) {
        	           break;       // ← exit PAGINATION loop
        	       }
        
        	       TotalPages.nth(i).locator("a").click();
        	       System.out.println("Page no: "+TotalPages.nth(i).locator("a").innerText());
        	       page.waitForTimeout(2000); 
        }
        
     
    
        
        page.waitForTimeout(2000);       
        

	
	
	}
	
}
