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

WebUI.callTestCase(findTestCase('Test Cases/Dosen/Login_Auth'), ['username': username, 'password': password])
//Login_Auth3

WebUI.click(findTestObject('Object Repository/Page_BerandaDosen/permintaanPembimbinganButton'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_BerandaDosen/table'), 0)
WebUI.click(findTestObject('Object Repository/Page_BerandaDosen/permintaanBimbingan'))

WebUI.verifyTextPresent('Detail Permintaan Pembimbingan', false)

WebUI.click(findTestObject('Object Repository/Page_BerandaDosen/buttonTolakBimbingan'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_BerandaDosen/moduleTolakBimbingan'), 0)
WebUI.click(findTestObject('Object Repository/Page_BerandaDosen/buttonKonfirmasiTolak'))

WebUI.verifyTextPresent('Berhasil ditolak', false)

WebUI.verifyTextPresent('Anda telah menolak permintaan pembimbingan tugas akhir ini', false)

WebUI.closeBrowser()