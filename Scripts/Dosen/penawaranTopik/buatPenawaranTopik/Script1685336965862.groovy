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

buatPenawaranButton = findTestObject('Object Repository/Page_PenawaranTopikDosen/buatTopikButton')
WebUI.click(buatPenawaranButton)

inputJudul = findTestObject('Object Repository/Page_BuatTopikDosen/judul')
inputJudulEn = findTestObject('Object Repository/Page_BuatTopikDosen/judulEn')
inputDeskripsi = findTestObject('Object Repository/Page_BuatTopikDosen/deskripsi')
inputKataKunci = findTestObject('Object Repository/Page_BuatTopikDosen/kataKunci')
inputKeyword = findTestObject('Object Repository/Page_BuatTopikDosen/inputKeyword')

tambahDosenButton = findTestObject('Object Repository/Page_BuatTopikDosen/tambahDosenButton')
pilihPembimbing = findTestObject('Object Repository/Page_BuatTopikDosen/pilihPembimbing')
removePembimbing = findTestObject('Object Repository/Page_BuatTopikDosen/removeDosenButton')
selectPembimbing = findTestObject('Object Repository/Page_BuatTopikDosen/select')
selectResult = findTestObject('Object Repository/Page_BuatTopikDosen/selectResult')
simpanButton = findTestObject('Object Repository/Page_BuatTopikDosen/simpanButton')


//judul
judul = RandStr.randomAlphabetic(20)
WebUI.click(inputJudul)
WebUI.setText(inputJudul, judul)

//judul eng
judulEn = RandStr.randomAlphabetic(20)
WebUI.click(inputJudulEn)
WebUI.setText(inputJudulEn, judulEn)

//deskripsi
deskripsi = RandStr.randomAlphabetic(50)
WebUI.click(inputDeskripsi)
WebUI.setText(inputDeskripsi, deskripsi)

//kata kunci
key1 = RandStr.randomAlphabetic(5)
key2 = RandStr.randomAlphabetic(5)
WebUI.click(inputKeyword)
WebUI.setText(inputKeyword, key1)
WebUI.sendKeys(inputKeyword, Keys.chord(Keys.ENTER))
WebUI.click(inputKeyword)
WebUI.setText(inputKeyword, key2)
WebUI.sendKeys(inputKeyword, Keys.chord(Keys.ENTER))


//tambah dosen
WebUI.click(tambahDosenButton)
WebUI.waitForElementVisible(pilihPembimbing, 0)
WebUI.click(pilihPembimbing)
WebUI.click(selectPembimbing)
WebUI.setText(selectPembimbing, 'Dosen 3')
WebUI.waitForElementVisible(selectResult, 0)
WebUI.click(selectPembimbing)
WebUI.sendKeys(selectPembimbing, Keys.chord(Keys.ENTER))

//remove dosen
WebUI.click(removePembimbing)
WebUI.verifyTextNotPresent('Dosen 3', false)

//submit
WebUI.click(simpanButton)

WebUI.verifyTextPresent('Berhasil menambah topik', false)

//cari Penawaran Topik
WebUI.callTestCase(findTestCase('Test Cases/Dosen/penawaranTopik/cariPenawaranTopik'), ['judul': judul, 'keyword': key1], FailureHandling.STOP_ON_FAILURE)



