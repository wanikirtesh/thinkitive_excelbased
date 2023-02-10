package com.thinkitive.excelbased.helper;

import com.thinkitive.excelbased.entity.Step;
import org.openqa.selenium.By;

public enum Actions {
    NAVIGATE{
        public boolean perform(Step step){
            DriverManger.getDriver().get(step.getData());
            return true;
        }
    },TYPE{
        public boolean perform(Step step){
            DriverManger.getDriver().findElement(By.xpath(step.getSelector())).sendKeys(step.getData());
            return true;
        }
    },CLICK{
        public boolean perform(Step step){
            DriverManger.getDriver().findElement(By.xpath(step.getSelector())).click();
            return true;
        }
    },CHKELEMENTISPRESENT{
        public boolean perform(Step step){
            return DriverManger.getDriver().findElements(By.xpath(step.getSelector())).size()==Integer.parseInt(step.getData());
        }
    };

    public abstract boolean perform(Step step);
}
