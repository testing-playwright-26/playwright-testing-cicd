package SamplePractice;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import AutomationPracticePlayWright.TestListener;
import io.qameta.allure.Allure;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestListener.class)
public class SampleTest{
	
	static Playwright playwright;
    static Browser browser;
    static Page page;
    static BrowserContext context;
    
    @BeforeAll
    static void launchBrowser() {
        
    	System.out.println("---BeforeAll---");
    	playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        
       
    }

    @AfterAll
    static void closeBrowser() {
    	System.out.println("----AfterAll---");
    	//playwright.close();
    	if (browser != null) 
    	{
            browser.close();
        }
    	
    	if (playwright != null) 
    	{
            playwright.close();
        }
    	//playwright.close();
    	
    	
    	System.out.println("----****************------- ");
    	System.out.println("----****************------- ");
    }
    
    @BeforeEach
    void createContextAndPage() {
    
    	System.out.println("---BeforeEach----");
    	Allure.step("Browser Launch successfully");  
    	context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
    	Allure.step("Create browser context");   
        page = context.newPage();
        Allure.step("Create New Page object");
        page.setDefaultNavigationTimeout(60000);
        
        
    }
    
    @AfterEach
    void closeContext() {
    	System.out.println("----AfterEach------");
    	if (page != null) {
    		Allure.step("Page object closed");
    		page.close();
        }
        if (context != null) {
        	Allure.step("Context browser object closed");
        	context.close(); // Flushes trace files and reports cleanly
        }
    }
    
    @Test
    void testPlaywrightHomepage() {
    	System.out.println("---Test---");
    	
    	Allure.step("Test script flow started !!!");
    	System.out.println("Before Navigate");
    	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
    	System.out.println("Before Navigate");
    	
    	Allure.step("Navigate to https://testautomationpractice.blogspot.com");
    	
        Locator submit_but=page.locator(".submit-btn");
        //submit_but.scrollIntoViewIfNeeded();
        submit_but.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.waitForTimeout(2000);
        submit_but.waitFor();
        submit_but.highlight();
        
        
        submit_but.click();
        Allure.step("Click Submit button");
        String title = page.title();
        System.out.println("Title obtained: " + title);

       assertTrue(title.contains("Automation"));
       Allure.step("Verify page title" +title);
     
        
       System.out.println("Test passed!");
    }

	
    
}
