package de.infoware.mti.lesson3.lesson;

import androidx.fragment.app.Fragment;

import de.infoware.mti.lesson3.listener.MtiListener;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson extends MtiListener {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;

    protected static boolean statusInitialized = false;
    protected static boolean listenerRegistered = false;
    protected static boolean navigationActivated = false;

    protected static final String MAPTRIP_NAVI_LICENSE = "de.infoware.maptrip.navi.license";

    private static final MtiListener mtiListener = new MtiListener(); // one object for all derived lesson classes

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
        return this.MTI_LISTENER;
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
