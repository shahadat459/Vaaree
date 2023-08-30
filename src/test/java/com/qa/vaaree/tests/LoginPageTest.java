package com.qa.vaaree.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.vaaree.base.BaseTest;
import com.qa.vaaree.utils.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	/*
	 * @Test public void forgotPasswordLinkExistTest() {
	 * Assert.assertTrue(loginPage.isForgotPwdExist()); }
	 */

	@Test
	public void loginTest() {
		accountPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

}