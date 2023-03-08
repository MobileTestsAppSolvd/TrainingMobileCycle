package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.recorder;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStopScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Response;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

public class RecordingPage  implements CanRecordScreen, IAbstractTest{

    @Override
    public WebDriver getDriver() {
        return IAbstractTest.super.getDriver();
    }

    @Override
    public <T extends BaseStartScreenRecordingOptions> String startRecordingScreen(T options) {
        return CanRecordScreen.super.startRecordingScreen(options);
    }

    @Override
    public String startRecordingScreen() {
        return ((CanRecordScreen) getDriver()).startRecordingScreen();
    }

    @Override
    public <T extends BaseStopScreenRecordingOptions> String stopRecordingScreen(T options) {
        return CanRecordScreen.super.stopRecordingScreen(options);
    }

    @Override
    public String stopRecordingScreen() {
        return ((CanRecordScreen) getDriver()).stopRecordingScreen();
    }

    @Override
    public Response execute(String driverCommand, Map<String, ?> parameters) {
        return null;
    }

    @Override
    public Response execute(String driverCommand) {
        return null;
    }

    public byte[] DecodeVideo(String video) {
        return Base64.getMimeDecoder().decode(video);
    }

    public void CreateVideoInDirectory(byte[] alreadyDecodedVideo) {
        try {
            Path testVideoDir = Paths.get(System.getProperty("user.dir") + "/videos");
            Files.createDirectories(testVideoDir);
            Path testVideoFileLocation = Paths.get(testVideoDir.toString()
                    , String.format("%s-%d.%s", "test"
                            , System.currentTimeMillis(), "mp4"));
            Files.write(testVideoFileLocation, alreadyDecodedVideo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
