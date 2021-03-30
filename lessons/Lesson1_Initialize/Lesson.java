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
    
    private static MtiListener mtiListener = new MtiListener(); // one object for all derived lesson classes

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
        this.fragment = fragment;
    }

    /*
     * Provides the MTI listener
     * The MTI listener is needed for registering the Callback class at MTI
     * Should be called by only one Lesson class and one time
     */
    protected MtiListener getMtiListener() {
        return this.mtiListener;
    }

    /**
     * Every lesson executes some code which is raised by calling this method
     */
    public abstract void doSomething();

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }
}
