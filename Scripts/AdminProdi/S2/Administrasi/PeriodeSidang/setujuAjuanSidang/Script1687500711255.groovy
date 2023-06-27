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

WebUI.callTestCase(findTestCase('Test Cases/AdminProdi/S2/Login_Auth_S2'), null)

WebUI.navigateToUrl('https://dev-thesis.its.ac.id/admin/periode-sidang/detail/3B5F6FB7-9E04-47F8-A4C7-BB0818ABE9E0')

searchMahasiswa = findTestObject('Object Repository/Page_PeriodeSidang/searchSidangMahasiswa')
WebUI.waitForElementVisible(searchMahasiswa, 0)
WebUI.click(searchMahasiswa)
WebUI.setText(searchMahasiswa, 'Mahasiswa 4')

sidangMahasiswa = findTestObject('Object Repository/Page_PeriodeSidang/sidangMahasiswa')
WebUI.waitForElementVisible(sidangMahasiswa, 0)
WebUI.click(sidangMahasiswa)

setujuAjuan = findTestObject('Object Repository/Page_PeriodeSidang/buttonAjuanSetuju')
WebUI.waitForElementVisible(setujuAjuan, 0)
WebUI.click(setujuAjuan)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/modalAjuanSetuju'), 0)

tglSidang = findTestObject('Object Repository/Page_PeriodeSidang/inputTanggalSidang')
WebUI.click(tglSidang)
WebUI.sendKeys(tglSidang, Keys.chord(Keys.ENTER))

mulaiSidang = findTestObject('Object Repository/Page_PeriodeSidang/inputMulaiSidang')
WebUI.click(mulaiSidang)
WebUI.sendKeys(mulaiSidang, Keys.chord(Keys.ENTER))

selesaiSidang = findTestObject('Object Repository/Page_PeriodeSidang/inputSelesaiSidang')
WebUI.click(selesaiSidang)
WebUI.sendKeys(selesaiSidang, Keys.chord(Keys.ENTER))

inputPenguji = findTestObject('Object Repository/Page_PeriodeSidang/inputSearch')
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/selectPengujiSidang'))
WebUI.waitForElementVisible(inputPenguji, 0)
WebUI.click(inputPenguji)
WebUI.setText(inputPenguji, 'dosen 1')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/resultSelect'), 0)

WebUI.click(inputPenguji)
WebUI.sendKeys(inputPenguji, Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/buttonKonfirmasiSidang'))

WebUI.verifyTextPresent('Ajuan sidang berhasil disetujui!', false)

WebUI.verifyTextPresent('Usulan sidang telah disetujui', false)

WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/editPimpinanSidang'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/modalPimpinanSidang'), 0)
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/pimpinanSidangDosen1'))
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/buttonSimpanPimpinanSidang'))

WebUI.verifyTextPresent('Berhasil mengatur pimpinan sidang!', false)


