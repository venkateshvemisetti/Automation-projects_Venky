package com.geidea.objects;

import org.openqa.selenium.By;

public class ApplicationProcessingObject {
     public static By searchbox=By.xpath("//div[@class='gridFilter']//input[@type='text']");
     public static By emailName=By.xpath("//tr/td[@role='gridcell'][4]");
     public static By editIcon=By.xpath("//td/a[@name='Edit']");
     public static By productaddBTN=By.xpath("//div/button[@isexist='add']");
     public static By saveConBTN=By.xpath("//div[@myid='screen01_MasterLayout_save_450293330_0']/button[contains(text(),'Save & Continue')]");
     public static By governmentEntityLabel=By.xpath("//div[@myid='screen33_MasterLayout_RadioButton_883432_1']/li/label");
     public static By governmentEntityBTS=By.xpath("//div[@myid='screen33_MasterLayout_RadioButton_883432_1']/li/label/input");
     public static By multinationalBusinessLabel=By.xpath("//div[@myid='screen33_MasterLayout_RadioButton_1183432_1']/li/label");
     public static By multinationalBusinessBTS=By.xpath("//div[@myid='screen33_MasterLayout_RadioButton_1183432_1']/li/label/input");
     public static String incorporationlocation="//div[@myid='screen33_MasterLayout_dropDownWithSearch_1283432_2']";
     public static String legalentitytype="//div[@myid='screen33_MasterLayout_dropDownWithSearch_2183432_2']";
     public static String searchboxDD="//div[@class='dropdown show']//div//input[@type=' text']";
     public static By browsefileorTake=By.xpath("//div[@myid='screen33_MasterLayout_719']/div//button[@type='button']");
     public static By browsefile=By.xpath("//div[@myid='screen33_MasterLayout_719']//button/following::input[1]");
     
}

//div[@myid='screen33_MasterLayout_719']//button