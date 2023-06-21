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


//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Administrasi/PeriodeSidang/periodeSidang"), null)

buttonTambah = findTestObject('Object Repository/Page_PeriodeSidang/a_Tambah')
WebUI.click(buttonTambah)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PeriodeSidang/formBuatPeriodeSidang'), 0)

//input jenis sidang
jenisSidang = findTestObject('Object Repository/Page_PeriodeSidang/jenisSidang')
inputJenisSidang = findTestObject('Object Repository/Page_PeriodeSidang/searchJenisSidang')
WebUI.click(jenisSidang)
WebUI.waitForElementVisible(inputJenisSidang, 0)
WebUI.setText(inputJenisSidang, jenis)
WebUI.sendKeys(inputJenisSidang, Keys.chord(Keys.ENTER))
WebUI.verifyElementText(jenisSidang, jenis)

//input rubrik penilaian
rubrikPenilaian = findTestObject('Object Repository/Page_PeriodeSidang/rubrikPenilaian')
WebUI.click(rubrikPenilaian)
WebUI.waitForElementVisible(inputJenisSidang, 0)
//WebUI.setText(inputJenisSidang, jenis)
WebUI.sendKeys(inputJenisSidang, Keys.chord(Keys.ENTER))
//WebUI.verifyElementText(jenisSidang, jenis)


//input nama sidang
inputNamaSidang = findTestObject('Object Repository/Page_PeriodeSidang/namaSidang')
WebUI.click(inputNamaSidang)
WebUI.setText(inputNamaSidang, namaSidang)

//input nama sidang eng
namaSidangEng = findTestObject('Object Repository/Page_PeriodeSidang/namaSidangInggris')
WebUI.click(namaSidangEng)
WebUI.setText(namaSidangEng, name)

//input kuota
kuota = findTestObject('Object Repository/Page_PeriodeSidang/kuotaPendaftaran')
WebUI.click(kuota)
WebUI.setText(kuota, '20')

//admin sidang
adminSidang = findTestObject('Object Repository/Page_PeriodeSidang/adminSidang')
inputAdminSidang = findTestObject('Object Repository/Page_PeriodeSidang/searchAdminSidang')
WebUI.click(adminSidang)
WebUI.waitForElementVisible(inputAdminSidang, 0)
WebUI.setText(inputAdminSidang, dosen)
sleep 10
WebUI.click(inputAdminSidang)
WebUI.sendKeys(inputJenisSidang, Keys.chord(Keys.ENTER))

nama = WebUI.getText(adminSidang)
if (nama.contains(dosen)) {
	print(nama.contains(dosen))
}
else {
	KeywordUtil.markFailed('did not contain expected text')
}

//tanggal daftar
tanggalMulai = findTestObject('Object Repository/Page_PeriodeSidang/tanggalMulaiPendaftaran')
WebUI.click(tanggalMulai)
WebUI.sendKeys(tanggalMulai, Keys.chord(Keys.ENTER))

tanggalAkhir = findTestObject('Object Repository/Page_PeriodeSidang/tanggalAkhirPendaftaran')
WebUI.waitForElementClickable(tanggalAkhir, 0)
WebUI.click(tanggalAkhir)
WebUI.sendKeys(tanggalAkhir, Keys.chord(Keys.ENTER))

//tanggal sidang
tanggalMulai = findTestObject('Object Repository/Page_PeriodeSidang/tanggalMulaiSidang')
WebUI.click(tanggalMulai)
//WebUI.sendKeys(tanggalMulai, Keys.chord(Keys.ENTER))

tanggalAkhir = findTestObject('Object Repository/Page_PeriodeSidang/tanggalAkhirSidang')
WebUI.waitForElementClickable(tanggalAkhir, 0)
WebUI.click(tanggalAkhir)
//WebUI.sendKeys(tanggalAkhir, Keys.chord(Keys.ENTER))

//submit
WebUI.click(findTestObject('Object Repository/Page_PeriodeSidang/buttonBuatSidang'))

WebUI.verifyTextPresent('Berhasil menyimpan periode sidang!', false)

