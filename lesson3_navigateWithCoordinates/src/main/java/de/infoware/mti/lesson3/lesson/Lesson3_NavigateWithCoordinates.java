package de.infoware.mti.lesson3.lesson;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.Navigation;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.mti.lesson3.listener.MtiListener;

public class Lesson3_NavigateWithCoordinates extends Lesson {
    private int stopNavigationRequestId;
    private int removeAllDestinationCoordinatesRequestId;
    private int appendCoordinateRequestId;
    private int startNavigationRequestId;
    private int startSimulationRequestId;

    public Lesson3_NavigateWithCoordinates(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
    }

    @Override
    public void doSomething() {

    }
}
