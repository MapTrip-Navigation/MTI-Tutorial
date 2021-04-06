package de.infoware.mti.lesson3.lesson;

import androidx.fragment.app.Fragment;

import de.infoware.android.mti.Api;
import de.infoware.android.mti.ApiListener;
import de.infoware.android.mti.Navigation;
import de.infoware.android.mti.enums.ApiError;
import de.infoware.mti.lesson3.listener.MtiListener;

public class Lesson3_RouteByCoordinates extends Lesson {
    private int stopNavigationRequestId;
    private int removeAllDestinationCoordinatesRequestId;
    private int appendCoordinateRequestId;
    private int startNavigationRequestId;
    private int startSimulationRequestId;

    public Lesson3_RouteByCoordinates(int functionId, String buttonCaption, Fragment fragment) {
        super(functionId, buttonCaption, fragment);
        registerLesson(this);
    }

    @Override
    public void doSomething() {
        // At first check if MTI is ready to use
        if (!statusInitialized) {
            return;
        }

        beginNewNavigation();
    }

    private void setTutorialAppToFront() {
        String className = fragment.getActivity().getClass().getCanonicalName();
        String packageName = fragment.getActivity().getPackageName();

        // MTI call
        Api.showApp(packageName, className);
    }

    // 1. initial step: be sure that no routing is active
    private void beginNewNavigation() {
        stopNavigationRequestId = Navigation.stopNavigation();
    }

    // 2. clear (possible) destinations from destination list
    private void removeAllDestinationCoordinates() {
        removeAllDestinationCoordinatesRequestId = Navigation.removeAllDestinationCoordinates();
    }

    // 3. no active route and destination list is empty - set destination to list
    private void appendCoordinates() {
        // if GPS doesn't work we will start a simulation
        // for simulation two coordinates are required

        // first coordinate near the dome
        Navigation.appendDestinationCoordinate(50.942666455132745, 6.957345467113134);
        // second coordinate in some hundred meters distance
        appendCoordinateRequestId = Navigation.appendDestinationCoordinate(50.94158521260109, 6.953404794243524);
    }

    // 4. destination list updated - start routing
    private void startNavigation() {
        startNavigationRequestId = Navigation.startNavigation();
    }

    // 5. navigation could not be started - perhaps no GPS, so we try simulation
    private void startSimulation() {
        startSimulationRequestId = Navigation.startSimulation();
    }

    // 6. Navigation  or Simulation started - bring MapTrip to front
    private void showMapTrip() {
        Api.showServer();
    }

    // 1a. possible routing stopped
    @Override
    public void stopNavigationResult(int requestId, ApiError apiError) {
        // relates the returned requestId our stopNavigationId?
        if (stopNavigationRequestId != requestId) {
            return;
        }

        // check error
        if (apiError.equals(ApiError.OK) || apiError.equals(ApiError.NO_ROUTE) || apiError.equals(ApiError.NO_DESTINATION)) {
            removeAllDestinationCoordinates();
        }
    }

    // 2a. destination list cleared - append
    @Override
    public void removeAllDestinationCoordinatesResult(int requestId, ApiError apiError) {
        // relates the returned requestId our removeAllDestinationCoordinatesRequestId?
        if (removeAllDestinationCoordinatesRequestId != requestId) {
            return;
        }

        // check error
        if (apiError.equals(ApiError.OK) || apiError.equals(ApiError.NO_ROUTE)) {
            appendCoordinates();
        }
    }

    // 3a. new coordinate was added to destination list
    @Override
    public void appendDestinationCoordinateResult(int requestId, int listIndex, ApiError apiError) {
        if (appendCoordinateRequestId != requestId) {
            return;
        }

        // while adding coordinates we set the requestId with the last call of appendDestinationCoordinates()
        // so all appends before are ignored here and only with the last callback navigation will be started

        // check error
        if (apiError.equals(ApiError.OK) || apiError.equals(ApiError.NO_ROUTE)) {
            startNavigation();
        }
    }

    // 4a. navigation successfull started - show MapTrip
    @Override
    public void startNavigationResult(int requestId, ApiError apiError) {
        if (requestId != startNavigationRequestId) {
            return;
        }

        switch (apiError) {
            case OK:
                // bring MapTrip to front
                Api.showServer();
                navigationActivated = true;
                break;

            case ROUTING:
                // perhaps the routing couldn't be started because of missed GPS signal
                // in production apps the check must be more detailed
                // in this tutorial we simply try to start a simulation
                startSimulation();
                break;

            default:
                break;
        }
    }

    // 5a. simulation successfully started - show MapTrip
    @Override
    public void startSimulationResult(int requestId, ApiError apiError) {
        if (requestId != startSimulationRequestId) {
            return;
        }

        switch (apiError) {
            case OK:
                // bring MapTrip to front
                Api.showServer();
                navigationActivated = true;
                break;

            default:
                // some error handling here
                break;
        }
    }

    // 6a. error handling if MapTrip couldn't be set to front
    @Override
    public void showServerResult(int requestId, ApiError apiError) {
        // some error handling here if server couldn't be shown
        navigationActivated = true;
    }

    // when destination reached bring tutorial app to front
    @Override
    public void destinationReached(int requestId) {
        setTutorialAppToFront();
    }
}
