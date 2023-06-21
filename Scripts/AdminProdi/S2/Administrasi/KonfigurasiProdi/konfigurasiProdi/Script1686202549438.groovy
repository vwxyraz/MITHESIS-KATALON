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

buttonAdministrasi = findTestObject('Object Repository/Page_Beranda/Administrasi')
buttonKonfigProdi = findTestObject('Object Repository/Page_Administrasi/konfigurasiProdi')

WebUI.waitForElementVisible(buttonAdministrasi, 0)
WebUI.click(buttonAdministrasi)
WebUI.waitForElementVisible(buttonKonfigProdi, 0)
WebUI.click(buttonKonfigProdi)


//verify element
WebUI.verifyTextPresent('Konfigurasi Prodi', false)
//WebUI.verifyTextPresent('Basis penentuan alokasi pembimbing', false)
//WebUI.verifyTextPresent('PIC Prodi', false)

//edit konfigurasi prodi
buttonEdit = findTestObject('Object Repository/Page_KonfigProdi/a_Edit')
WebUI.click(buttonEdit)

form = findTestObject('Object Repository/Page_KonfigProdi/formEdit')
WebUI.waitForElementVisible(form, 0)

//boleh berkelompok
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/bolehKelompok'))
//ada sidang proposal
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/adaSidangProposal'))
//input minimal bimbingan
input = findTestObject('Object Repository/Page_KonfigProdi/inputMinBimbingan')
WebUI.click(input)
WebUI.clearText(input)
WebUI.sendKeys(input, Keys.chord(Keys.ARROW_UP))
//ada sidang kemajuan
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/adaSidangKemajuan'))
//input minimal bimbingan kemajuan 1
input = findTestObject('Object Repository/Page_KonfigProdi/inputMinBimbinganKemajuan1')
WebUI.click(input)
WebUI.clearText(input)
WebUI.sendKeys(input, Keys.chord(Keys.ARROW_UP))
//ada sidang akhir
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/adaSidangAkhir'))
//input minimal bimbingan akhir
input = findTestObject('Object Repository/Page_KonfigProdi/inputMinBimbinganAkhir')
WebUI.click(input)
WebUI.clearText(input)
WebUI.sendKeys(input, Keys.chord(Keys.ARROW_UP))
//lingkup prodi
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/lingkupProdi'))

hapus = findTestObject('Object Repository/Page_KonfigProdi/buttonHapus')
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/removePIC1'))
WebUI.waitForElementVisible(hapus, 0)
WebUI.click(hapus)

//notifikasi
WebUI.verifyTextPresent('Berhasil menghapus PIC Prodi!', false)

//input PIC prodi
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/PICProdi'))
input = findTestObject('Object Repository/Page_KonfigProdi/inputPICProdi')
//WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/PICProdi'))
WebUI.waitForElementVisible(input, 0)
WebUI.setText(input, 'hudan')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_KonfigProdi/resultPIC'), 0)
//sleep 5
//WebUI.verifyElementText(findTestObject('Object Repository/Page_KonfigProdi/resultPIC'), 'Hudan )
WebUI.click(input)
WebUI.sendKeys(input, Keys.chord(Keys.ENTER))

//simpan perubahan
WebUI.click(findTestObject('Object Repository/Page_KonfigProdi/button_Simpan Perubahan'))

//notifikasi
WebUI.verifyTextPresent('Berhasil menyimpan konfigurasi prodi!', false)

//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Administrasi/KonfigurasiProdi/editKonfigurasi"), null)

WebUI.closeBrowser()
