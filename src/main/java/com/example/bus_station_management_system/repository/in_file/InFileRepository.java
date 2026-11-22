package com.example.bus_station_management_system.repository.in_file;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.in_memory.InMemoryRepository;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class InFileRepository<T extends Identifiable> extends InMemoryRepository<T> {

    private final JsonMapper mapper;
    private final File file;
    private final Class<T> type;

    protected InFileRepository(JsonMapper mapper, String dataDir, String fileName, Class<T> type) {
        this.mapper = mapper;
        this.type = type;
        this.file = new File(dataDir, fileName);
        load();
    }

    @Override
    public synchronized T create(T entity) {
        T created = super.create(entity);
        saveToFile();
        return created;
    }

    @Override
    public synchronized T update(T entity){
        T updated = super.update(entity);
        saveToFile();
        return updated;
    }

    @Override
    public synchronized void delete(String id){
        super.delete(id);
        saveToFile();
    }

    private void load() {
        if (!file.exists() || file.length() == 0) {
            return;                                   // nothing saved yet: start empty
        }
        try {
            List<T> entities = mapper.readValue(file,
                    mapper.getTypeFactory().constructCollectionType(List.class, type));
            for (T entity : entities) {
                if (entity.getId() == null || entity.getId().isBlank()) {
                    throw new IllegalStateException(file.getName() + " contains a record without an id");
                }
                if (storage.putIfAbsent(entity.getId(), entity) != null) {
                    throw new IllegalStateException(file.getName() + " contains the id " + entity.getId() + " twice");
                }
            }
        } catch (JacksonException e) {
            throw new IllegalStateException("Could not read " + file.getAbsolutePath(), e);
        }
    }

    private void saveToFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, new ArrayList<>(storage.values()));
        } catch (JacksonException e) {
            throw new IllegalStateException("Could not write " + file.getAbsolutePath(), e);
        }
    }
}