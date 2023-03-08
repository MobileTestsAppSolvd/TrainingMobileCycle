package com.TrainingCycleSolvdArg.carina.demo.mobile.gui.listener;

import com.TrainingCycleSolvdArg.carina.demo.mobile.gui.recorder.RecordingPage;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class RecordingListener extends RecordingPage implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        startRecordingScreen();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String video = stopRecordingScreen();
        byte[] decodedVideo = DecodeVideo(video);
        CreateVideoInDirectory(decodedVideo);
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String video = stopRecordingScreen();
        byte[] decodedVideo = DecodeVideo(video);
        CreateVideoInDirectory(decodedVideo);
    }
}
