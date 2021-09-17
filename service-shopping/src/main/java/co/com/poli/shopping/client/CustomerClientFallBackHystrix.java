package co.com.poli.shopping.client;

import co.com.poli.shopping.model.Customer;
import co.com.poli.shopping.utils.Response;
import co.com.poli.shopping.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerClientFallBackHystrix implements CustomerClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Customer customer = Customer.builder()
                .firstName("")
                .lastName("")
                .email("").build();
        return  builder.success(customer);
    }

    @Override
    public Response findByNumberId(String numberId) {
        Customer customer = Customer.builder()
                .firstName("")
                .lastName("")
                .email("").build();
        return  builder.success(customer);
    }
}
