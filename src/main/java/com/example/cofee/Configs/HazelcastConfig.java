package com.example.cofee.Configs;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфиг Hazelcast
 */
@Configuration
public class HazelcastConfig {

    @Bean
    public HazelcastInstance hazelcastInstance(){
        return Hazelcast.newHazelcastInstance(config());
    }

    @Bean
    public Config config(){
        Config config = new Config();
        NetworkConfig network = config.getNetworkConfig();
        network.setPort(5701).setPortCount(20);
        network.setPortAutoIncrement(true);
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig()
                .addMember("localhost").setEnabled(true);
        return config;
    }
}
