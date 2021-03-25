package de.infoware.mti.mti_tutorial.lessions;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.HashMap;


/**
 * This abstract class is the template for all lessions
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public abstract class Lession {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;

    public Lession(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
    }

    public abstract void doSomething();

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }

}