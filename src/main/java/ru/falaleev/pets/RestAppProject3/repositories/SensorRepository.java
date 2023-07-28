package ru.falaleev.pets.RestAppProject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.falaleev.pets.RestAppProject3.models.Sensor;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {

        Optional<Sensor> findByName(String name);
}
//работате с базой данных в таблице с Sensor  и дает туда доступ, тут можно
// еще прописать  другую логику для поиска данных по разным столбцам