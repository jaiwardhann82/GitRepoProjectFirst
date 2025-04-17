package custom.Function

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class DemoFunction {


	//*****************************************************************************************************************************************************************************
	@Keyword
	def LaunchWebSite() {
		/* ------------------------------------------------------------------------------------------------------
		 PURPOSE: LAUNCH THE WEB BROWSER AND OPEN THE SPECIFIED URL
		 PARAMETER: URL (GLOBAL VARIABLE)
		 CREATED BY: JAIS
		 -------------------------------------------------------------------------------------------------------
		 */

		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.URL)

		WebUI.maximizeWindow()
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/TextBoxOR/svg'), 0)

	}
	//*****************************************************************************************************************************************************************************
	
	
	//*****************************************************************************************************************************************************************************
	@Keyword
	def NavigationToTexBox(MenuOption) {
		/* ------------------------------------------------------------------------------------------------------
		 PURPOSE: Navigation to textbox
		 PARAMETER: URL (GLOBAL VARIABLE)
		 CREATED BY: JAIS
		 -------------------------------------------------------------------------------------------------------
		 */

			GlobalVariable.GLMenuOption = MenuOption

			WebUI.click(findTestObject('Object Repository/TextBoxOR/svg'))
			
			WebUI.verifyElementPresent(findTestObject('Object Repository/TextBoxOR/div_Elements'), 0)
			
			WebUI.click(findTestObject('Object Repository/TextBoxOR/div_Elements'))
			
			/*WebUI.verifyElementPresent(findTestObject('Object Repository/TextBoxOR/Text Box'), 0)
			
			WebUI.click(findTestObject('Object Repository/TextBoxOR/Text Box'))*/
			
			WebUI.verifyElementPresent(findTestObject('Object Repository/TextBoxOR/'+GlobalVariable.GLMenuOption), 0)
			
			WebUI.click(findTestObject('Object Repository/TextBoxOR/'+GlobalVariable.GLMenuOption))
			
			println('The Menu Option clicked was :' + GlobalVariable.GLMenuOption)
			
	}
	//*****************************************************************************************************************************************************************************
	
	@Keyword
	def FormFillAndSubmit() {
		/* ------------------------------------------------------------------------------------------------------
		 PURPOSE: Fill the form
		 PARAMETER: URL (GLOBAL VARIABLE)
		 CREATED BY: JAIS
		 -------------------------------------------------------------------------------------------------------
		 */

		//*******************Test Data Creation Starts*******************
		 Random random = new Random()
 
		 int length = 10 // Specify the length of the random string
 
		 StringBuilder randomString = new StringBuilder()
 
		 String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0'
 
		 for (int i = 0; i < length; i++) {
			 char randomChar = chars.charAt(random.nextInt(chars.length()))
 
			 randomString.append(randomChar)
		 }
 
		 String testobjct = randomString.toString()
		 
		 GlobalVariable.GLRandomText = testobjct
 
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/TextBoxOR/input_Full Name_userName'), 0)
		
		WebUI.setText(findTestObject('Object Repository/TextBoxOR/input_Full Name_userName'), GlobalVariable.GLRandomText)
		
		WebUI.setText(findTestObject('Object Repository/TextBoxOR/input_Email_userEmail'), GlobalVariable.GLRandomText+'@test.com')
		
		WebUI.setText(findTestObject('Object Repository/TextBoxOR/textarea_Current Address_currentAddress'),  GlobalVariable.GLRandomText+': user Address is 3434 Aparment 1010')
		
		WebUI.setText(findTestObject('Object Repository/TextBoxOR/textarea_Permanent Address_permanentAddress'), 'same as above')
		
		WebUI.scrollToPosition(0, 1000)
		
		WebUI.click(findTestObject('Object Repository/TextBoxOR/button_Submit'))

				}
	//*****************************************************************************************************************************************************************************
				
	@Keyword
	def ClosingBrowser() {
	/* ------------------------------------------------------------------------------------------------------
		 PURPOSE: Close Browser
		 PARAMETER: URL (GLOBAL VARIABLE)
	     CREATED BY: JAIS
	-------------------------------------------------------------------------------------------------------
					 */
		
	WebUI.closeBrowser()
				
			
//*****************************************************************************************************************************************************************************
}
}
