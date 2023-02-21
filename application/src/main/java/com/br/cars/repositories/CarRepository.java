package com.br.cars.repositories;

import com.br.cars.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarModel, UUID> {
    Optional<CarModel> findByNome(String carName);
}
