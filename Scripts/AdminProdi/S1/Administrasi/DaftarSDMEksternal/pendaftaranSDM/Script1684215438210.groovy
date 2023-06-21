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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.lang.RandomStringUtils as RandStr

//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

//Tugas Akhir Page
buttonAdministrasi = findTestObject('Object Repository/Page_Beranda/Administrasi')
buttonSDM = findTestObject('Object Repository/Page_Administrasi/SDMEksternal')

WebUI.waitForElementVisible(buttonAdministrasi, 0)
WebUI.click(buttonAdministrasi)
WebUI.waitForElementVisible(buttonSDM, 0)
WebUI.click(buttonSDM)

WebUI.verifyTextPresent('Pendaftaran SDM Eksternal', false)

//tambah
buttonTambah = findTestObject('Object Repository/Page_SDMEksternal/a_Tambah')

WebUI.click(buttonTambah)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/informasi'), 0)

inputSDM = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/namaSDM')
inputNama = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/inputNama')
inputGelarDepan = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/inputGelarDepan')
inputGelarBelakang = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/inputGelarBelakang')
inputNIK = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/InputNIK')
inputAfiliasi = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/inputAfiliasi')
inputNPWP = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/inputNPWP')
WNI = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/WNI')


nama = RandStr.randomAlphabetic(5)
WebUI.click(inputSDM)
WebUI.click(inputNama)
WebUI.setText(inputNama, nama)
WebUI.click(inputNama)
WebUI.sendKeys(inputNama, Keys.chord(Keys.ENTER))

WebUI.click(inputGelarDepan)
WebUI.setText(inputGelarDepan, 'Dr.')

WebUI.click(inputGelarBelakang)
WebUI.setText(inputGelarBelakang, 'S.Kom., M.Sc.')

WebUI.click(WNI)

rand = RandStr.randomNumeric(16)
WebUI.click(inputNIK)
WebUI.setText(inputNIK, rand)

WebUI.click(inputAfiliasi)
WebUI.setText(inputAfiliasi, 'testing')

rand = RandStr.randomNumeric(15)
WebUI.click(inputNPWP)
WebUI.setText(inputNPWP, rand)

buttonSave = findTestObject('Object Repository/Page_Tambah SDM Eksternal Baru  myITS Thesis/button_Simpan')
WebUI.click(buttonSave)


WebUI.verifyTextPresent('Berhasil menambah data SDM eksternal baru.', false)

//search
search = findTestObject('Object Repository/Page_SDMEksternal/input')
WebUI.click(search)
WebUI.setText(search, nama)

def table = WebUI.getText(findTestObject('Object Repository/Page_SDMEksternal/table'))
if (table.contains(nama)) {
	print(table.contains(nama))
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

//WebUI.closeBrowser()
