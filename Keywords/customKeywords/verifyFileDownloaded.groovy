package customKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
//import com.kms.katalon.core.annotation.Keyword

import com.kms.katalon.core.util.KeywordUtil

import org.testng.Assert



import internal.GlobalVariable

public class verifyFileDownloaded {

	@Keyword
	public Boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String lastAttempt = '';

		if (dirContents.length > 0) {
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().equals(fileName)) {
					// File has been found, it can now be deleted:
					dirContents[i].delete();
					KeywordUtil.markPassed(fileName + " exist in " + downloadPath + ' and was deleted');
					return true;
				}

				lastAttempt = dirContents[i].getName().equals(fileName);
			}

			if (lastAttempt != fileName) {
				KeywordUtil.markFailed(fileName + ' does not exist in ' + downloadPath);

				return false;
			}
		}
	}
}