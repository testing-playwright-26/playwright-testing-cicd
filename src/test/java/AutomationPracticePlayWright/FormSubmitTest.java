package AutomationPracticePlayWright;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import com.microsoft.playwright.Locator;

import io.qameta.allure.Allure;
@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormSubmitTest extends BaseTest{
	String expectedTitle = "Automation Testing Practice";
    String actualTitle;
    
	@Test
	@Order(3)
    void dataForm_Submit() {
    	System.out.println("---@Order(3) dataForm_Submit---");
    	
      
    	Allure.step("Test script flow started !!!");
    	   	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
    	System.out.println("FormSubmitTest BaseTest.page = " + BaseTest.page);  		
    	System.out.println("FormSubmitTest class = " + BaseTest.class.getName());
    	Allure.step("Navigate to https://testautomationpractice.blogspot.com");
    	
        Locator submit_but=page.locator(".submit-btn");
        //submit_but.scrollIntoViewIfNeeded();
        submit_but.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.waitForTimeout(2000);
        submit_but.waitFor();
        submit_but.highlight();
        submit_but.click();
        Allure.step("Click Submit button");
        String OnclickSubmit_actual=page.locator("//div[@id='result']").textContent();
        String OnclickSubmit_expected="Please select both start and end dates.";
        //String title = page.title();
        //System.out.println("Title obtained: " + title);

        //assertTrue(title.contains("Automation123"));
       // assertEquals("Automation Testing Practice123", title);
        //String expectedTitle = "Automation Testing Practice123";
        //String actualTitle = page.title();

        System.out.println("Message on Click in DataEntry Form:"+OnclickSubmit_actual);
        System.out.println("Actual Title   : [" + OnclickSubmit_actual + "]");

        Allure.step("Expected msg on submit button click: " +OnclickSubmit_expected);
        Allure.step("Actual msg on submit button click: " +OnclickSubmit_actual);
        assertEquals(OnclickSubmit_expected, OnclickSubmit_actual,"Page title mismatch");
       Allure.step("Verify message onClick" +actualTitle);
       
       
     
        
       System.out.println("Test passed!");
    }
    
	@Test
    @Order(1)
	void pageTitle_successfulAssertion() {
		
		System.out.println("--- @Order(1) pageTitle_successfulAssertion---");
        
		page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
        String actualTitle = page.title();
        //String expectedTitle = "Automation Testing Practice";
        System.out.println("Expected Title : [" + expectedTitle + "]");
        System.out.println("Actual Title   : [" + actualTitle + "]");
        Allure.step("Expected Title: " +expectedTitle);
        Allure.step("Actual Title: " +actualTitle);

        assertEquals(expectedTitle, actualTitle);

        Allure.step("Successful pageTitle_successfulAssertion");
    }
	
	@Test
    @Order(2)
	void pageTitle_failedAssertion() {
		
		System.out.println("---@Order(2) pageTitle_failedAssertion---");
        
		page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
        String actualTitle = page.title();
        String expectedTitle = "Automation Testing Practice123";
        System.out.println("Expected Title : [" + expectedTitle + "]");
        System.out.println("Actual Title   : [" + actualTitle + "]");
        Allure.step("Expected Title: " +expectedTitle);
        Allure.step("Actual Title: " +actualTitle);

        assertEquals(expectedTitle, actualTitle);

        Allure.step("Failed assertion pageTitle_successfulAssertion");
    }


}
