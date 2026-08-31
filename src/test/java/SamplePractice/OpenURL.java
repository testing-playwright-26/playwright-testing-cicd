package SamplePractice;


import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



public class OpenURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Open URL Test Execution");
		// Initialize Playwright
        try (Playwright playwright = Playwright.create()) {
            // Launch Chromium in headed mode so you can see it run (set to true for headless)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            
         // Start recording video to the specified directory
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
            Browser edge_browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
            // Open a new browser page
            Page page = context.newPage();
            Page edge_page = edge_browser.newPage();
            // Navigate to the desired URL
            page.navigate("https://testautomationpractice.blogspot.com/");
            
            Locator submit_but=page.locator(".submit-btn");
            //submit_but.scrollIntoViewIfNeeded();
            submit_but.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
            page.waitForTimeout(2000);
            
            submit_but.highlight();
            page.waitForTimeout(2000);
            
            submit_but.click();
            page.waitForTimeout(6000); //capture error in the page
            edge_page.navigate("https://www.saucedemo.com/");
            // Fetch and print the title
            String title = page.title();
            String title1 = edge_page.title();
            System.out.println("Saving video relative to: " + System.getProperty("user.dir"));
            System.out.println("The page title in chromium: " + title);
            
            System.out.println("The page title in msedge: " + title1);
            
         // Make sure to close the context so the video file is saved completely// Close the browser
            context.close();
            
         // Close the browser
            browser.close();
            
            
            edge_browser.close();
        }
    }

	}


