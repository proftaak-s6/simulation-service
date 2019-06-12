package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;

import models.DatedLocation;
import models.NamedLocation;
import models.SplitRoute;
import models.Step;
import models.google.Location;
import models.google.GoogleStep;

@Dependent
public class RouteSplitterService {
    public RouteSplitterService() {
    }

    public SplitRoute SplitStepsIntoLocations(List<GoogleStep> steps, int updateInterval) {
        SplitRoute route = new SplitRoute();

        for (int index = 0; index < steps.size(); index++) {
            Step splitStep = new Step();

            GoogleStep step = steps.get(index);

            splitStep.setDistance(step.getDistance().getValue());
            splitStep.setStart(this.getRoad(step.getStart_location()));

            int distanceToMove = step.getSpeed() * updateInterval;

            while (step.getDistance().getValue() > 0) {
                DatedLocation location = getNextLocation(step, distanceToMove, updateInterval);
                if (location != null) {
                    splitStep.getLocations().add(location);
                }
            }
            route.getSteps().add(splitStep);
        }

        return route;
    }

    private DatedLocation getNextLocation(GoogleStep step, int distanceToMove, int updateInterval) {
        DatedLocation datedLocation = null;

        if (distanceToMove <= step.getDistance().getValue()) {
            Location locationAfterInterval = getLocationAfterInterval(step, updateInterval);
            datedLocation = new DatedLocation(locationAfterInterval.getLat(), locationAfterInterval.getLng(),
                    getNextDateTick(updateInterval));

            int startDistance = step.getDistance().getValue();
            step.setStart_location(locationAfterInterval);
            int newDistance = startDistance - distanceToMove;
            step.getDistance().setValue(newDistance);
        } else {
            step.getDistance().setValue(0);
        }

        return datedLocation;
    }

    private NamedLocation getRoad(Location location) {
        String roadname = new GoogleGeocodingService().getStreetname(location);
        return new NamedLocation(roadname, location.getLat(), location.getLng());
    }

    private Location getLocationAfterInterval(GoogleStep step, int updateInterval) {
        double differenceInLat = step.getEnd_location().getLat() - step.getStart_location().getLat();
        double differenceInLng = step.getEnd_location().getLng() - step.getStart_location().getLng();

        differenceInLat = differenceInLat / (double) step.getDuration().getValue() * (double) updateInterval;
        differenceInLng = differenceInLng / (double) step.getDuration().getValue() * (double) updateInterval;

        double newLat = step.getStart_location().getLat() + differenceInLat;
        double newLng = step.getStart_location().getLng() + differenceInLng;

        return new Location(newLat, newLng);
    }

    Calendar calendar = Calendar.getInstance();

    private Date getNextDateTick(int secondInterval) {
        calendar.add(Calendar.SECOND, secondInterval);
        return calendar.getTime();
    }
}