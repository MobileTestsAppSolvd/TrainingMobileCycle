package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.recorder;

import com.qaprosoft.carina.core.gui.AbstractPage;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStopScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Response;

import java.util.Map;

public class RecordingPage extends AbstractPage implements CanRecordScreen{

    public RecordingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public <T extends BaseStartScreenRecordingOptions> String startRecordingScreen(T options) {
        return CanRecordScreen.super.startRecordingScreen(options);
    }

    @Override
    public String startRecordingScreen() {
       return  ((CanRecordScreen)driver).startRecordingScreen();
    }

    @Override
    public <T extends BaseStopScreenRecordingOptions> String stopRecordingScreen(T options) {
        return CanRecordScreen.super.stopRecordingScreen(options);
    }

    @Override
    public String stopRecordingScreen() {
        return  ((CanRecordScreen)driver).stopRecordingScreen();
    }

    @Override
    public Response execute(String driverCommand, Map<String, ?> parameters) {
        return null;
    }

    @Override
    public Response execute(String driverCommand) {
        return null;
    }
}
