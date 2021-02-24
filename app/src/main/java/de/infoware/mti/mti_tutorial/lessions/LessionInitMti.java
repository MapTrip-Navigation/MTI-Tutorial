package de.infoware.mti.mti_tutorial.lessions;


import java.util.HashMap;
import java.util.HashSet;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;

public class LessionInitMti extends Lession implements ApiListener {
    private HashSet<Integer> callSet;

    public LessionInitMti(int functionId, String buttonCaption) {
        super(functionId, buttonCaption);
    }

    public void doSomething() {

    }

    /*
     * The following methods are implementations of the ApiListener interface
     */

    @Override
    public void onError(int i, String s, ApiError apiError) {
        callSet.remove(i);
    }

    @Override
    public void findServerResult(int i, ApiError apiError) {

    }

    @Override
    public void initResult(int i, ApiError apiError) {

    }

    @Override
    public void showAppResult(int i, ApiError apiError) {

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
    public void showServerResult(int i, ApiError apiError) {

    }

    @Override
    public void hideServerResult(int i, ApiError apiError) {

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
