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


//edit konfigurasi prodi
buttonEdit = findTestObject('Object Repository/Page_KonfigProdi/a_Edit')
WebUI.click(buttonEdit)

form = findTestObject('Object Repository/Page_KonfigProdi/formEdit')
WebUI.waitForElementVisible(form, 0)

//delete PIC 1
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