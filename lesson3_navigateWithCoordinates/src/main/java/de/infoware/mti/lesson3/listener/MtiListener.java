package de.infoware.mti.lesson3.listener;

import java.util.HashMap;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.mti.lesson3.lesson.Lesson;

public class MtiListener implements ApiListener {
    private static HashMap<Integer, Lesson> registeredLessons = new HashMap<>();

    public void registerLesson(Lesson lesson) {
        // make sure object is not yet registered
        if (!registeredLessons.containsKey(lesson.getFunctionId())) {
            registeredLessons.put(lesson.getFunctionId(), lesson);
        }
    }

    @Override
    public void infoMsg(Info info, int i) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.infoMsg(info, i);
        }
    }

    @Override
    public void initResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.initResult(requestId, apiError);
        }
    }

    @Override
    public void showServerResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.showServerResult(requestId, apiError);
        }
    }

    @Override
    public void showAppResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.showAppResult(requestId, apiError);
        }
    }

    @Override
    public void onError(int i, String s, ApiError apiError) {

    }

    @Override
    public void findServerResult(int i, ApiError apiError) {

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
