package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class VideosScreenBase extends AbstractPage {
    public VideosScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isVideosScreenOpened();
}
