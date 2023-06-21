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
cariTopikInput = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/penawaranTopikInput')
WebUI.waitForElementVisible(cariTopikInput, 0)
WebUI.click(cariTopikInput)
WebUI.setText(cariTopikInput, topikSearch)
WebUI.verifyElementPresent(cariTopikInput, 0)

penawaranTopikTable = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/table_topik')
Judul = findTestObject('Object Repository/Page_Penawaran Topik  myITS Thesis/p_JudulTopik')
WebUI.waitForElementVisible(penawaranTopikTable, 0)
WebUI.waitForElementVisible(Judul, 0)
textJudul = WebUI.getText(Judul)
if (textJudul.contains(topikSearch)) {
	print(textJudul)
}




