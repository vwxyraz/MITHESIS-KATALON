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


//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

//Pembimbingan Dosen Page
buttonPembimbingan = findTestObject('Object Repository/Page_Beranda/pembimbinganDosen')
table = findTestObject('Object Repository/Page_Dosen Pembimbing/tablePembimbingan')

WebUI.waitForElementVisible(buttonPembimbingan, 0)
WebUI.click(buttonPembimbingan)

WebUI.waitForElementVisible(table, 0)

//search dosen with name
searchDosen = findTestObject('Object Repository/Page_Dosen Pembimbing/input')
//WebUI.scrollToPosition(0, 0)
WebUI.waitForElementVisible(searchDosen, 0)
WebUI.click(searchDosen)
WebUI.setText(searchDosen, namaDosen)
WebUI.verifyElementPresent(searchDosen, 0)

def nama = WebUI.getText(table)
if (nama.contains(namaDosen)) {
//	print("%s", nama.contains(namaDosen))
	print(nama)
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

WebUI.clearText(searchDosen)

//next page
buttonNextPage = findTestObject('Object Repository/Page_Dosen Pembimbing/buttonBerikutnya')
WebUI.waitForElementClickable(buttonNextPage, 0)
WebUI.scrollToElement(buttonNextPage, 3)
WebUI.waitForElementVisible(buttonNextPage, 0)
WebUI.click(buttonNextPage)

//tab Non-Reguler
buttonNonReg = findTestObject('Object Repository/Page_Dosen Pembimbing/tabNonReguler')

WebUI.waitForElementVisible(buttonNonReg, 0)
WebUI.click(buttonNonReg)

searchDosen = findTestObject('Object Repository/Page_Dosen Pembimbing/inputNonReg')
WebUI.waitForElementVisible(searchDosen, 0)
WebUI.click(searchDosen)
WebUI.setText(searchDosen, namaDosen)
WebUI.verifyElementPresent(searchDosen, 0)

table = findTestObject('Object Repository/Page_Dosen Pembimbing/tableNonReg')
nama = WebUI.getText(table)
if (nama.contains(namaDosen)) {
//	print("%s", nama.contains(namaDosen))
	print(nama)
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

WebUI.clearText(searchDosen)


//WebUI.closeBrowser()
