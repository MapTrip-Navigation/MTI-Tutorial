package de.infoware.mti.lesson3.listener;

import java.util.HashMap;

import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.NavigationListener;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.android.mti.enums.Info;
import de.infoware.mti.lesson3.lesson.Lesson;

public class MtiListener implements ApiListener, NavigationListener {
    private static HashMap<Integer, Lesson> registeredLessons = new HashMap<>();

    public void registerLesson(Lesson lesson) {
        // make sure object is not yet registered
        if (!registeredLessons.containsKey(lesson.getFunctionId())) {
            registeredLessons.put(lesson.getFunctionId(), lesson);
        }
    }

    @Override
    public void stopNavigationResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.stopNavigationResult(requestId, apiError);
        }
    }

    @Override
    public void removeAllDestinationCoordinatesResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.removeAllDestinationCoordinatesResult(requestId, apiError);
        }
    }

    @Override
    public void appendDestinationCoordinateResult(int requestId, int listIndex, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.appendDestinationCoordinateResult(requestId, listIndex, apiError);
        }
    }

    @Override
    public void startNavigationResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.startNavigationResult(requestId, apiError);
        }
    }

    @Override
    public void startSimulationResult(int requestId, ApiError apiError) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.startSimulationResult(requestId, apiError);
        }
    }

    @Override
    public void destinationReached(int requestId) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.destinationReached(requestId);
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
    public void statusInfo(double v, double v1, double v2, double v3) {
        // prevent recursive calls if subclass didn't implement this method
        if (!this.getClass().equals(MtiListener.class)) {
            return;
        }

        for (Lesson lesson : registeredLessons.values()) {
            lesson.statusInfo(v, v1, v2, v3);
        }
    }

    @Override
    public void coiInfo(double v, double v1, String s, String s1, double v2) {

    }

    @Override
    public void crossingInfo(double v, double v1, String s, String s1, String s2, double v2) {

    }

    @Override
    public void insertDestinationCoordinateResult(int i, ApiError apiError) {

    }

    @Override
    public void insertDestinationAddressResult(int i, ApiError apiError) {

    }

    @Override
    public void appendDestinationAddressResult(int i, int i1, ApiError apiError) {

    }

    @Override
    public void insertGeocodedDestinationResult(int i, ApiError apiError) {

    }

    @Override
    public void appendGeocodedDestinationResult(int i, int i1, ApiError apiError) {

    }

    @Override
    public void markDestinationCoordinateAsViaPointResult(int i, ApiError apiError) {

    }

    @Override
    public void getDestinationCoordinateResult(int i, ApiError apiError, double v, double v1) {

    }

    @Override
    public void getDestinationCoordinateCountResult(int i, ApiError apiError, int i1) {

    }

    @Override
    public void getCurrentDestinationResult(int i, ApiError apiError, int i1) {

    }

    @Override
    public void startAlternativeNavigationResult(int i, ApiError apiError) {

    }


    @Override
    public void startRouteFromFileResult(int i, ApiError apiError) {

    }

    @Override
    public void startReferenceRouteResult(int i, ApiError apiError) {

    }

    @Override
    public void getReferenceRouteFileResult(int i, String s, ApiError apiError) {

    }

    @Override
    public void syncWithActiveNavigationResult(int i, ApiError apiError) {

    }

    @Override
    public void navigateWithGuiGeocodingResult(int i, ApiError apiError) {

    }

    @Override
    public void routingStarted() {

    }

    @Override
    public void routeCalculated() {

    }

    @Override
    public void setRoutingModeHybridResult(int i, ApiError apiError) {

    }

    @Override
    public void newRouteAvailable() {

    }

    @Override
    public void setEmergencyRoutingEnabledResult(int i, ApiError apiError) {

    }

    @Override
    public void getEmergencyRoutingEnabledResult(int i, ApiError apiError, boolean b, boolean b1, int i1) {

    }

    @Override
    public void setEmergencyRouteRadiusResult(int i, ApiError apiError) {

    }

    @Override
    public void getEmergencyRouteRadiusResult(int i, ApiError apiError, int i1) {

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
