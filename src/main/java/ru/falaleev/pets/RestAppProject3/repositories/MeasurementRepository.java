package ru.falaleev.pets.RestAppProject3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.falaleev.pets.RestAppProject3.models.Measurement;


@Repository
public interface MeasurementRepository extends JpaRepository <Measurement, Integer> {

}
//работате с базой данных в таблице с Meansurement  и дает туда доступ, тут можно
// еще прописать  другую логику для поиска данных по разным столбцам