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


//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

//Rekap Nilai Page
buttonRekapNilai = findTestObject('Object Repository/Page_Beranda/rekapNilai') 
table = findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/table')

WebUI.waitForElementVisible(buttonRekapNilai, 0)
WebUI.click(buttonRekapNilai)

WebUI.waitForElementVisible(table, 0)

//download
download = findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/button_Download Excel')

Date today = new Date()
String todaysDate = today.format('ddMMYYY')
System.out.println(todaysDate)

String home = System.getProperty('user.home')
String userDownloads = new File(home + '/Downloads/')

file = todaysDate + '_Rekapitulasi Nilai Sidang Proposal Tugas Akhir Mahasiswa S1 Teknik Informatika Semester Genap 2022-2023.xlsx'
System.out.println(file)
System.out.println(userDownloads)
WebUI.click(download)

WebUI.delay(5)

CustomKeywords.'customKeywords.verifyFileDownloaded.isFileDownloaded'(userDownloads, file)

WebUI.delay(1)

//nilai
WebUI.click(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/nilai'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/modalNilai'), 0)
//WebUI.waitForElementVisible(, 0)
WebUI.click(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/permanenNilai'))

def permanen = WebUI.getText(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/nilaiColumn'))
if (permanen.contains('Permanen')) {
//	print("%s", nama.contains(namaDosen))
	print(permanen)
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

WebUI.click(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/permanenNilai'))
WebUI.click(findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/buttonTutup'))

//search
semester = findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/selectSemester')
searchSemester = findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/searchSemester')
WebUI.click(semester)
WebUI.waitForElementVisible(searchSemester, 0)
WebUI.setText(searchSemester, sem)
WebUI.sendKeys(searchSemester, Keys.chord(Keys.ENTER))
//WebUI.verifyElementText(semester, sem)

//search nilai
searchNilai = findTestObject('Object Repository/Page_Rekapitulasi Nilai Sidang  myITS Thesis/input')
//WebUI.scrollToPosition(0, 0)
WebUI.waitForElementVisible(searchNilai, 0)
WebUI.click(searchNilai)
WebUI.setText(searchNilai, namaSiswa)
WebUI.verifyElementPresent(searchNilai, 0)

def nama = WebUI.getText(table)
if (nama.contains(namaSiswa)) {
//	print("%s", nama.contains(namaDosen))
	print(nama)
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

WebUI.click(searchNilai)
WebUI.clearText(searchNilai)


//WebUI.closeBrowser()

