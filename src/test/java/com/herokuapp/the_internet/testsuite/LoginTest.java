package com.herokuapp.the_internet.testsuite;

import com.herokuapp.the_internet.pages.LoginPage;
import com.herokuapp.the_internet.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPg = new LoginPage();

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPg.enterUsernameField("tomsmith");
        loginPg.enterPasswordField("SuperSecretPassword!");
        loginPg.clickOnLoginButton();
        String actualMessage = loginPg.getSecureAreaText();
        Assert.assertEquals(actualMessage,"Secure Area", "Login page not displayed");
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        loginPg.enterUsernameField("tomsmith1");
        loginPg.enterPasswordField("SuperSecretPassword!");
        loginPg.clickOnLoginButton();
        String actualMessage = loginPg.getInvalidUsernameText();
        Assert.assertEquals(actualMessage,"Your username is invalid!\n" + "×", "error message");
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        loginPg.enterUsernameField("tomsmith");
        loginPg.enterPasswordField("SuperSecretPassword");
        loginPg.clickOnLoginButton();
        String actualMessage = loginPg.getInvalidPasswordText();
        Assert.assertEquals(actualMessage,"Your password is invalid!\n" + "×", "error message");

    }
}
