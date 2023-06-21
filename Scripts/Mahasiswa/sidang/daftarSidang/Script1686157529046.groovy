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

WebUI.callTestCase(findTestCase('Test Cases/Mahasiswa/sidang/sidangPage'), ['username': username, 'password': password])

WebUI.click(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/daftarSidangButton'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/tableDaftarSidang'), 0)
WebUI.click(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/sidangAkhirButton'))

WebUI.verifyTextPresent('Detail Sidang', false)

WebUI.click(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/registerSidangButton'))

uploadBerkas = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/uploadBerkas')
filePath = 'C:\\Users\\Vyra Fania Adelina\\Katalon Studio\\My First Web UI Project\\FileUpload\\PROPOSAL.pdf'
WebUI.sendKeys(uploadBerkas, filePath)

//'Capturing the file name after upload and storing it in a variable'
FilePath = WebUI.getAttribute(uploadBerkas, 'value')

//'Verifying the Actual path and Expected path of file'
WebUI.verifyMatch(FilePath, 'C:\\fakepath\\PROPOSAL.pdf', false)
//
WebUI.click(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/daftarButton'))

WebUI.verifyTextPresent('Anda sudah mendaftar pada periode sidang ini.', false)


