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

ajuanSidang =findTestObject('Object Repository/Page_Sidang  myITS Thesis/ta_ajuansidang')
WebUI.waitForElementVisible(ajuanSidang, 0)

WebUI.click(ajuanSidang)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Sidang  myITS Thesis/ta_table'), 0)

WebUI.click(findTestObject('Object Repository/Page_Sidang  myITS Thesis/judulTugasAkhir'))

//tolak ajuan
setujuButton = findTestObject('Object Repository/Page_Sidang  myITS Thesis/buttonSetujuAjuan')
WebUI.waitForElementVisible(setujuButton, 0)
WebUI.click(setujuButton)

confirmSetuju = findTestObject('Object Repository/Page_Sidang  myITS Thesis/buttonKonfirmasiSetuju')
WebUI.waitForElementVisible(confirmSetuju, 0)
WebUI.click(confirmSetuju)

WebUI.verifyTextPresent('Ajuan sidang berhasil disetujui.', false)

WebUI.verifyTextPresent('Ajuan sidang disetujui', false)

WebUI.closeBrowser()