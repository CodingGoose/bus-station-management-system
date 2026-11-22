package com.example.bus_station_management_system.repository.in_file;

import com.example.bus_station_management_system.model.Bus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.json.JsonMapper;

@Repository
@Profile("file")
public class InFileBusRepository extends InFileRepository<Bus> {
    public InFileBusRepository(JsonMapper mapper, @Value("${app.data-dir}") String dataDir) {
        super(mapper, dataDir, "bus.json", Bus.class);
    }
}
