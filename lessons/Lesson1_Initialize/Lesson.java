package de.infoware.mti.mti_tutorial.lessons;

import androidx.fragment.app.Fragment;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.mti.mti_tutorial.listener.mtiListener;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;
    private mtiListener mtiListener = new mtiListener();

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
        this.fragment = fragment;
    }

    /*
     * To be notified when callbacks are called lessons can register themselve
     */
    protected void registerLesson(Lesson lesson) {
        mtiListener.registerLesson(lesson);
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

    /**
     * Can be overwritten by children optionally
     * @param info Enum with predefined Status informations of MTI
     * @param i
     */
    public void apiInfoMsg (Info info, int i) {
    }

    /**
     * Can be overwritten by children optionally
     * @param requestId Id was delivered before by calling an MTI function
     * @param apiError Enum with predefined error status of MTI
     */
    public void apiInitResult (int requestId, ApiError apiError) {
    }

    /**
     * Can be overwritten by children optionally
     * @param requestId Id was delivered before by calling an MTI function
     * @param infoText Additional text about error
     * @param apiError Enum with predefined error status of MTI
     */
    public void apiOnError(int requestId, String infoText, ApiError apiError) {
    }

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }
}