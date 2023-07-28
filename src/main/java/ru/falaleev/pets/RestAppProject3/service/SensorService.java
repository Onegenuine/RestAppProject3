package ru.falaleev.pets.RestAppProject3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.falaleev.pets.RestAppProject3.models.Sensor;
import ru.falaleev.pets.RestAppProject3.repositories.SensorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

@Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }



    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    //метод котрый сохраняет однин сенсор с бд
    @Transactional
    public void register(Sensor sensor) {
        sensorRepository.save(sensor);

    }
}
