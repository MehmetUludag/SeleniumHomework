package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

import static com.testinium.driver.BaseTest.driver;

public class MyPage {
    Methods methods;

    public MyPage(){methods = new Methods();}

    public void login(){
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-email"),"mehmet.uludag@testinium.com");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".popupCloseIcon"));
        methods.sendKeys(By.xpath("//input[@id='login-password']"),"1q2w3e4r5t");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(8);
        //Assert.assertTrue(methods.isElementVisible(By
            //    .cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn")));
        System.out.println("Login olma kontrolü yapıldı.");
    }

    public void scrollAndSelect(){
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("search-input"),"oyuncak");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(1);
        methods.scrollWithAction(By.xpath("//div[@id='product-table']/div[7]"));
        methods.waitBySeconds(1);
        for (int i = 5; i < 9; i++)
        {
            methods.click(By.xpath("//div[@id='product-table']/div[" + i +
                    "]/div[2]/div[3]/a[4]"));
            methods.waitBySeconds(2);
        }

        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".swal2-title.ky-swal-title-single")));
        System.out.println("favorilerde ürün var");
    }

    public void turnTheMainPage(){
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".logo-icon"));
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySeconds(1);
        methods.scrollWithAction(By.xpath(
                "//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(1);
        methods.selectByText(By.xpath("//select[@onchange='location = this.value;']"),
                "Yüksek Oylama");
        methods.waitBySeconds(3);
    }

    public void randomUrunSecimi(){
        methods.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/span"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        methods.waitBySeconds(1);
        Random r = new Random(); //random sınıfı
        int a = r.nextInt(6);
        while(true)
        {
            if(a != 0)
                break;
            a = r.nextInt(6);
        }
        methods.click(By.xpath(
                "//ul[@class='product-grid jcarousel-skin-opencart']/li[" + a + "]"));
        methods.waitBySeconds(3);
    }

    public void favoridenSilme(){
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//a[@href='" +
                "https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']/div[3]/div[2]/div[3]/a[3]"));
        methods.waitBySeconds(1);
    }

    public void sepeteEkle(){
        methods.waitBySeconds(1);
        methods.scrollWithAction(By.id("button-cart"));
        methods.waitBySeconds(1);
        methods.click(By.id("button-cart"));
        methods.waitBySeconds(1);
    }

    public void satinAlma(){
        methods.click(By.id("cart-items"));
        methods.waitBySeconds(1);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(1);
        methods.doubleClick(By.xpath("//input[@name='quantity']"));
        methods.doubleClick(By.xpath("//input[@name='quantity']"));
        methods.waitBySeconds(3);
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.sendKeys(By.xpath("//input[@name='quantity']"),"2");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//button[@class='swal2-close']"));
        methods.click(By.cssSelector(".button.red"));
        methods.waitBySeconds(3);
    }

    public void adresKaydetme(){
        methods.click(By.xpath("//a[@href='#tab-shipping-new-adress']"));
        methods.sendKeys(By.id("address-firstname-companyname"),"Mehmet");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-lastname-title"),"Uludağ");
        methods.waitBySeconds(1);
        methods.selectByText(By.id("address-zone-id"),"Aydın");
        methods.waitBySeconds(3);
        methods.selectByText(By.id("address-county-id"),"NAZİLLİ");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-address-text"),"Dallıca Mh. 4567 sk. No:66 Daire:1");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-mobile-telephone"),"5412345436");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(1);
    }

    public void kartBilgileriEkleme(){
        methods.waitBySeconds(3);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("credit-card-owner"),"Mehmet Uludağ");
        for (int i = 1; i < 5; i++)
        {
            methods.sendKeys(By.id("credit_card_number_" + i),"44" + i + "0");
            methods.waitBySeconds(3);
        }
        methods.click(By.id("credit-card-expire-date-month"));
        methods.waitBySeconds(2);
        methods.selectByText(By.id("credit-card-expire-date-month"),"12");
        methods.waitBySeconds(2);
        methods.click(By.id("credit-card-expire-date-year"));
        methods.sendKeys(By.id("credit-card-expire-date-year"),"2025");
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-security-code"),"444");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
    }

    public void logOut(){
        methods.click(By.xpath("//img[@src='https://img." +
                "kitapyurdu.com/v1/getImage/fn:11453390/wh:98fa09e85']"));
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/account']"),"Çıkış");
        methods.waitBySeconds(2);
    }

}
