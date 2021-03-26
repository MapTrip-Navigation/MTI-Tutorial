package de.infoware.mti.mti_tutorial.lessons;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;

/**
 * This abstract class is the template for all lessons
 */
public abstract class Lesson implements ApiListener {
    private int functionId;
    private String buttonCaption;
    protected Fragment fragment;

    public Lesson(int functionId, String buttonCaption, Fragment fragment) {
        this.functionId = functionId;
        this.buttonCaption = buttonCaption;
    }

    public abstract void doSomething();

    protected abstract void bla();

    public String getButtonCaption() {
        return buttonCaption;
    }

    public int getFunctionId() {
        return functionId;
    }

    @Override
    public void infoMsg(Info info, int i) {
        bla();
    }

    @Override
    public void onError(int i, String s, ApiError apiError) {

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


}