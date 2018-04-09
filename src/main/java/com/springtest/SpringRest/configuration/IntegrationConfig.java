package com.springtest.SpringRest.configuration;

import com.springtest.SpringRest.service.UdpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Udp;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

//    @Bean
//    public UdpService udpService() {
//        return new UdpService();
//    }

//    @Bean
//    public IntegrationFlow processUdpMessage() {
//        UnicastReceivingChannelAdapter unicastReceivingChannelAdapter = new UnicastReceivingChannelAdapter(8000);
//        return IntegrationFlows.from(unicastReceivingChannelAdapter)
//                .handle("udpService", "receiveData")
//                .get();
//    }

//    @Bean
//    public IntegrationFlow udpOutFlow() {
//        return IntegrationFlows.from(new UnicastSendingMessageHandler("localhost", 11111))
//                .handle(Udp.outboundAdapter("localhost", 1234))
//                .get();
//    }

//    @Bean
//    public MessageChannel sender() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    public IntegrationFlow udpIn() {
//        return IntegrationFlows.from(sender())
//                .handle(Udp.outboundAdapter("headers['ip_packetAddress']").socketExpression("@udpIn.socket"))
//                .get();
//    }

//    @Bean
//    public IntegrationFlow udpEchoUpcaseServer() {
//        return IntegrationFlows.from(sender())//
//                .<byte[], String>transform(p -> new String(p).toUpperCase())
//                .handle(Udp.outboundAdapter("headers['ip_packetAddress']")
//                        .socketExpression("@udpIn.socket"))
//                .get();
//    }
}
