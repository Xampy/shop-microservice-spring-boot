package com.xampydrivesell.userShopService.userInterface.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xampydrivesell.userShopService.domain.port.secondary.repository.ShopRepositoryInterface;
import com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository.ShopDatabaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
@AutoConfigureMockMvc
class GetAllShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ShopDatabaseRepository repository;
    
    @Test
    void itShouldGetShops() throws Exception {
        //given
        
        //when
        ResultActions resultActions = mockMvc
                .perform(
                        get("/api/v1/shops").contentType(MediaType.APPLICATION_JSON)
                );

        //then
        resultActions.andExpect(status().isOk());
    }

}