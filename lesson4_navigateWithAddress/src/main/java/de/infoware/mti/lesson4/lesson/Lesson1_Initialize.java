package de.infoware.mti.lesson4.lesson;

import android.content.ActivityNotFoundException;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.Navigation;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.android.mti.extension.MTIHelper;

public class Lesson1_Initialize extends Lesson {

    public Lesson1_Initialize(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
    }

    @Override
    public void doSomething() {
        registerListener();
        startMapTrip();
    }

    private void registerListener() {
        if (!listenerRegistered) {
            MTIHelper.initialize(fragment.getContext());
            Api.registerListener(getMtiListener());
            Navigation.registerListener(getMtiListener());
            listenerRegistered = true;
        }
    }

    private void unregisterListener() {
        if (listenerRegistered) {
            MTIHelper.uninitialize();
            listenerRegistered = false;
        }
    }

    private boolean startMapTrip() {
        Intent intent = fragment.getActivity().getPackageManager().getLaunchIntentForPackage(MAPTRIP_NAVI_LICENSE);
        if (null == intent) {
            return false;
        }

        try {
            fragment.getActivity().startActivity(intent);
        } catch (ActivityNotFoundException eToo) {
            //
        } catch (Exception ex) {
            //
        }
        return true;
    }

    private void initMTI() {
        if (! statusInitialized) {
            Api.init();
        }
    }

    private void uninitMTI() {
        Api.uninit();
        statusInitialized = false;
    }

    /*
     * When MTI finished Api.init() under the hood it raises the callback initResult()
     * The MtiListener calls all overwritten initResult methods
     */
    @Override
    public void initResult(int requestId, ApiError apiError) {
        switch (apiError) {
            case OK:
                statusInitialized = true;
                break;

            default:
                // something to do if an error occured
                statusInitialized = false;
                break;
        }
    }

    /*
     * When MapTrip app is started or restored to front MTI raises the callback infoMsg()
     * This callback is used as a trigger for initialization of MTI API
     */
    @Override
    public void infoMsg(Info info, int i) {
        switch (info) {
            case MAPTRIP_STARTED:
            case MAPTRIP_WAS_RESTORED:
                initMTI();
                break;

            case SERVER_IS_CLOSING:
                uninitMTI();
                unregisterListener();
                break;

            default:
                break;
        }
    }

}
