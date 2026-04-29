package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.Lgas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LgaRepository extends MongoRepository<Lgas, String> {
    boolean existsByLgaCode(String lgaCode);

    Optional<Lgas> findByLgaCode(String lgaCode);

    List<Lgas> findByStateCode(String stateCode);

    Optional<Lgas> findByLgaNameIgnoreCase(String stateName);
}
