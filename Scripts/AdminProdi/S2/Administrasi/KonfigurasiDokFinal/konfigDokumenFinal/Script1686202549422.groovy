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

WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S2/Login_Auth_S2"), null)

//Tugas Akhir Page
buttonAdministrasi = findTestObject('Object Repository/Page_Beranda/Administrasi')
buttonKonfigDokumen = findTestObject('Object Repository/Page_Administrasi/konfigDokumenFinal')

WebUI.waitForElementVisible(buttonAdministrasi, 0)
WebUI.click(buttonAdministrasi)
WebUI.waitForElementVisible(buttonKonfigDokumen, 0)
WebUI.click(buttonKonfigDokumen)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/cardDokumen'), 0)

//add dokumen
inputJenis = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/pilihJenisBerkas')
searchJenis = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/searchJenis')
inputKet = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/inputKeterangan')

WebUI.click(inputJenis)
WebUI.waitForElementVisible(searchJenis, 0)
WebUI.click(searchJenis)
WebUI.setText(searchJenis, 'Bimbingan')
WebUI.click(searchJenis)
WebUI.sendKeys(searchJenis, Keys.chord(Keys.ENTER))

//WebUI.click(inputKet)
//WebUI.setText(inputKet, 'Dokumen Bimbingan')

addRow = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/addRow')
removeRow = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/removeRow')
WebUI.click(addRow)
WebUI.click(removeRow)

buttonSave = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/buttonSave')
WebUI.click(buttonSave)

WebUI.verifyTextPresent('Berhasil simpan data konfigurasi repository!', false)

//edit
buttonEdit = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/buttonEdit')
editKeterangan = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/inputKeteranganEdit')
WebUI.click(buttonEdit)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/modalEdit'), 0)
WebUI.click(editKeterangan)
WebUI.setText(editKeterangan, 'keterangan')

WebUI.click(findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/button_Simpan'))

WebUI.verifyTextPresent('Berhasil simpan data konfigurasi repository!', false)


//delete
buttonDelete = findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/buttonDelete')
WebUI.click(buttonDelete)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/cardDelete'), 0)
WebUI.click(findTestObject('Object Repository/Page_Konfigurasi Dokumen Final  myITS Thesis/button_Hapus'))

WebUI.verifyTextPresent('Berhasil menghapus data konfigurasi repository!', false)


//close
WebUI.closeBrowser()

