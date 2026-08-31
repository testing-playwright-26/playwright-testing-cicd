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
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.MouseButton;

import io.qameta.allure.Allure;
@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetByLabel_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_GetByLabel() {
    	
		System.out.println("---Locators Testing---");
    	
      
    	Allure.step("Test script flow started !!!");
    	   	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(2000);
    	
    	Allure.step("Navigate to https://testautomationpractice.blogspot.com");
    	Allure.step("*** GetByLabel: Test execution****");
    	
    	Locator link=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PlaywrightPractice"));
    	
    	
    	System.out.println("link "+link.textContent()+" clicked");
        //Locator submit_but=page.locator(".submit-btn");
        //submit_but.scrollIntoViewIfNeeded();
    	
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
       Locator getbylabel=page.getByText("getByLabel()", new Page.GetByTextOptions().setExact(true));
       getbylabel.scrollIntoViewIfNeeded();
       //getbylabel.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
       Allure.step("*** GetByLabel: Locator execution****");
    	page.getByLabel("Email Address:").fill("TestingPro@email.com");
    	System.out.println(page.getByLabel("Email Address: ").inputValue());
    	page.waitForTimeout(1000);
    	
    	page.getByLabel("Password").fill("testingpro123");
    	System.out.println(page.getByLabel("Password: ").inputValue());
    	page.waitForTimeout(1000);
    	Locator age=page.getByLabel("Your Age:");
    	age.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
    	page.getByLabel("Your Age:").fill("44");
    	System.out.println(page.getByLabel("Your Age: ").inputValue());
    	page.waitForTimeout(1000);
    	//Locator standard=page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("standard"));
    	//standard.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
    	//standard.click();
    	//Locator group=page.getByRole(AriaRole.GROUP, new Page.GetByRoleOptions().setName("Shipping Method"));
    	Locator group = page.locator("fieldset").filter(new Locator.FilterOptions().setHasText("Shipping Method"));
    	Locator radio=group.getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName("express"));
    	//group.scrollIntoViewIfNeeded();
    	BoundingBox after = radio.boundingBox();
    	//System.out.println("Before: " + radio.boundingBox());
    	System.out.println("Before: x=" + after.x + ", y=" + after.y +", width=" + after.width +", height=" + after.height);
    	System.out.println("Before URL: " + page.url());
    	System.out.println("Before scroll: " + page.evaluate("window.scrollY"));
    	radio.check();
    	//group.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
    	System.out.println("Tag: " +
    		    radio.evaluate("el => el.tagName"));

    		System.out.println("HTML: " +
    		    radio.evaluate("el => el.outerHTML"));
    		System.out.println("After URL: " + page.url());
    		System.out.println("After scroll: " + page.evaluate("window.scrollY"));
    	page.waitForTimeout(3000);
    	//System.out.println("After: " + page.evaluate("window.scrollY"));
    	//System.out.println("After: " + radio.boundingBox());
    	
    	System.out.println("After: x=" + after.x + ", y=" + after.y +", width=" + after.width +", height=" + after.height);
}
	
	
	
	
}
