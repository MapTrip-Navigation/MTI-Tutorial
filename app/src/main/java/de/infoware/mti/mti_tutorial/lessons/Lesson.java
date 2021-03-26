package de.infoware.mti.mti_tutorial.lessons;

import android.content.Context;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;

    private LessonListener lessonListener = new LessonListener();

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
        this.fragment = fragment;
    }

    protected void registerLesson(Lesson lesson) {
        lessonListener.registerLesson(lesson);
    }

    protected LessonListener getLessonListener () {
        return this.lessonListener;
    }

    public abstract void doSomething();

    /**
     * Can be overwritten by children optionally
     * @param info Enum with predefined Status informations of MTI
     * @param i
     */
    public void apiInfoMsg (Info info, int i) {
    }

    /**
     * Can be written by children optionally
     * @param requestId Id was delivered before by calling an MTI function
     * @param apiError Enum with predefined error status of MTI
     */
    public void apiInitResult (int requestId, ApiError apiError) {
    }

    public void apiOnError(int requestId, String infoText, ApiError apiError) {
    }

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }

}