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

WebUI.callTestCase(findTestCase('Test Cases/Login/LoginAuth'), ['username': username, 'password': password])

WebUI.click(findTestObject('Object Repository/Page_BerandaDosen/sidangButton'))

pimpinanTesisTab = findTestObject('Object Repository/Page_Sidang  myITS Thesis/pemimpinSidang_tab_tesis')
daftarSidangTesis = findTestObject('Object Repository/Page_Sidang  myITS Thesis/pemimpinSidang_sidang_tesis')

WebUI.waitForElementVisible(pimpinanTesisTab, 0)
WebUI.click(pimpinanTesisTab)
WebUI.waitForElementVisible(daftarSidangTesis, 0)
WebUI.click(daftarSidangTesis)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sidang  myITS Thesis/tableSidangTesis'), 0)
WebUI.click(findTestObject('Object Repository/Page_Sidang  myITS Thesis/judulTesis'))

buttonKehadiran = findTestObject('Object Repository/Page_Sidang  myITS Thesis/buttonKehadiranDosen')
WebUI.waitForElementVisible(buttonKehadiran, 0)
WebUI.click(buttonKehadiran)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sidang  myITS Thesis/modalKehadiranDosen'), 0)
checklistDosen = findTestObject('Object Repository/Page_Sidang  myITS Thesis/checkKehadiranDosen')
WebUI.click(checklistDosen)
WebUI.click(checklistDosen)

WebUI.click(findTestObject('Object Repository/Page_Sidang  myITS Thesis/buttonSimpanKehadiran'))

WebUI.verifyTextPresent('Kehadiran dosen berhasil disimpan', false)

