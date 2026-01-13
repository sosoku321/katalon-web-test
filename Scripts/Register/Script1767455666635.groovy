import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://parabank.parasoft.com/parabank/register.htm')

newAccount = CustomKeywords.'com.myproject.utils.MyTools.generateRandomString'('user')

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_First Name_customer.firstName'), 
    'QA')

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Last Name_customer.lastName'), 
    'Test')

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Username_customer.username'), 
    newAccount)

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Password_customer.password'), 
    'Pass123456')

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Confirm_repeatedPassword'), 'Pass123456')

WebUI.click(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Confirm_button'))

WebUI.setText(findTestObject('Page_ParaBank  Register for Free Online Account Access/input_Zip Code_customer.address.zipCode'), 
    '')

