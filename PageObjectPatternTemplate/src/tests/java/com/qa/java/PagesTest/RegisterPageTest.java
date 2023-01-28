package com.qa.java.PagesTest;


import java.util.Random;

import com.qa.java.base.BaseTest;
import com.qa.java.util.Constants;
import com.qa.java.util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


    public class RegisterPageTest extends BaseTest {

        @BeforeClass
        public void regSetup() {
            regPage = loginPage.navigateToRegisterPage();
        }


        public String getRandomEmailId() {
            Random random = new Random();
            String email = "febautomation"+random.nextInt(1000)+"@gmail.com";
            return email;
        }


        @DataProvider
        public Object[][] getRegisterTestData() {
            Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
            return regData;
        }

        @Test(dataProvider = "getRegisterTestData")
        public void userRegisterTest(String firstname, String lastname,
                                     String telephone, String password,
                                     String subscribe) {

            Assert.assertTrue(regPage.userRegister(firstname, lastname,
                    getRandomEmailId(), telephone, password, subscribe));

        }

    }
