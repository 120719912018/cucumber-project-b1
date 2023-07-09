package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DocuportEachUserValidation {



  public   DocuportEachUserValidation(){
      PageFactory.initElements(Driver.getDriver(),this);
  }


}
