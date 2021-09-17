package co.com.poli.shopping.controller;

import co.com.poli.shopping.entities.Invoice;
import co.com.poli.shopping.services.InvoiceServiceImpl;
import co.com.poli.shopping.utils.ErrorMessage;
import co.com.poli.shopping.utils.Response;
import co.com.poli.shopping.utils.ResponseBuilder;
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
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;
    private final ResponseBuilder builder;

    @PostMapping()
    public Response save(@Valid @RequestBody Invoice invoice, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        invoiceService.save(invoice);
        return builder.success(invoice);
    }

    @DeleteMapping("/{numberId}")
    public Response delete(@PathVariable("numberId") String numberId) {
        Invoice invoice = invoiceService.findByNumberInvoice(numberId);
        if(invoice==null){
            return builder.failed(invoice);
        }
     return builder.success(invoice);
    }

    @GetMapping("/{numberInvoice}")
    public Response getByNumberInvoice(@PathVariable("numberInvoice") String numberInvoice){
        Invoice invoice = invoiceService.findByNumberInvoice(numberInvoice);
        if(invoice==null){
            return builder.success();
        }
        return builder.success(invoice);
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
