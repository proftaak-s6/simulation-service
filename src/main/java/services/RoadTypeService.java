package services;

import java.util.List;

import models.RoadType;

public interface RoadTypeService {

	List<RoadType> getAll();

	RoadType getByName(String name);

	void update(RoadType type);

	RoadType getBySpeed(int speed);

}