package services.implementation;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import models.RoadType;
import services.RoadTypeService;

@ApplicationScoped
public class JpaRoadTypeSerivce implements RoadTypeService {

    @PersistenceContext(name = "PU")
    private EntityManager manager;

    @Override
    public List<RoadType> getAll() {
        return manager.createQuery("SELECT r FROM RoadType r", RoadType.class).getResultList();
    }

    @Override
    public RoadType getByName(String name) {
        Optional<RoadType> type = manager.createQuery("SELECT r FROM RoadType r WHERE name LIKE :name", RoadType.class)
                .setParameter("name", name).setMaxResults(1).getResultList().stream().findFirst();

        if (!type.isPresent()) {
            return null;
        }

        return type.get();
    }

    @Override
    @Transactional
    public void update(RoadType type) {
        manager.merge(type);
    }

    @Override
    public RoadType getBySpeed(int speed) {
        Optional<RoadType> type = manager.createQuery("SELECT m FROM RoadType m WHERE speed = :speed", RoadType.class)
                .setParameter("speed", speed).setMaxResults(1).getResultList().stream().findFirst();

        if (!type.isPresent()) {
            return null;
        }

        return type.get();
    }
}