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

//WebUI.callTestCase(findTestCase("Test Cases/Dosen/Login_Auth2"), null)

//jadwal sidang Page
buttonJadwalSidang = findTestObject('Object Repository/Page_BerandaDosen/jadwalSidangButton')

WebUI.waitForElementVisible(buttonJadwalSidang, 0)
WebUI.click(buttonJadwalSidang)

//filter jadwal sidang
laboratorium = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/laboratorium')
jenis = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/jenisSidang')
periode = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/periodeSidang')
input = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/inputSelect')
res = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/selectResult')

lab = 'Rekayasa Perangkat Lunak'

WebUI.click(laboratorium)
WebUI.waitForElementVisible(input, 0)
WebUI.click(input)
WebUI.setText(input, lab)
WebUI.waitForElementVisible(res, 0)
WebUI.click(input)
WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

//WebUI.click(jenis)
//WebUI.waitForElementVisible(input, 0)
//WebUI.click(input)
//WebUI.setText(input, 'Sidang Proposal')
//WebUI.waitForElementVisible(res, 0)
//WebUI.click(input)
//WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

table = findTestObject('Object Repository/Page_Jadwal Sidang  myITS Thesis/table')

WebUI.waitForElementPresent(table, 0)

def result = WebUI.getText(table)
if (result.contains(lab)) {
	print(result.contains(lab))
}

else {
	KeywordUtil.markFailed('did not contain expected text')
}

//WebUI.closeBrowser()
//



