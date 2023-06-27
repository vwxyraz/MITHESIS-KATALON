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
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.RandomStringUtils as RandStr

//WebUI.callTestCase(findTestCase("Test Cases/AdminProdi/S1/Login_Auth_S1"), null)

//Tugas Akhir Page
buttonAdministrasi = findTestObject('Object Repository/Page_Beranda/Administrasi')
buttonKriteriaNilai = findTestObject('Object Repository/Page_Administrasi/kriteriaPenilaianProdi')

int currentTab = WebUI.getWindowIndex()


WebUI.waitForElementVisible(buttonAdministrasi, 0)
WebUI.click(buttonAdministrasi)
WebUI.waitForElementVisible(buttonKriteriaNilai, 0)
WebUI.click(buttonKriteriaNilai)

//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/cari'), 0)

//rubrikNilai = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/cardRubrikNilai', ['rubrikNilaiObject': objectCard])
//WebUI.click(rubrikNilai)
//
//editRubrikButton = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonEditRubrikTest')
//
//WebUI.waitForElementVisible(editRubrikButton, 0)
//WebUI.click(editRubrikButton)
//
//WebUI.switchToWindowIndex(currentTab+1)
WebUI.navigateToUrl('https://dev-thesis.its.ac.id/admin/kriteria-penilaian/96E15C95-5108-485D-8435-DB58326C0D9C')

editRubrik = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/editRubrikPenilaianButton')
tambahKriteria = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/tambahKriteriaButton')
editDeskripsi = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/editDeskripsiButton')
lihatIndikator = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/lihatIndikatorButton')
tambahIndikator = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/tambahIndikatorButton')

WebUI.waitForElementVisible(editRubrik, 0)
WebUI.click(editRubrik)

simpanRubrik = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/simpanRubrikButton')

//non aktif
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalEditRubrik'), 0)
WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonTidakAktif'))

WebUI.click(simpanRubrik)

WebUI.verifyTextPresent('Berhasil update rubrik penilaian', false)

//aktif
WebUI.waitForElementVisible(editRubrik, 0)
WebUI.click(editRubrik)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalEditRubrik'), 0)
WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonAktif'))

WebUI.click(simpanRubrik)

WebUI.verifyTextPresent('Berhasil update rubrik penilaian', false)

//lihat indikator
WebUI.click(lihatIndikator)
WebUI.waitForElementVisible(tambahIndikator, 0)
WebUI.click(tambahIndikator)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalTambahIndikator'), currentTab)

namaIndikator = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputIndikatorPenilaian')
nilaiMin = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputNilaiMin')
nilaiMax = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputNilaiMax')
simpanIndikator = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/simpanIndikatorButton')

indikator = RandStr.randomAlphabetic(5)
WebUI.waitForElementVisible(namaIndikator, 0)
WebUI.click(namaIndikator)
WebUI.setText(namaIndikator, indikator)

WebUI.click(nilaiMin)
WebUI.setText(nilaiMin, '20')
WebUI.click(nilaiMax)
WebUI.setText(nilaiMax, '70')

WebUI.click(simpanIndikator)

WebUI.verifyTextPresent('Indikator penilaian berhasil ditambahkan!', false)


//delete indikator
WebUI.click(lihatIndikator)

WebUI.verifyTextPresent(indikator, false)

WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonDeleteIndikator'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/hapusIndikatorButton'), 0)
WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/hapusIndikatorButton'))

WebUI.verifyTextPresent('Data indikator penilaian berhasil dihapus!', false)

////tambah kriteria
WebUI.click(tambahKriteria)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalTambahKriteria'), 0)

//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalTambahKriteria'), currentTab)

inputDeskripsi = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputDeskripsiKriteria')
inputPersentase = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputPersentaseKriteria')
inputIndikator = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputIndikatorKriteria')
inputMin =findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputNilaiMinKriteria')
inputMax =findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputNilaiMaxKriteria')

desk = RandStr.randomAlphabetic(8)
indi = RandStr.randomAlphabetic(5)
WebUI.click(inputDeskripsi)
WebUI.setText(inputDeskripsi, desk)
WebUI.click(inputPersentase)
WebUI.setText(inputPersentase, '25')
WebUI.click(inputIndikator)
WebUI.setText(inputIndikator, indi)
WebUI.click(inputMin)
WebUI.setText(inputMin, '10')
WebUI.click(inputMax)
WebUI.setText(inputMax, '50')

WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/tambahIndikatorKriteriaButton'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/removeIndikatorKriteriaButton'), currentTab)
WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/removeIndikatorKriteriaButton'))

WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/simpanKriteriaButton'))

WebUI.verifyTextPresent('Kriteria penilaian berhasil ditambahkan', false)

//edit and delete kriteria
modalEditKriteria = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/modalEditKriteria')
editKriteriaBaru = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/editKriteriaBaru', ['deskripsi' : desk])
simpanEditKriteria = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/simpanEditKriteriaButton')

WebUI.click(editKriteriaBaru)
//WebUI.waitForElementVisible(modalEditKriteria, currentTab)

inputPersentaseEdit = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/inputPersentaseEdit')
WebUI.waitForElementVisible(inputPersentaseEdit, currentTab)
WebUI.click(inputPersentaseEdit)
WebUI.setText(inputPersentaseEdit, '30')
WebUI.click(findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonTidakAktifEdit'))

WebUI.click(simpanEditKriteria)

WebUI.verifyTextPresent('Berhasil update kriteria penilaian', false)

//delete
deleteKriteria = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/buttonDeleteKriteria')
WebUI.click(editKriteriaBaru)
WebUI.waitForElementVisible(deleteKriteria, 0)
WebUI.click(deleteKriteria)

delete = findTestObject('Object Repository/Page_Kriteria Penilaian Prodi  myITS Thesis/deleteKriteria')
WebUI.waitForElementVisible(delete, 0)
WebUI.click(delete)

WebUI.verifyTextPresent('Berhasil menghapus data Rubrik penilaian!', false)


//WebUI.closeBrowser()