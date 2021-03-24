package de.infoware.mti.mti_tutorial.lessions;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;

/**
 * This abstract class is the template for all lessions
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public abstract class Lession implements ApiListener {
    private int functionId;
    private String buttonCaption;
    protected TextView statusText;
    protected Fragment fragment;

    protected static ApiError lastApiError = ApiError.OK;
    protected static String lastExtendedErrorText = "";
    protected static boolean statusInitialized = false;
    protected static boolean statusShowApp = false;
    protected volatile static Boolean statusFindServer = false;
    protected static boolean statusShowServer = false;
    protected static boolean statusHideServer = false;

    protected final Object lock = new Object();

    public Lession(int functionId, String buttonCaption) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
    }

    public Lession(int functionId, String buttonCaption, Fragment fragment, TextView statusText) {
        this.fragment = fragment;
        this.statusText = statusText;
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


    /*
     * if the app has to wait for a callback this method can be used to start a thread for waiting
     */

    /*
     * from here all methods are MTI callbacks
     */
    @Override
    public void showAppResult(int requestId, ApiError apiError) {
        lastApiError = apiError;
        if (apiError.equals(ApiError.OK)) {
            statusShowApp = true;
        }
    }

    @Override
    public void initResult(int requestId, ApiError apiError) {
        lastApiError = apiError;
        if (apiError.equals(ApiError.OK)) {
            statusInitialized = true;
        }
    }

    @Override
    public void onError(int requestId, String extendedErrorText, ApiError apiError) {
        lastApiError = apiError;
        lastExtendedErrorText = extendedErrorText;
    }

    @Override
    public void findServerResult(int requestId, ApiError apiError) {
        lastApiError = apiError;
        if (apiError.equals(ApiError.OK)) {
            statusFindServer = true;
        }
    }

    @Override
    public void sendTextResult(int i, ApiError apiError) {

    }

    @Override
    public void getMapVersionResult(int i, String s, ApiError apiError) {

    }

    @Override
    public void getMaptripVersionResult(int i, String s, ApiError apiError) {

    }

    @Override
    public void getApiVersionResult(int i, String s, ApiError apiError) {

    }

    @Override
    public void showServerResult(int requestId, ApiError apiError) {
        lastApiError = apiError;
        if (lastApiError.equals(ApiError.OK)) {
            statusShowServer = true;
        }
    }

    @Override
    public void hideServerResult(int requestId, ApiError apiError) {
        lastApiError = apiError;
        if (lastApiError.equals(ApiError.OK)) {
            statusHideServer = true;
        }
    }

    @Override
    public void stopServerResult(int i, ApiError apiError) {

    }

    @Override
    public void enableNetworkConnectionsResult(int i, ApiError apiError) {

    }

    @Override
    public void setDataUsageMonthlyLimitResult(int i, ApiError apiError) {

    }

    @Override
    public void resetDataUsageMonthlyLimitResult(int i, ApiError apiError) {

    }

    @Override
    public void getDataUsageMonthlyLimitResult(int i, int i1, ApiError apiError) {

    }

    @Override
    public void getDataUsageRemainingQuotaResult(int i, int i1, ApiError apiError) {

    }

    @Override
    public void isNetworkConnectionEnabledResult(int i, boolean b, ApiError apiError) {

    }

    @Override
    public void customFunctionResult(int i, String s, String s1, ApiError apiError) {

    }

    @Override
    public void infoMsg(Info info, int i) {

    }


}