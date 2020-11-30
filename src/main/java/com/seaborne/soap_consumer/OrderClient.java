package com.seaborne.soap_consumer;

import com.example.consumingwebservice.wsdl.SendOrderRequest;
import com.example.consumingwebservice.wsdl.SendOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OrderClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(OrderClient.class);

    public SendOrderResponse sendOrder(SendOrderRequest request) {

        SendOrderResponse response = (SendOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8082/ws", request);

        return response;
    }

}
