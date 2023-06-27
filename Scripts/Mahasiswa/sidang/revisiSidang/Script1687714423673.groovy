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
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandStr

WebUI.callTestCase(findTestCase('Test Cases/Mahasiswa/sidang/sidangPage'), ['username': username, 'password': password])

sidangakhir = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/sidangAkhir')
WebUI.click(sidangakhir)

revisi = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/buttonRevisiSidang')
WebUI.waitForElementVisible(revisi, 0)
WebUI.click(revisi)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/modalRevisi'), 0)

inputIsi = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/inputIsiRevisi')
inputHalaman = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/inputHalamanRevisi')

isi = RandStr.randomAlphabetic(15)
WebUI.waitForElementVisible(inputIsi, 0)
WebUI.click(inputIsi)
WebUI.setText(inputIsi, isi)

hlmn = RandStr.randomNumeric(1)
WebUI.waitForElementVisible(inputHalaman, 0)
WebUI.click(inputHalaman)
WebUI.setText(inputHalaman, hlmn)

WebUI.click(findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/buttonsimpanRevisi'))

WebUI.verifyTextPresent('Berhasil menambah revisi', false)

WebUI.click(findTestObject('Object Repository/Page_Beranda/sidangButton'))
revisiButton = findTestObject('Object Repository/Page_Riwayat Sidang Saya  myITS Thesis/revisiButton')
WebUI.waitForElementVisible(revisiButton, 0)
WebUI.click(revisiButton)



