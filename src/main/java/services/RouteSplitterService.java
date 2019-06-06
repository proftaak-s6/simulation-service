package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;

import models.TrackerServiceModel;
import models.google.Location;
import models.google.Step;

@Dependent
public class RouteSplitterService {
    public RouteSplitterService() {
    }

    public List<TrackerServiceModel> SplitStepsIntoLocations(List<Step> steps, int updateInterval) {
        log("START SPLITTING STEPS");

        List<TrackerServiceModel> coordinates = new ArrayList<TrackerServiceModel>();
        int amountOfSteps = steps.size();

        for (int index = 0; index < amountOfSteps; index++) {
            log("");
            log("Starting new step");
            Step step = steps.get(index);
            log("Step to process: " + step.toString());

            // The remainder is the distance left from the last update
            // Example: with a speed of 7 the first interval will be at 5 but this will
            // remain a distance of 2. We need to deduct 2 from the distance in the next
            // step and start at 3. In our example the remainder is 2

            // NOTE That this is not yet used, but should be to pick up the straggling
            // distances at the end of every step
            int remainderDistance = 0;

            log("Speed: " + step.getSpeed());
            int distanceToMove = step.getSpeed() * updateInterval;
            log("Distance to move per interval calculated at [" + distanceToMove + "], based on speed ["
                    + step.getSpeed() + "] and update interval [" + updateInterval + "]");

            while (step.getDistance().getValue() > 0) {
                log("... Entering WHILE");
                if (distanceToMove <= step.getDistance().getValue()) {
                    log("... Entering IF");
                    log("The update fits inside the step entirely. Distance left [" + step.getDistance().getValue()
                            + "] and distance to move [" + distanceToMove + "]");

                    // Get the new location and add it to our list
                    Location locationAfterInterval = getLocationAfterInterval(step, updateInterval);
                    TrackerServiceModel trackerServiceModel = new TrackerServiceModel(locationAfterInterval.getLat(),
                            locationAfterInterval.getLng(), getNextDateTick(updateInterval));
                    coordinates.add(trackerServiceModel);

                    // Prepare for the next step
                    // Set the start distance to where we are after the movement
                    int startDistance = step.getDistance().getValue();
                    step.setStart_location(locationAfterInterval);
                    // Calculate the new distance we need to move
                    int newDistance = startDistance - distanceToMove;
                    log("New distance for this step calculated at [" + newDistance + "] based on startdistance ["
                            + step.getDistance().getValue() + "] and distance to move [" + distanceToMove + "]");
                    // Apply the new distance so that our car progresses
                    step.getDistance().setValue(newDistance);
                } else {
                    log("... Entering ELSE");
                    log("The update does not fit inside the step entirely. Distance left ["
                            + step.getDistance().getValue() + "] and distance to move [" + distanceToMove + "]");
                    log("Setting the distance of this step to 0, setting the remainder distance to the leftover ["
                            + step.getDistance().getValue() + "]. Keep in mind that the remainder distance is not yet implemented.");
                    remainderDistance = step.getDistance().getValue();
                    step.getDistance().setValue(0);
                }
            }

            log("Processed step number [" + index + "], moving on to the next one.");

            log("");
        }

        log("Process complete. Returning [" + coordinates.size() + "] coordinates.");
        for (TrackerServiceModel coordinate : coordinates) {
            log("Coordinate: " + coordinate.toString());
        }

        return coordinates;
    }

    private Location getLocationAfterInterval(Step step, int updateInterval) {
        boolean logMe = false;

        if (logMe) {
            log("");
            log("Finding the next location of our vehicle");
        }

        if (logMe)
            log("Original Lat: {" + step.getStart_location().getLat() + "} and Lng: {"
                    + step.getStart_location().getLng() + "}.");

        double differenceInLat = step.getEnd_location().getLat() - step.getStart_location().getLat();
        double differenceInLng = step.getEnd_location().getLng() - step.getStart_location().getLng();

        if (logMe)
            log("Difference in Lat: {" + differenceInLat + "} and difference in Lng: {" + differenceInLng + "}.");

        differenceInLat = differenceInLat / (double) step.getDuration().getValue() * (double) updateInterval;
        differenceInLng = differenceInLng / (double) step.getDuration().getValue() * (double) updateInterval;

        if (logMe)
            log("Difference from start Lat: {" + differenceInLat + "} and difference from start Lng: {"
                    + differenceInLng + "}.");

        double newLat = step.getStart_location().getLat() + differenceInLat;
        double newLng = step.getStart_location().getLng() + differenceInLng;

        if (logMe)
            log("New Lat: {" + newLat + "} and Lng: {" + newLng + "}.");

        return new Location(newLat, newLng);
    }

    Calendar calendar = Calendar.getInstance();

    private Date getNextDateTick(int secondInterval) {
        calendar.add(Calendar.SECOND, 5);
        return calendar.getTime();
    }

    private static int counter = 0;

    private static void log(String message) {
        System.out.println("[" + counter++ + "] => " + message);
    }

}