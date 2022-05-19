package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.MyPage;
import org.junit.Test;

public class MyTest extends BaseTest {

    @Test
    public void myTest(){
        MyPage myPage = new MyPage();
        myPage.login();
        myPage.scrollAndSelect();
        myPage.turnTheMainPage();
        myPage.randomUrunSecimi();
        myPage.sepeteEkle();
        myPage.favoridenSilme();
        myPage.satinAlma();
        myPage.adresKaydetme();
        myPage.kartBilgileriEkleme();
        myPage.logOut();
    }

}
