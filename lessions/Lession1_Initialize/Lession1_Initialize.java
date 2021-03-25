package de.infoware.mti.mti_tutorial.lessions;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.extension.MTIHelper;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Lession1_Initialize extends Lession {

    private static final String mapTripAppSystemName = "de.infoware.maptrip.navi.license";

    public Lession1_Initialize(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
   }

   @Override
    public void doSomething() {
        startMapTrip();
        initMTI();
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

        MTIHelper.initialize(fragment.getContext());
        Api.registerListener(this);

        final int requestId = Api.init();
    }

}
