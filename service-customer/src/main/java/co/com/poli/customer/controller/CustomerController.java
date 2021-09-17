package co.com.poli.customer.controller;

import co.com.poli.customer.entities.Customer;
import co.com.poli.customer.services.CustomerService;
import co.com.poli.customer.utils.ErrorMessage;
import co.com.poli.customer.utils.Response;
import co.com.poli.customer.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Customer customer, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(this.formatMessage((result)));
        }
        customerService.save(customer);
        return builder.success(customer);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        return builder.success(customer);
    }

    @GetMapping("/numberId/{id}")
    public Response findByNumberId(@PathVariable("id") String numberId){
        Customer customer = customerService.findByNumberId(numberId);
        return builder.success(customer);
    }


    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try{
            json = objectMapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }

}
