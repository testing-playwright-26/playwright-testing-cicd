package ParallelRun_Demo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Locator;

import io.qameta.allure.Allure;


@ExtendWith(TestListener.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest_SauceDemoURLTest extends BaseTest {

	//@Order(4)
	@ParameterizedTest
	@CsvSource({
	    "standard_user, secret_sauce, true",
	    "problem_user, secret_sauce, true",
	    "performance_glitch_user, secret_sauce, true",
	    
	    "error_user, secret_sauce, true",
	    "visual_user, secret_sauce, true"
	})
	
	
	
	
    void LoginTest_SauceDemp(String username, String password, boolean loginExpected){
	
		
		
		
		System.out.println("username  = " + username);
		System.out.println("password = " + password);
		
				
		Allure.step("Test script flow started !!!");
		Allure.step("TEST DATA: "+ username + ","+" password");
		
		Allure.step("****DESCRIPTION: Test script is to ensure that login credentials are working as expected****");
		page.navigate("https://www.saucedemo.com/");
		page.waitForTimeout(4000);
		System.out.println("LoginTest_SauceDemp BaseTest.page = " + page);
		
		System.out.println("LoginTest_SauceDemp class = " + BaseTest.class.getName());
	     Allure.step("Navigate to https://www.saucedemo.com/");
	System.out.println("Locator user value before : "+page.locator("#user-name").inputValue());
	page.locator("#user-name").fill(username);
	 page.waitForTimeout(1000); 
	System.out.println("Locator user value after: "+page.locator("#user-name").inputValue());
	Allure.step("User Name: "+ username);
	
	System.out.println("Locator password value before: "+page.locator("#password").inputValue());
	page.locator("#password").fill(password);
	 page.waitForTimeout(1000);
	System.out.println("Locator passqword value after: "+page.locator("#password").inputValue());
	Allure.step("Password: "+password);	
	
	Locator Login_but=page.locator("#login-button");

	//page.wait() is used instead of page.waitforTimeout() will throw current thread is not owner error
    //submit_but.scrollIntoViewIfNeeded();
	Login_but.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
    //page.waitForTimeout(2000);
	Login_but.waitFor();
	Login_but.highlight();
	Login_but.click();
	 page.waitForTimeout(1000);
	
    
    if (loginExpected) {
        
    	assertTrue(page.url().contains("inventory")); //login success check page url
        Allure.step("Successful login");
    	
    } else {
    	
    	
        Allure.step("Login credentials not working");
    }
    
    
    
	
	}
	
	
}
