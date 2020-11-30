package com.seaborne.soap_consumer;


import com.example.consumingwebservice.wsdl.SendOrderRequest;
import com.example.consumingwebservice.wsdl.SendOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrderController {
    @Autowired
    private  OrderClient orderClient;

    @PostMapping("/api/soap_consumer/sendOrder")
    SendOrderResponse getOrderResponse(@RequestBody SendOrderRequest request){
        return orderClient.sendOrder(request);
    }

}
