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

WebUI.callTestCase(findTestCase("Test Cases/Mahasiswa/TugasAkhir/tugasAkhirPage"), ['username': username, 'password': password])


//Buat Usulan Tugas AKhir
buttonBuatUsulan = findTestObject('Object Repository/Page_Tugas Akhir  myITS Thesis/buttonBuatUsulan')
WebUI.waitForElementVisible(buttonBuatUsulan, 0)
WebUI.click(buttonBuatUsulan)

WebUI.verifyTextPresent('Usulan Tugas Akhir', false)

inputJudul = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputJudul')
inputJudulEn = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputJudulEn')
inputRencanaPenelitian = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputRencanaPenelitian')
inputKeyword = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputKeyword')
inputKeywordEn = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputKeywordEn')
selectDosen1 = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectDosen1')
selectDosen2 = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectDosen2')
inputSelect = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputSelect')
inputKetBimbingan = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/inputKetBimbingan')

stringJudul = RandStr.randomAlphabetic(20)
WebUI.click(inputJudul)
WebUI.setText(inputJudul, stringJudul)

stringJudulEn = RandStr.randomAlphabetic(20)
WebUI.click(inputJudulEn)
WebUI.setText(inputJudulEn, stringJudulEn)

string = RandStr.randomAlphabetic(100)
WebUI.click(inputRencanaPenelitian)
WebUI.setText(inputRencanaPenelitian, string)

string = RandStr.randomAlphabetic(5)
WebUI.click(inputKeyword)
WebUI.setText(inputKeyword, string)
WebUI.sendKeys(inputKeyword, Keys.chord(Keys.ENTER))
string = RandStr.randomAlphabetic(5)
WebUI.click(inputKeyword)
WebUI.setText(inputKeyword, string)
WebUI.sendKeys(inputKeyword, Keys.chord(Keys.ENTER))

string = RandStr.randomAlphabetic(5)
WebUI.click(inputKeywordEn)
WebUI.setText(inputKeywordEn, string)
WebUI.sendKeys(inputKeywordEn, Keys.chord(Keys.ENTER))
string = RandStr.randomAlphabetic(5)
WebUI.click(inputKeywordEn)
WebUI.setText(inputKeywordEn, string)
WebUI.sendKeys(inputKeywordEn, Keys.chord(Keys.ENTER))

WebUI.click(selectDosen1)
WebUI.waitForElementVisible(inputSelect, 0)
WebUI.click(inputSelect)
WebUI.setText(inputSelect, 'Dosen 3')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectResult1'), 0)
WebUI.click(inputSelect)
WebUI.sendKeys(inputSelect, Keys.chord(Keys.ENTER))

WebUI.click(selectDosen2)
WebUI.waitForElementVisible(inputSelect, 0)
WebUI.click(inputSelect)
WebUI.setText(inputSelect, 'Dosen 2')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectResult2'), 0)
WebUI.click(inputSelect)
WebUI.sendKeys(inputSelect, Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/addDosbing'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/removeDosbing'), 0)
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/removeDosbing'))

//berkelompok
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonBerkelompok'))

string = RandStr.randomAlphabetic(100)
WebUI.click(inputKetBimbingan)
WebUI.setText(inputKetBimbingan, string)


WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonSimpanUsulan'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/moduleKonfirmasiSimpan'), 0)
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonKonfirmasiSimpan'))

WebUI.verifyTextPresent('Berhasil membuat usulan tugas akhir', false)

editAnggota = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/editAnggota')
tambahAnggotaButton = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/addAnggota')
anggota2MoreButton = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/moreButtonAnggota2')
hapusAnggota2Button = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonHapusAnggota2')

WebUI.click(editAnggota)
WebUI.waitForElementVisible(tambahAnggotaButton, 0)
WebUI.click(tambahAnggotaButton)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/moduleAddAnggota'), 0)
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectAnggotaMhs'))
WebUI.waitForElementVisible(inputSelect, 0)
WebUI.click(inputSelect)
WebUI.setText(inputSelect, 'Mahasiswa 3')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/selectResultAnggotaMhs'), 0)
WebUI.click(inputSelect)
WebUI.sendKeys(inputSelect, Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonKonfirmasiTambahAnggota'))

//Berhasil menambah anggota.
WebUI.verifyTextPresent('Berhasil menambah anggota.', false)

//WebUI.waitForElementVisible(anggota2MoreButton, 0)
WebUI.click(anggota2MoreButton)
WebUI.waitForElementVisible(hapusAnggota2Button, 0)
WebUI.click(hapusAnggota2Button)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/moduleKonfirmasiHapusAnggota'), 0)
WebUI.click(findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/buttonKonfirmasiHapusAnggota'))

//Berhasil menghapus anggota.
WebUI.verifyTextPresent('Berhasil menghapus anggota.', false)


WebUI.closeBrowser()

//WebUI.callTestCase(findTestCase('Test Cases/Dosen/beranda/tolakPembimbinganDosen3'), ['judul': stringJudul], FailureHandling.STOP_ON_FAILURE)
//
//WebUI.callTestCase(findTestCase('Test Cases/Dosen/beranda/tolakPembimbinganDosen2'), ['judul': stringJudul], FailureHandling.STOP_ON_FAILURE)