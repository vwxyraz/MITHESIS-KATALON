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
import org.apache.commons.lang.RandomStringUtils as RandStr

WebUI.callTestCase(findTestCase('Test Cases/Mahasiswa/Login_Auth1'), null)

WebUI.click(findTestObject('Object Repository/Page_Beranda  myITS Thesis/a_Tugas Akhir'))

catatanPenelitian = findTestObject('Object Repository/Page_Tugas Akhir  myITS Thesis/catatanPenelitian')
WebUI.waitForElementVisible(catatanPenelitian, 0)
WebUI.click(catatanPenelitian)

tableCatatan = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/tableCatatan')
WebUI.waitForElementVisible(tableCatatan, 0)

WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonTambahCatatan'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/moduleTambahCatatan'), 0)

inputCatatan = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/inputCatatan')
stringCatatan = RandStr.randomAlphabetic(10)

WebUI.click(inputCatatan)
WebUI.setText(inputCatatan, stringCatatan)

WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonSimpanCatatan'))

WebUI.verifyTextPresent('Catatan penelitian mandiri berhasil ditambahkan.', false)

//upload file
buttonUploadFile = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonUploadFileCatatan')
uploadFile = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/uploadFile')
WebUI.click(buttonUploadFile)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/moduleTambahBerkas'), 0)
//WebUI.click(uploadFile)

filePath = 'C:\\Users\\Vyra Fania Adelina\\Katalon Studio\\Sample - Web API Tests\\FileUpload\\PROPOSAL.pdf'
WebUI.sendKeys(uploadFile, filePath)

//'Capturing the file name after upload and storing it in a variable'
FilePath = WebUI.getAttribute(uploadFile, 'value')

//'Verifying the Actual path and Expected path of file'
WebUI.verifyMatch(FilePath, 'C:\\fakepath\\PROPOSAL.pdf', false)

WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonUnggah'))

WebUI.verifyTextPresent('Berhasil mengunggah berkas penelitian mandiri.', false)

//delete berkas
buttonDeleteBerkas = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonHapusBerkas')
WebUI.click(buttonDeleteBerkas)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/moduleHapusBerkas'), 0)
WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonKonfirmasiHapusBerkas'))

WebUI.verifyTextPresent('Berhasil menghapus berkas', false)

//edit
moreButton = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonMoreCatatan')
WebUI.click(moreButton)
editButton = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonEditCatatan')
WebUI.waitForElementVisible(editButton, 0)
WebUI.click(editButton)

stringEdit = RandStr.randomAlphabetic(10)
inputEdit = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/inputCatatanEdit')
WebUI.click(inputEdit)
WebUI.clearText(inputEdit)
WebUI.click(inputEdit)
WebUI.setText(inputEdit, stringEdit)

WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonSimpanEdit'))

WebUI.verifyTextPresent('Catatan penelitian nomor 2 berhasil diubah.', false)

//delete
WebUI.click(moreButton)
deleteButton = findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonHapusCatatan')
WebUI.waitForElementVisible(deleteButton, 0)
WebUI.click(deleteButton)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/moduleHapusCatatan'), 0)

WebUI.click(findTestObject('Object Repository/Page_Catatan Penelitian Pembimbingan/buttonHapus'))

WebUI.verifyTextPresent('Catatan penelitian nomor 2 berhasil dihapus.', false)




