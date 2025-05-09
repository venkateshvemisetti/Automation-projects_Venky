package com.geidea.objects;

import org.openqa.selenium.By;

public class ApplicationProcessingObject {
     public static By searchbox=By.xpath("//div[@class='gridFilter']//input[@type='text']");
     public static By emailName=By.xpath("//tr/td[@role='gridcell'][4]");
     public static By editIcon=By.xpath("//td/a[@name='Edit']");
     public static By productaddBTN=By.xpath("//div/button[@isexist='add']");
     public static By saveConBTN=By.xpath("//div[@myid='screen01_MasterLayout_save_450293330_0']/button[contains(text(),'Save & Continue')]");
     
   
}
