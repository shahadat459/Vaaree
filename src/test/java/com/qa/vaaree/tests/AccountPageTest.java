package com.qa.vaaree.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.vaaree.base.BaseTest;
import com.qa.vaaree.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic:1001 - Accout Page")
@Story("US 1001 : Create a account page wiht dashboard,logout and Home links")
public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Severity(SeverityLevel.MINOR)
	@Description("Title should contain domain name")
	@Feature("Title view")
	@Test
	public void accPageTitleTest() {
		String actTitle = accountPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}

	@Severity(SeverityLevel.TRIVIAL)
	@Description("URL should contain domain name")
	@Feature("URL view")
	@Test
	public void accPageUrlTest() {
		String actUrl = accountPage.getAccPageUrl();
		Assert.assertTrue(actUrl.contains("account"));
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Logout should contain correct name")
	@Feature("Logout view")
	@Test
	public void isLogoutLinkExistTest() {

		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("Dashboard should contain correct name")
	@Feature("Dashboard view")
	@Test
	public void isDashboardLinkExistTest() {

		Assert.assertTrue(accountPage.isdashboardLinkExist());
	}

}
