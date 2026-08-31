package AutomationPracticePlayWright;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.qameta.allure.Allure;

public class BaseTest {
	
	
	static Playwright playwright;
    static Browser browser;
    static Page page;
    static BrowserContext context;
    
    @BeforeAll
    static void launchBrowser() {
    	System.out.println("----****************------- ");
    	System.out.println("----****************------- ");
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
        
        System.out.println("BaseTest.page = " + BaseTest.page);
        System.out.println("page          = " + page);
        System.out.println("BaseTest class = " + BaseTest.class.getName());
        
        
    }
    
    @AfterEach
    void closeContext() {
    	System.out.println("----AfterEach----- ");
    	
    	if (page != null) {
    		Allure.step("Page object closed");
    		page.close();
        }
        if (context != null) {
        	Allure.step("Context browser object closed");
        	context.close(); // Flushes trace files and reports cleanly
        }
    }
    

}
