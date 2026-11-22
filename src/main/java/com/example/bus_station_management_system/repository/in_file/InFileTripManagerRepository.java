package com.example.bus_station_management_system.repository.in_file;

import com.example.bus_station_management_system.model.TripManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.json.JsonMapper;

@Repository
@Profile("file")
public class InFileTripManagerRepository extends InFileRepository<TripManager> {
    public InFileTripManagerRepository(JsonMapper mapper, @Value("${app.data-dir}") String dataDir) {
        super(mapper, dataDir, "trip-manager.json", TripManager.class);
    }
}
