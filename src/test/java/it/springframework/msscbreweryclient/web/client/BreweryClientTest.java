package it.springframework.msscbreweryclient.web.client;

import it.springframework.msscbreweryclient.web.model.BeerDto;
import it.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/*
*   In order to run this integration test mssc-brewery project must be running
* */
@SpringBootTest //brings up spring context
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        //given
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New_Beer").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        //Tests are green as long as RestTemplate is working fine (2xx)
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        //Tests are green as long as RestTemplate is working fine (2xx)
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        //given
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSaveCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Ivan Krstic").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Ivan Krstic").build();

        //Tests are green as long as RestTemplate is working fine (2xx)
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        //Tests are green as long as RestTemplate is working fine (2xx)
        client.deleteCustomer(UUID.randomUUID());
    }
}