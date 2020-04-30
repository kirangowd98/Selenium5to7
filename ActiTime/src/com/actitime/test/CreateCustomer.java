package com.actitime.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.pom.HomePage;
import com.actitime.pom.TasksListPage;
import com.actitme.generics.BaseClass;
@Listeners(com.actitme.generics.ListenersImplementation.class)
public class CreateCustomer extends BaseClass{
	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String Etext=f.getExcelData("./data/testscriptdata.xlsx","CreateCustomer",1,2);
		HomePage h=new HomePage(driver);
		h.clickOnTaskTab();
		TasksListPage t=new TasksListPage(driver);
		t.getAddNewCustomDD().click();
		t.getNewCustomerMenu().click();
		t.getEnterCustomerNameTbx().sendKeys(f.getExcelData("./data/testscriptdata.xlsx","CreateCustomer",1,2));
		t.getSelectCustomerDD().click();
		t.getOurcompanyoption().click();
		t.getCreateCustomerBtn().click();
		String Atext=t.getActualText().getText();
        Assert.assertEquals(Atext,Etext);
	}
}

	

