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

WebUI.click(findTestObject('Object Repository/Page_Beranda/repositoriDokFinalButton'))

buttonUpload = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/buttonUnggahBerkas')
WebUI.waitForElementVisible(buttonUpload, 0)
WebUI.click(buttonUpload)

jenisDokumen = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/selectJenisDokumen')
inputNamaDok = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/inputNamaDokumen')
inputBerkas = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/inputBerkas')
inputKeterangan = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/inputKeterangan')
WebUI.waitForElementVisible(jenisDokumen, 0)
WebUI.selectOptionByValue(jenisDokumen, '11', false)

WebUI.click(inputNamaDok)
WebUI.setText(inputNamaDok, 'Dokumen akhir')

filePath = 'C:\\Users\\Vyra Fania Adelina\\Katalon Studio\\My First Web UI Project\\FileUpload\\PROPOSAL.pdf'
WebUI.sendKeys(inputBerkas, filePath)

WebUI.click(inputKeterangan)
WebUI.setText(inputKeterangan, 'keterangan')

WebUI.click(findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/buttonUnggah'))

WebUI.verifyTextPresent('Berhasil mengunggah berkas dokumen final.', false)
//Berhasil mengunggah berkas dokumen final.

buttonMore = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/buttonMore')
WebUI.waitForElementVisible(buttonMore, 0)
WebUI.click(buttonMore)

buttonHapus = findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/buttonHapusDok')
WebUI.waitForElementVisible(buttonHapus, 0)
WebUI.click(buttonHapus)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/modalHapusBerkas'), 0)

WebUI.click(findTestObject('Object Repository/Page_Repositori Dok Mahasiswa/buttonKonfirmasiHapus'))

WebUI.verifyTextPresent('Berhasil menghapus berkas dokumen final.', false)

