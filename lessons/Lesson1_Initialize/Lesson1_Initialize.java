package de.infoware.mti.mti_tutorial.lessons;

import android.content.ActivityNotFoundException;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.android.mti.extension.MTIHelper;

public class Lesson1_Initialize extends Lesson {
    private boolean statusInitialized = false;

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
        MTIHelper.initialize(fragment.getContext());
        Api.registerListener(getMtiListener());
    }

    private boolean startMapTrip() {
        Intent intent = fragment.getActivity().getPackageManager().getLaunchIntentForPackage("de.infoware.maptrip.navi.license");
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
        if (statusInitialized) {
            Api.uninit();
            MTIHelper.uninitialize();
        }

        Api.init();
    }

    /*
     * When MTI call Api.init() finished it raises the callback initResult()
     * The callback initResult() is used as trigger to set the status about init
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

            default:
                break;
        }
    }

}
