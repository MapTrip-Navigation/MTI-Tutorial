package de.infoware.mti.mti_tutorial.lessions;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Lession2_ShowApps extends Lession {
    public static final String mapTripAppSystemName = "de.infoware.maptrip.navi.license";
    public static final String mapTripCompanionActivityClass = "de.infoware.maptrip.CompanionActivity";
    private TextView statusText;


    public Lession2_ShowApps(int functionId, String buttonCaption, Fragment fragment, TextView statusText) {
        super(functionId, buttonCaption, fragment, statusText);
        this.statusText = statusText;
    }


    public void doSomething() {
        if (!statusInitialized) {
            return;
        }
        setMapTripToFront();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTutorialAppToFront();
    }

    private void setTutorialAppToFront() {
        String className = fragment.getActivity().getClass().getCanonicalName();
        String packageName = fragment.getActivity().getPackageName();

        // MTI call
        Api.showApp(packageName, className);
    }


    /*
     * show MapTrip
     */
    private void setMapTripToFront() {
//        Api.findServer();

        Intent intent = new Intent();
        intent.setComponent(new ComponentName(mapTripAppSystemName, mapTripCompanionActivityClass));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fragment.getActivity().startActivity(intent);
    }

}
