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

//WebUI.switchToWindowUrl('https://dev-thesis.its.ac.id/admin/periode-sidang')

//cari
search = findTestObject('Object Repository/Page_PeriodeSidang/input')
WebUI.click(search)
WebUI.setText(search, sidang)
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/sidang', ['sidang' : sidang]))

//edit
//prasyarat sidang
editSyarat = findTestObject('Object Repository/Page_PeriodeSidang/editSyarat')
tambahSyaratButton = findTestObject('Object Repository/Page_PeriodeSidang/tambahSyaratButton')
modalSyarat = findTestObject('Object Repository/Page_PeriodeSidang/modalSyarat')
syarat = findTestObject('Object Repository/Page_PeriodeSidang/prasyarat')
inputSyarat = findTestObject('Object Repository/Page_PeriodeSidang/selectSyarat')
keterangan =
simpanButton = findTestObject('Object Repository/Page_PeriodeSidang/simpanSyaratButton')

WebUI.waitForElementVisible(editSyarat, 0)
WebUI.click(editSyarat)
WebUI.waitForElementVisible(tambahSyaratButton, 0)
WebUI.click(tambahSyaratButton)
WebUI.waitForElementVisible(modalSyarat, 0)
WebUI.click(modalSyarat)

WebUI.waitForElementVisible(syarat, 0)
WebUI.click(syarat)
WebUI.waitForElementVisible(inputSyarat, 0)
WebUI.setText(inputSyarat, berkas)
WebUI.sendKeys(inputSyarat, Keys.chord(Keys.ENTER))
WebUI.verifyElementText(syarat, berkas)

//keterangan
keterangan = findTestObject('Object Repository/Page_PeriodeSidang/inputKeterangan')
WebUI.click(keterangan)
WebUI.setText(keterangan, 'keterangan')

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/simpanSyaratButton'))

WebUI.verifyTextPresent('Berhasil menambahkan prasayarat sidang!', false)

deleteSyarat = findTestObject('Object Repository/Page_PeriodeSidang/deletePrasyarat')

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/moreButton'))
WebUI.waitForElementVisible(deleteSyarat, 0)
WebUI.click(deleteSyarat)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/modalHapusSyarat'), 0)
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/hapusSyarat'))

WebUI.verifyTextPresent('Berhasil menghapus prasayarat sidang!', false)

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/backButton'))

//publish sidang
WebUI.callTestCase(findTestCase('Test Cases/AdminProdi/S1/Administrasi/PeriodeSidang/umumkanSidang'), null)