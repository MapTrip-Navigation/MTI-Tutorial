package de.infoware.mti.mti_tutorial.listener;

import java.util.ArrayList;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.mti.mti_tutorial.lessons.Lesson;

public class mtiListener implements ApiListener  {
    private ArrayList<Lesson> registeredLessons = new ArrayList<>();

    public void registerLesson(Lesson lesson) {
        registeredLessons.add(lesson);
    }

    @Override
    public void infoMsg(Info info, int i) {
        for (Lesson lesson : registeredLessons) {
            lesson.apiInfoMsg(info, i);
        }
    }

    @Override
    public void initResult(int requestId, ApiError apiError) {
        for (Lesson lesson : registeredLessons) {
            lesson.apiInitResult(requestId, apiError);
        }
    }

    @Override
    public void onError(int requestId, String infoText, ApiError apiError) {
        for (Lesson lesson : registeredLessons) {
            lesson.apiOnError(requestId, infoText, apiError);
        }
    }

    @Override
    public void findServerResult(int i, ApiError apiError) {

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
