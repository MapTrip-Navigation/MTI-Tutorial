package de.infoware.mti.mti_tutorial.lessions;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContextWrapper;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Lession1_MapTrip extends Lession  {

    private static final String mapTripAppSystemName = "de.infoware.maptrip.navi.license";
    private static final String mapTripCompanionActivityClass = "de.infoware.maptrip.CompanionActivity";
    private Fragment fragment;

    public Lession1_MapTrip(int functionId, String buttonCaption) {
        super(functionId, buttonCaption);
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public void doSomething () {
        startMapTrip();
        setMapTripToFront();
    }

    private boolean startMapTrip() {
            Intent intent = fragment.getActivity().getPackageManager().getLaunchIntentForPackage(mapTripAppSystemName);
            if (null == intent) {
                return false;
            }

            try {
                fragment.getActivity().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException eToo) {
            } catch (Exception ex) {
            }
            return false;
        }

    private void setMapTripToFront() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(mapTripAppSystemName, mapTripCompanionActivityClass));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fragment.getActivity().startActivity(intent);
    }
}
