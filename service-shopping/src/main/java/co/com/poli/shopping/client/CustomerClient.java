package co.com.poli.shopping.client;

import co.com.poli.shopping.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-customer",fallback = CustomerClientFallBackHystrix.class)
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    Response findById(@PathVariable("id") Long id);

    @GetMapping("/customer/numberId/{id}")
    Response findByNumberId(@PathVariable("id") String numberId);
}
