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

//go to detil tugas akhir page
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Tugas Akhir  myITS Thesis/detailTugasAkhirMhs1'), 0)
//WebUI.click(findTestObject('Object Repository/Page_Tugas Akhir  myITS Thesis/detailTugasAkhirMhs1'))
WebUI.navigateToUrl('https://dev-thesis.its.ac.id/tesis/usulan/3D470267-80EA-4A34-B4C6-963B8C9382D6')

//go to usulkan perubahan
WebUI.verifyTextPresent('Detail Tugas Akhir', false)
moreButton = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/moreButton')
usulkanPerubahanButton = findTestObject('Object Repository/Page_Detail Tugas Akhir  myITS Thesis/usulkanPerubahan')
WebUI.waitForElementVisible(moreButton, 0)
WebUI.click(moreButton)

WebUI.waitForElementVisible(usulkanPerubahanButton, 0)
WebUI.click(usulkanPerubahanButton)

judulBaru = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/judulBaru')
judulBaruEn = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/judulBaruEn')
abstrakBaru = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/abstrakBaru')
abstrakBaruEn = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/abstrakBaruEn')
kataKunciBaru = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/kataKunciBaru')
kataKunciBaruEn = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/kataKunciBaruEn')
simpanButton = findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/button_Simpan')

WebUI.verifyTextPresent('Perubahan Data Tugas Akhir', false)

stringJudul = RandStr.randomAlphabetic(20)
WebUI.click(judulBaru)
WebUI.setText(judulBaru, stringJudul)

stringJudulEn = RandStr.randomAlphabetic(20)
WebUI.click(judulBaruEn)
WebUI.setText(judulBaruEn, stringJudulEn)

stringAbstrak = RandStr.randomAlphabetic(50)
WebUI.click(abstrakBaru)
WebUI.setText(abstrakBaru, stringAbstrak)

stringAbstrak = RandStr.randomAlphabetic(50)
WebUI.click(abstrakBaruEn)
WebUI.setText(abstrakBaruEn, stringAbstrak)

keyword = RandStr.randomAlphabetic(5)
keyword2 = RandStr.randomAlphabetic(5)
WebUI.click(kataKunciBaru)
WebUI.setText(kataKunciBaru, keyword)
WebUI.sendKeys(kataKunciBaru, Keys.chord(Keys.ENTER))
WebUI.click(kataKunciBaru)
WebUI.setText(kataKunciBaru, keyword2)
WebUI.sendKeys(kataKunciBaru, Keys.chord(Keys.ENTER))

keyword = RandStr.randomAlphabetic(5)
keyword2 = RandStr.randomAlphabetic(5)
WebUI.click(kataKunciBaruEn)
WebUI.setText(kataKunciBaruEn, keyword)
WebUI.sendKeys(kataKunciBaruEn, Keys.chord(Keys.ENTER))
WebUI.click(kataKunciBaruEn)
WebUI.setText(kataKunciBaruEn, keyword2)
WebUI.sendKeys(kataKunciBaruEn, Keys.chord(Keys.ENTER))

WebUI.click(simpanButton)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/konfirmasiSimpanModule'), 0)
WebUI.click(findTestObject('Object Repository/Page_Perubahan Data Tugas Akhir  myITS Thesis/konfirmasiSimpanButton'))
//WebUI.click(kataKunciBaruEn)
//WebUI.setText(kataKunciBaruEn, keyword)

WebUI.verifyTextPresent('Berhasil membuat usulan perubahan tugas akhir', false)

