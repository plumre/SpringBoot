package com.bayee;

/*
 * Created by renhongjiang on 2019/2/27.
 */

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/27 15:48
 */
@Configuration
public class ElasticSearchConfig {

    @Bean
    public TransportClient getClient() throws UnknownHostException {
        TransportAddress node = new TransportAddress(InetAddress.getByName("10.10.1.115"), 9300);
        Settings settings = Settings.builder().put("cluster.name", "caho").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);
        return client;
    }

}