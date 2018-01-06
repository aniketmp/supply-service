package no.tusla.supplyservice.contract;


//import io.restassured.module.mockmvc.RestAssuredMockMvc;
import no.tusla.supplyservice.controller.SupplyController;
import no.tusla.supplyservice.model.Supply;
import no.tusla.supplyservice.service.SupplyServiceImpl;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

public class ContractVerifierBase {

    @Mock
    private SupplyServiceImpl supplyService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(
                supplyService.checkDeliveryForTire("ModelX", "summer"))
                .thenReturn(Collections.singletonList(
                        new Supply(
                                "ModelX",
                                "summer",
                                "stealth",
                                1000,
                                "01012018")));
        //RestAssuredMockMvc.standaloneSetup(new SupplyController(supplyService));
    }
}