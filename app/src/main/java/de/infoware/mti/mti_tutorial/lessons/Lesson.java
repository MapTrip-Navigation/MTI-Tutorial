package de.infoware.mti.mti_tutorial.lessons;

import androidx.fragment.app.Fragment;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
        this.fragment = fragment;
    }

    /**
     * Every lesson should execute some code which can be raised by calling this method
     */
    public abstract void doSomething();

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }
}