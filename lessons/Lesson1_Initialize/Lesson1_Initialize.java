package de.infoware.mti.mti_tutorial.lessons;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.android.mti.extension.MTIHelper;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Lesson1_Initialize extends Lesson {
    private boolean statusInitialized = false;

    public Lesson1_Initialize(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
   }

   @Override
    public void doSomething() {
        // register listener to enable the app reacting to MTI callbacks
		registerListener();

		// At first the app MapTrip must be started to use navigation functions
        // MTI will call a callback later - see methods below
        startMapTrip();
    }

    /*
     * Start the app MapTrip
     */
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

    /*
     * This class wants to be notified when a callback is called by MTI
     */
	private void registerListener() {
        MTIHelper.initialize(fragment.getContext());
        Api.registerListener(getMtiListener());
	}

	/*
	 * When MapTrip app is started or restored to front MTI raises the callback infoMsg()
	 * This callback is uses as a trigger for initialization of MTI API
	 */
    public void apiInfoMsg(Info info, int i) {
        switch (info) {
            case MAPTRIP_STARTED:
            case MAPTRIP_WAS_RESTORED:
                initMTI();
                break;

            default:
                break;
        }
    }

    /*
     * Uses MTI function Api.init()
     */
    private void initMTI() {
        if (statusInitialized) {
            Api.uninit();
            MTIHelper.uninitialize();
        }

        final int requestId = Api.init();
    }

    /*
     * When MTI call Api.init() finished it raises the callback initResult()
     * The callback initResult() is used as trigger to set the status about init
     */
    public void apiInitResult(int requestId, ApiError apiError) {
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
}
