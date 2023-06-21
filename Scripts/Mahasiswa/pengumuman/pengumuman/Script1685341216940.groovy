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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//WebUI.callTestCase(findTestCase("Test Cases/Mahasiswa/Login_Auth0"), null)

buttonPengumuman = findTestObject('Object Repository/Page_Beranda  myITS Thesis/pengumumanButton')

buttonSearch = findTestObject('Object Repository/Page_Pengumuman  myITS Thesis/searchPengumuman')
cardPengumuman = findTestObject('Object Repository/Page_Pengumuman  myITS Thesis/pengumumanCard')
inputSearch = findTestObject('Object Repository/Page_Pengumuman  myITS Thesis/search')

WebUI.waitForElementVisible(buttonPengumuman, 0)
WebUI.click(buttonPengumuman)

WebUI.waitForElementVisible(buttonSearch, 0)

//cari pengumuman
WebUI.click(buttonSearch)
WebUI.click(inputSearch)
WebUI.setText(inputSearch, 'Random')
WebUI.sendKeys(inputSearch, Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(cardPengumuman, 0)
WebUI.click(cardPengumuman)

WebUI.verifyTextPresent('Random', false)

//WebUI.closeBrowser()


