package de.infoware.mti.mti_tutorial.lessons;

import androidx.fragment.app.Fragment;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.mti.mti_tutorial.listener.MtiListener;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson extends MtiListener {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;
    private static MtiListener mtiListener = new MtiListener();

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
        this.fragment = fragment;
    }

    /*
     * Provides the MTI listener
     */
    protected mtiListener getMtiListener() {
        return this.mtiListener;
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
