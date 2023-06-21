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

WebUI.openBrowser(url)

//input username
usernameInput = findTestObject('Object Repository/signIn_Page/signinUsernameInput')

WebUI.click(usernameInput)
WebUI.setText(usernameInput, username)
WebUI.verifyElementPresent(usernameInput, 0)

//input password
buttonNext = findTestObject('Object Repository/signIn_Page/button_Next')
buttonSignIn = findTestObject('Object Repository/signIn_Page/button_Sign in')
passwordInput = findTestObject('Object Repository/signIn_Page/signinPasswordInput')

WebUI.waitForElementVisible(buttonNext, 0)
WebUI.click(buttonNext)
WebUI.waitForElementVisible(passwordInput, 0)
WebUI.click(passwordInput)
WebUI.setText(passwordInput, password)
WebUI.verifyElementPresent(passwordInput, 0)

//signin
WebUI.waitForElementClickable(buttonSignIn, 0)
WebUI.click(buttonSignIn)

sleep(5)
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Beranda  myITS Thesis/p_SelamatDatang'), 0)) {
	WebUI.navigateToUrl("https://dev-thesis.its.ac.id/")
}
//else {
//	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Beranda  myITS Thesis/p_SelamatDatang'), 0)
//}
