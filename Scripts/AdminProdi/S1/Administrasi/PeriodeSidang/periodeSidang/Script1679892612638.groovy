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
import internal.GlobalVariable
import net.bytebuddy.utility.RandomString

import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandStr

//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

buttonAdministrasi = findTestObject('Object Repository/Page_Beranda/Administrasi')
buttonPeriodeSidang = findTestObject('Object Repository/Page_Administrasi/periodeSidang')

WebUI.waitForElementVisible(buttonAdministrasi, 0)
WebUI.click(buttonAdministrasi)
WebUI.waitForElementVisible(buttonPeriodeSidang, 0)
WebUI.click(buttonPeriodeSidang)

//periode sidang page
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PeriodeSidang/table'), 0)
WebUI.verifyTextPresent('Nama Sidang', false)
WebUI.verifyTextPresent('Jenis', false)
WebUI.verifyTextPresent('Semester', false)
WebUI.verifyTextPresent('Pendaftaran', false)
WebUI.verifyTextPresent('Pelaksanaan', false)
WebUI.verifyTextPresent('Administrator Sidang', false)

sidang = RandStr.randomAlphabetic(10)

WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Administrasi/PeriodeSidang/buatSidang"), ['namaSidang': sidang], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Administrasi/PeriodeSidang/publishSidang"), ['sidang': sidang], FailureHandling.STOP_ON_FAILURE)

//WebUI.closeBrowser()