package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.android;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.common.VideosScreenBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = VideosScreenBase.class)
public class VideosScreen extends VideosScreenBase {
    @ExtendedFindBy(text = "mute icon")
    private ExtendedWebElement muteIcon;

    public VideosScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isVideosScreenOpened() {
        return muteIcon.isElementPresent();
    }
}
