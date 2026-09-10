package PlaywrightScriptPractice;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
//import java.net.URISyntaxException;

@ExtendWith(TestListener.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Uploadfile_Locators_Test extends BaseTest{
	String expectedTitle = "Automation Testing Practice: PlaywrightPractice";
    String actualTitle;
    
	@Test
	//@Order(3)
    void Locators_Uploadfile()throws Exception{
		
		//getByAltText.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        //page.evaluate("window.scrollTo(0, 500)");
        //imptxt.evaluate("el => el.style.backgroundColor = 'yellow'");
		
		 Path audioFile = Paths.get(
			        getClass().getClassLoader()
			            .getResource("TestData/audio_only.m4a")
			            .toURI()
			    );

			    Path imageFile = Paths.get(
			        getClass().getClassLoader()
			            .getResource("TestData/analytical thinking.jpg")
			            .toURI()
			    );

    	
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
        
        Allure.step("*** single file upload test execution Started***");
        System.out.println("***singlefile upload test execution Started***");
        
        Locator singlefile=page.locator("input#singleFileInput");
        
        // C:\\TestData\\sample.txt or C:/TestData/sample.txt
        
        singlefile.setInputFiles(audioFile); //upload single file
        singlefile.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        
        //assertThat(singlefile).hasValue("C:\\TestData\\audio_only.m4a");
       
        assertTrue(singlefile.inputValue().endsWith("audio_only.m4a"), "audio_only.m4a was not selected");
        
        Allure.step("*** single file upload test execution is working***");
        
        System.out.println("***multiplefile upload test execution Started***");
        
        Locator multiplefile=page.locator("input#multipleFilesInput");
        
        multiplefile.setInputFiles(new Path[] {
        		audioFile,
        	    imageFile
        	});
        multiplefile.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        
       /// String selectedFiles = (String) multiplefile.evaluate("el => Array.from(el.files).map(f => f.name).join('|')");
       
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Multiple Files")).click();
        String selectedFiles = page.locator("//p[@id='multipleFilesStatus']").textContent();

        System.out.println("selected files: "+selectedFiles);
        assertTrue(selectedFiles.contains("audio_only.m4a"), "audio_only.m4a was not selected");
        assertTrue(selectedFiles.contains("analytical thinking.jpg"), "analytical thinking.jpg was not selected");
        //assertTrue(multiplefile.contains("analytical thinking.jpg"), "analytical thinking.jpg was not selected");
        //Locator multiplefile=page.locator("input#singleFileInput");
        
        /*
        // C:\\TestData\\sample.txt or C:/TestData/sample.txt
        
        singlefile.setInputFiles(Paths.get("C:\\TestData\\audio_only.m4a")); //upload single file
        singlefile.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
        System.out.println("File name: "+singlefile.inputValue().endsWith("audio_only.m4a"));
        assertThat(singlefile).hasValue("C:\\TestData\\audio_only.m4a");
        */
         
        
         page.waitForTimeout(5000);
         //assertTrue(singlefile.inputValue().endsWith("audio_only.m4a"), "audio_only.m4a was not selected");
        
        Allure.step("*** multiple file upload test execution is working***");
        
        
}
	
	
	
	
}
