package de.infoware.mti.lesson3.lesson;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.enums.ApiError;

public class Lesson2_ShowApps extends Lesson {

    public Lesson2_ShowApps(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
    }

    @Override
    public void doSomething() {
        // At first check if MTI is ready to use
        if (!statusInitialized) {
            return;
        }

        // to differ between the behaviour between the second and the third button
        navigationActivated = false;
        setMapTripToFront();
    }

    /*
     * show MapTrip
     */
    public void setMapTripToFront() {
        Api.showServer();
    }

    private void setTutorialAppToFront() {
        String className = fragment.getActivity().getClass().getCanonicalName();
        String packageName = fragment.getActivity().getPackageName();

        // MTI call
        Api.showApp(packageName, className);
    }

    @Override
    public void showServerResult(int requestId, ApiError apiError) {
        // in lesson 3 a navigation will be started and MapTrip has to stay at front
        // so we leave this function without doing anything
        if (navigationActivated) {
            return;
        }

        // MapTrip is set to front and MTI raises the callback
        // From now we wait 10 seconds and switch back to our own app
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Time expired switch back
        setTutorialAppToFront();
    }

    @Override
    public void showAppResult(int requestId, ApiError apiError) {
        // here you could react to incoming callback that this app was brought to front
    }
}
