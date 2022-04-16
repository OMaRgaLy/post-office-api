package kz.dar.academy.feign;

import kz.dar.academy.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("client-core-api")
public interface ClientFeign {
    @GetMapping("/client/check")
    String checkClientCoreApi();

    @GetMapping("/client/all")
    List<ClientModel> getAllClients();

    @GetMapping("/client/{clientId}")
    ClientModel getClientById(@PathVariable String clientId);
}
