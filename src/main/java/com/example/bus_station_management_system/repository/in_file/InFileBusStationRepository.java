package com.example.bus_station_management_system.repository.in_file;

import com.example.bus_station_management_system.model.BusStation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.json.JsonMapper;

@Repository
@Profile("file")
public class InFileBusStationRepository extends InFileRepository<BusStation> {
    public InFileBusStationRepository(JsonMapper mapper, @Value("${app.data-dir}") String dataDir) {
        super(mapper, dataDir, "bus-station.json", BusStation.class);
    }
}