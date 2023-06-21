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
import internal.GlobalVariable
import net.bytebuddy.utility.RandomString

import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.util.Date
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.lang.RandomStringUtils as RandStr
//import Keywords.customKeywords
import org.apache.commons.text.RandomStringGenerator


//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

//Tugas Akhir Page
buttonTAMhs = findTestObject('Object Repository/Page_Beranda/tugasAkhirMahasiswa')
table = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/table')

WebUI.waitForElementVisible(buttonTAMhs, 0)
WebUI.click(buttonTAMhs)

WebUI.waitForElementVisible(table, 0)

buttonTampilkan = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/buttonTampilkan')
buttonTambah = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/buttonTambah')
buttonNext = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/buttonNext')

//download
downloadButton = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/downloadButton')

Date today = new Date()
String todaysDate = today.format('ddMMYYY')
System.out.println(todaysDate)

String home = System.getProperty('user.home')
String userDownloads = new File(home + '/Downloads/')


file = todaysDate + '_Daftar Tugas Akhir Mahasiswa S1 Teknik Informatika.xlsx'
System.out.println(file)
System.out.println(userDownloads)
WebUI.click(downloadButton)

WebUI.delay(5)

CustomKeywords.'customKeywords.verifyFileDownloaded.isFileDownloaded'(userDownloads, file)

WebUI.delay(1)

//tambah tugas akhir mahasiswa
WebUI.click(buttonTambah)

mahasiswa = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/mahasiswa')
judul = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/judul')
judulEn = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/judulEn')
abstrak = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/abstrak')
abstrakEn = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/abstrakEn')
keyword = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/kataKunci')
keywordEn = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/kataKunciEng')
lab = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/laboratorium')
pembimbing = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/pembimbing')

select = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/select')
selectRes = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/selectResult')

simpanButton = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/button_Simpan')
modalSimpan = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/modalSimpan')
konfirmasiSimpan = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/confirmSimpan')


WebUI.click(mahasiswa)
WebUI.waitForElementVisible(select, 0)
WebUI.click(select)
WebUI.setText(select, namaMahasiswa)
WebUI.waitForElementVisible(selectRes, 0)
WebUI.click(select)
WebUI.sendKeys(select, Keys.chord(Keys.ENTER))

stringJudul = RandStr.randomAlphabetic(20)
WebUI.click(judul)
WebUI.setText(judul, stringJudul)

stringJudulEn = RandStr.randomAlphabetic(20)
WebUI.click(judulEn)
WebUI.setText(judulEn, stringJudulEn)

stringAbstrak = RandStr.randomAlphabetic(50)
WebUI.click(abstrak)
WebUI.setText(abstrak, stringAbstrak)

stringAbstrakEn = RandStr.randomAlphabetic(50)
WebUI.click(abstrakEn)
WebUI.setText(abstrakEn, stringAbstrakEn)

key1 = RandStr.randomAlphabetic(5)
key2 = RandStr.randomAlphabetic(5)
WebUI.click(keyword)
WebUI.setText(keyword, key1)
WebUI.sendKeys(keyword, Keys.chord(Keys.ENTER))
WebUI.click(keyword)
WebUI.setText(keyword, key2)
WebUI.sendKeys(keyword, Keys.chord(Keys.ENTER))

WebUI.click(keywordEn)
WebUI.setText(keywordEn, key1)
WebUI.sendKeys(keywordEn, Keys.chord(Keys.ENTER))
WebUI.click(keywordEn)
WebUI.setText(keywordEn, key2)
WebUI.sendKeys(keywordEn, Keys.chord(Keys.ENTER))

WebUI.click(lab)
WebUI.waitForElementVisible(select, 0)
WebUI.click(select)
WebUI.setText(select, 'Rekayasa Perangkat Lunak')
WebUI.waitForElementVisible(selectRes, 0)
WebUI.click(select)
WebUI.sendKeys(select, Keys.chord(Keys.ENTER))

WebUI.click(pembimbing)
WebUI.waitForElementVisible(select, 0)
WebUI.click(select)
WebUI.setText(select, 'Rizky Januar')
WebUI.waitForElementVisible(selectRes, 0)
WebUI.click(select)
WebUI.sendKeys(select, Keys.chord(Keys.ENTER))

WebUI.click(simpanButton)

WebUI.waitForElementVisible(modalSimpan, 0)
WebUI.click(konfirmasiSimpan)

WebUI.verifyTextPresent('Berhasil menambahkan Tugas Akhir mahasiswa aktif.', false)

//filter tugas akhir
laboratorium = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/laboratorium')
semester =findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/semester')
status = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/status')
dosen = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/dosenPembimbing')
input = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/input')

WebUI.click(buttonNext)

WebUI.scrollToElement(buttonTambah, 0)

WebUI.click(laboratorium)
WebUI.waitForElementVisible(input, 0)
WebUI.click(input)
WebUI.setText(input, 'Rekayasa Perangkat Lunak')
WebUI.click(input)
WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

WebUI.click(status)
WebUI.waitForElementVisible(input, 0)
WebUI.click(input)
WebUI.setText(input, 'Dalam pengerjaan')
WebUI.click(input)
WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

WebUI.click(buttonTampilkan)
sleep 2

def text = WebUI.getText(table)
if (text.contains('Rekayasa Perangkat Lunak') && text.contains('Dalam pengerjaan')) {
	print(laboratorium)
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}


//cari
search = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/search')
WebUI.click(search)
WebUI.setText(search, namaMahasiswa)
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))

judulTable = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/judulTA')
moreButton = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/moreButton')
batalButton = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/batalButton')
konfirmasiBatal = findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/confirmBatal')

WebUI.click(judulTable)
WebUI.waitForElementVisible(moreButton, 0)
WebUI.click(moreButton)
WebUI.waitForElementVisible(batalButton, 0)
WebUI.click(batalButton)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Tambah Tugas Akhir Mahasiswa  myITS Thesis/modalBatal'), 0)
WebUI.click(konfirmasiBatal)

WebUI.verifyTextPresent('Berhasil membatalkan tesis mahasiswa.', false)



//WebUI.closeBrowser()

