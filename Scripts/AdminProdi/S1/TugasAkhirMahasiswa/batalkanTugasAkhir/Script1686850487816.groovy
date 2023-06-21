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

//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)


//Tugas Akhir Page
buttonTAMhs = findTestObject('Object Repository/Page_Beranda/tugasAkhirMahasiswa')
table = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/table')

WebUI.waitForElementVisible(buttonTAMhs, 0)
WebUI.click(buttonTAMhs)

WebUI.waitForElementVisible(table, 0)

//filter tugas akhir

status = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/status')
dosen = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/dosenPembimbing')
input = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/input')
buttonTampilkan = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/buttonTampilkan')

WebUI.click(status)
WebUI.waitForElementVisible(input, 0)
WebUI.click(input)
WebUI.setText(input, 'Disetujui pembimbing')
WebUI.click(input)
WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

WebUI.click(buttonTampilkan)
sleep 2

//def text = WebUI.getText(table)
//if (text.contains('Rekayasa Perangkat Lunak') && text.contains('Dalam pengerjaan')) {
//	print(laboratorium)
//}
//else {
//	KeywordUtil.markFailed('did not contain expected text')
//}


//cari
search = findTestObject('Object Repository/Page_Tugas Akhir Mahasiswa  myITS Thesis/search')
WebUI.click(search)
WebUI.setText(search, 'Dummy')
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
