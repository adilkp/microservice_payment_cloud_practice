package com.payments.service.serviceimpl;

import com.payments.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081", value = "User-Client")
@FeignClient(name = "USER-MICROSERVICE")
public interface UserClient {

    @GetMapping("/user/{user_id}")
    User getUserOfTransaction(@PathVariable Long user_id);
}
