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

WebUI.callTestCase(findTestCase('Test Cases/AdminProdi/S1/Login_Auth_S1'), null)

WebUI.navigateToUrl('https://dev-thesis.its.ac.id/admin/periode-sidang/detail/FBB3A20A-21ED-4021-8F39-F236A1E8F7AD')

searchMahasiswa = findTestObject('Object Repository/Page_PeriodeSidang/searchSidangMahasiswa')
WebUI.waitForElementVisible(searchMahasiswa, 0)
WebUI.click(searchMahasiswa)
WebUI.setText(searchMahasiswa, 'Vyra')

sidangMahasiswa = findTestObject('Object Repository/Page_PeriodeSidang/sidangMahasiswa')
WebUI.waitForElementVisible(sidangMahasiswa, 0)
WebUI.click(sidangMahasiswa)

setujuAjuan = findTestObject('Object Repository/Page_PeriodeSidang/buttonAjuanSetuju')
WebUI.waitForElementVisible(setujuAjuan, 0)
WebUI.click(setujuAjuan)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/modalAjuanSetuju'), 0)

mulaiSidang = findTestObject('Object Repository/Page_PeriodeSidang/inputTanggalMulai')
WebUI.click(mulaiSidang)
WebUI.sendKeys(mulaiSidang, Keys.chord(Keys.ENTER))

inputPenguji = findTestObject('Object Repository/Page_PeriodeSidang/inputSearch')
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/selectPengujiSidang'))
WebUI.waitForElementVisible(inputPenguji, 0)
WebUI.click(inputPenguji)
WebUI.setText(inputPenguji, 'dosen 3')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/resultSelect'), 0)

WebUI.click(inputPenguji)
WebUI.sendKeys(inputPenguji, Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/buttonKonfirmasiSidang'))

WebUI.verifyTextPresent('Ajuan sidang berhasil disetujui!', false)

WebUI.verifyTextPresent('Usulan sidang telah disetujui', false)

