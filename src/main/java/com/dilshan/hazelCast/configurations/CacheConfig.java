package com.dilshan.hazelCast.configurations;

import com.dilshan.hazelCast.entities.Division;
import com.dilshan.hazelCast.serializer.DivisionSerializer;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Component;

/*This can be used to connect to a HazelCast cluster*/

//@Component
public class CacheConfig {
    private static final String DIVISIONS = "divisions";

    private final HazelcastInstance client = HazelcastClient.newHazelcastClient(creatClientConfig());

    public Division put(String key, Division student) {
        IMap<String, Division> map = client.getMap(DIVISIONS);
        return map.putIfAbsent(key, student);
    }

    public Division get(String key) {
        IMap<String, Division> map = client.getMap(DIVISIONS);
        return map.get(key);
    }

    private ClientConfig creatClientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getSerializationConfig().addSerializerConfig(serializerConfig());
        clientConfig.getNetworkConfig().addAddress("");// Add the address of at least one member in the cluster
        return clientConfig;
    }

    private SerializerConfig serializerConfig() {
        return new SerializerConfig().setImplementation(new DivisionSerializer()).setTypeClass(Division.class);
    }

}
