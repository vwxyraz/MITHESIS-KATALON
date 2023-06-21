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


//Tugas Akhir Page
statusTopik = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/span_Semua status topik')
statusSelect = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/span_statusTopikSelect')
WebUI.waitForElementVisible(statusTopik, 0)
WebUI.click(statusTopik)
WebUI.waitForElementVisible(statusSelect, 0)
WebUI.click(statusSelect)
//WebUI.sendKeys(statusSelect, Keys.chord(Keys.ARROW_DOWN))
//WebUI.sendKeys(statusSelect, Keys.chord(Keys.ENTER))

//penawaranTopikTable = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/table_topik')
//statusTable = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/td_statusTopik')
//WebUI.waitForElementVisible(statusTable, 0)
//textJudul = WebUI.getText(statusTable)
//if (textJudul.contains(status)) {
//	WebUI.closeBrowser()
//}
