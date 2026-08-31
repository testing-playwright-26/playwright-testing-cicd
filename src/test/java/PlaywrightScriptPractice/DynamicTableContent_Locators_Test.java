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
public class DynamicTableContent_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_DynamicTableContent() {
		
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
        
        Allure.step("*** Dynamic Reading of Table values***");
        System.out.println("***Dynamic Reading of Table values***");
        Locator tableheaders=page.locator("//table[@id='taskTable']/thead/tr/th");
        Locator tablerows=page.locator("//table[@id='taskTable']/tbody/tr");
        List<String> headerValues = new ArrayList<>();
        List<List<String>> rowValues = new ArrayList<>();
        //tableheaders.scrollIntoViewIfNeeded();
        //String nameHeader,CPUHeader, DiskHeader, NetworkHeader, MemoryHeader;
        
        tableheaders.first().waitFor();
        System.out.println("Table header count: "+tableheaders.count());
        
        for(int i=0;i<tableheaders.count();i++) 
        {
        	headerValues.add(tableheaders.nth(i).innerText());
        }
        
       
       for(int r=0;r<tablerows.count();r++)
       {
    	   Locator col=tablerows.nth(r).locator("td");
    	   List<String> currentrow= new ArrayList<>();
    	   
    	   for(int c=0;c<col.count();c++)
    	   {
    		   currentrow.add(col.nth(c).innerText());
    		   
    	   }
    			 
    	   rowValues.add(currentrow);
    	   
      
       }
       
        
       for(List<String>row:rowValues)
       {
    	   if (row.contains("Chrome"))
    		   
    	   {
    		   
    		   Locator col = tablerows.nth(rowValues.indexOf(row)).locator("td");
    		   
    		  for(int h=0; h<headerValues.size();h++)
    		  {
    			  if(headerValues.get(h).contains("Network"))
    				  
    				  
    			  {
    				  
    				  
    				  String Network=row.get(h);// getting cell content of matching row value
    				  Locator networkCell = col.nth(h);

    	                networkCell.scrollIntoViewIfNeeded();
    				 
    				 

    				    page.waitForTimeout(5000);
    				    Locator chromeNetworkUI = page.locator("strong.chrome-network");
    				    String uiNetwork = chromeNetworkUI.innerText();
    				    System.out.println("Table Network : " + Network);
    				    System.out.println("UI Network    : " + uiNetwork);
    				    assertEquals(
    				    	    Network,
    				    	    uiNetwork,
    				    	    "Chrome Network value mismatch between table and UI"
    				    	);
    				  /*
    				   
    				   Column position changes → find the header dynamically.
Cell value changes at runtime → validate its expected condition/rule.
Fixed business value → assertEquals().
Dynamic/live value → assertTrue() / range / format validation.
    				   */
          	            
          	            Allure.step("***Assertion for Dynamic network value for Chrome verified**");
    			  }
    		  }
    	   }
       }
        
         page.waitForTimeout(5000);
        
        
}
	
	
	
	
}
