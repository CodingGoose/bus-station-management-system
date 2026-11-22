package com.example.bus_station_management_system.repository.in_file;

import com.example.bus_station_management_system.model.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.json.JsonMapper;

@Repository
@Profile("file")
public class InFileDriverRepository extends InFileRepository<Driver> {
    public InFileDriverRepository(JsonMapper mapper, @Value("${app.data-dir}") String dataDir) {
        super(mapper, dataDir, "driver.json", Driver.class);
    }
}
