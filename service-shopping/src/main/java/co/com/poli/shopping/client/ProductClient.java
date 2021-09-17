package co.com.poli.shopping.client;

import co.com.poli.shopping.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-product")
@RequestMapping("/product")
public interface ProductClient {

    @GetMapping("/{id}")
    Response findById(@PathVariable("id") Long id);
}
