package de.infoware.mti.mti_tutorial.lessons;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.enums.Info;
import de.infoware.android.mti.extension.MTIHelper;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Lesson1_Initialize extends Lesson {

    private static final String mapTripAppSystemName = "de.infoware.maptrip.navi.license";

    public Lesson1_Initialize(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
   }

   @Override
    public void doSomething() {
        startMapTrip();
		registerListener();
        initMTI();
    }

    protected void bla() {

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
	
	private void registerListener() {
		Api.registerListener(this);
	}

    private void initMTI() {
        if (statusInitialized) {
            Api.uninit();
            MTIHelper.uninitialize();
        }
        MTIHelper.initialize(fragment.getContext());

        final int requestId = Api.init();
    }

}
