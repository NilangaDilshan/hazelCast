package com.dilshan.hazelCast.configurations;

import com.dilshan.hazelCast.entities.Division;
import com.dilshan.hazelCast.serializer.DivisionSerializer;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Component;

//This is the local cache mechanism
@Component
public class HazelCastConfig {
    public static final String DIVISION = "divisions";
    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig(DIVISION);
        mapConfig.setTimeToLiveSeconds(360);
        mapConfig.setMaxIdleSeconds(400);
        return mapConfig;
    }

    private SerializerConfig serializerConfig() {
        return new SerializerConfig().setTypeClass(Division.class).setImplementation(new DivisionSerializer());
    }

    private Config createConfig() {
        Config config = new Config();
        config.addMapConfig(mapConfig());
        config.getSerializationConfig().addSerializerConfig(this.serializerConfig());
        return config;
    }

    public Division put(String number, Division division) {
        IMap<String, Division> map = hazelcastInstance.getMap(DIVISION);
        return map.putIfAbsent(number, division);
    }

    public Division get(String key) {
        IMap<String, Division> map = hazelcastInstance.getMap(DIVISION);
        return map.get(key);
    }
}
