package ParallelRun_Demo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import org.opentest4j.AssertionFailedError;

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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.microsoft.playwright.Locator;

import io.qameta.allure.Allure;
import junit.framework.AssertionFailedError;

@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FormSubmitTest extends BaseTest{
	String expectedTitle = "Automation Testing Practice";
    String actualTitle;
    
    
    
	@Test
	//@Order(2)
    void dataForm_Submit() {
    	System.out.println("---dataForm_Submit---");
    	
      
    	Allure.step("Test script flow started !!!");
    	Allure.step("****DESCRIPTION: Test script is to ensure that data form accepts the inputs and on submit it successfuly loads the page****");
    	   	
    	page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
    	System.out.println("FormSubmitTest BaseTest.page = " + page);  		
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
    
	@ParameterizedTest
	@CsvSource({
	    "Automation Testing Practice, true",
	    "Automation Testing Practice123, false",
	    "Automation Testing Practice123, true"
	    
	    
	})
	
	void pageTitle_successfulAssertion(String expectedTitle, boolean titleassrt) {
		
		System.out.println("--- @Order(1) pageTitle_successfulAssertion---");
		Allure.step("****DESCRIPTION: Test script is to ensure that page title assertion is successful****");
		page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
        String actualTitle = page.title();
        //String expectedTitle = "Automation Testing Practice";
        System.out.println("Expected Title : [" + expectedTitle + "]");
        System.out.println("Actual Title   : [" + actualTitle + "]");
        Allure.step("Expected Title: " +expectedTitle);
        Allure.step("Actual Title: " +actualTitle);
        
        if (titleassrt) {

            assertEquals(
                expectedTitle,
                actualTitle,
                "---Page Title mismatch---"
            );

            Allure.step("Page title flow verified successfully");
        }
        else {

           AssertionFailedError assertionError = assertThrows(
                AssertionFailedError.class,
                () -> assertEquals(
                    expectedTitle,
                    actualTitle,
                    "---Intentional Page Title mismatch---"
                )
            );
        	//assertEquals(expectedTitle,actualTitle,"---** Intentional Page Title mismatch**---");

            Allure.step("Intentional page title mismatch detected as expected");

            //System.out.println("Expected : "+ assertionError.getExpected().getStringRepresentation());

            //System.out.println("Actual   : "+ assertionError.getActual().getStringRepresentation());
        }
        //assertEquals(expectedTitle, actualTitle, "---Page Title mismatch---");
        //Allure.step("Page title flow verified successfully");
       
        }
    
	
	
	@Test
   // @Order(2)
	void pageTitle_failedAssertion() {
		
		System.out.println("---pageTitle_failedAssertion---");
		
		Allure.step("****DESCRIPTION: Test script is to ensure that page title assertion is failed intentionally as expected****");
        
		page.navigate("https://testautomationpractice.blogspot.com/");
    	page.waitForTimeout(5000);
        String actualTitle = page.title();
        String expectedTitle = "Automation Testing Practice123";
        System.out.println("Expected Title : [" + expectedTitle + "]");
        System.out.println("Actual Title   : [" + actualTitle + "]");
        Allure.step("Expected Title: " +expectedTitle);
        Allure.step("Actual Title: " +actualTitle);
        //assertEquals(expectedTitle, actualTitle, "---Page Title mismatch intentionally expected: ---"+expectedTitle+ " instead actual: "+actualTitle);
       assertEquals(expectedTitle, actualTitle, "Page Title mismatch intentionally");

        Allure.step("Failed assertion pageTitle_successfulAssertion");
    }


}
