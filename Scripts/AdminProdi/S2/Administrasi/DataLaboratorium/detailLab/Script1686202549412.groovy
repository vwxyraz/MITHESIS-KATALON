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

WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Administrasi/DataLaboratorium/cariLab"), ['lab': labName], FailureHandling.STOP_ON_FAILURE)

//masuk detail lab
lab = findTestObject('Object Repository/Page_DataLab/labName')
WebUI.click(lab)

//detail lab page
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_DetailLab/detailLab'), 0)
namaLab = findTestObject('Object Repository/Page_DetailLab/namaLab')
WebUI.verifyTextPresent(labName, false)
WebUI.verifyTextPresent('NIP', false)
WebUI.verifyTextPresent('Nama Anggota', false)

//cari dosen lab
inputDosen = findTestObject('Object Repository/Page_DetailLab/input')
WebUI.click(inputDosen)
WebUI.setText(inputDosen, namaDosen)
WebUI.verifyElementPresent(inputDosen, 0)
WebUI.verifyTextPresent(namaDosen, false)

WebUI.closeBrowser()
