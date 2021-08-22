package com.xampydrivesell.userShopService.userInterface.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xampydrivesell.userShopService.domain.entity.Shop;
import com.xampydrivesell.userShopService.infrastructure.adapter.secondary.repository.ShopDatabaseRepository;
import com.xampydrivesell.userShopService.userInterface.viewModel.ShopViewModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
@AutoConfigureMockMvc
class CreateShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ShopDatabaseRepository shopDatabaseRepository;

    @Test
    void itShouldReturnAddedShopWhenCanAddNewShop() throws Exception {
        //Given
        String shopName = "shop";
        String description = "description";

        //when
        ResultActions resultActions = mockMvc.perform(
                post("/api/v1/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                objectMapper.writeValueAsString(
                                        new CreateShopController.ActionRequest(shopName, description)
                                )
                        )
        );

        //then
        resultActions.andExpect(status().isOk());
        List<Shop> shops = shopDatabaseRepository.findAll();

        assertThat(shops).usingElementComparator((o1, o2) -> {
            if(o1.getName().equals(shopName) && o2.getDescription().equals(description))
                return 0;
            return 1;
        }
        ).contains(new Shop(shopName, description));

    }

    @Test
    void itShouldReturnErrorMessageWhenCanAddAndShopNameAlreadyExists() throws Exception {
        //Given
        String shopName = "shop";
        String description = "description";

        //when

        mockMvc.perform(
                post("/api/v1/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                objectMapper.writeValueAsString(
                                        new CreateShopController.ActionRequest(shopName, description)
                                )
                        )
        );

        ResultActions resultActions = mockMvc.perform(
                post("/api/v1/shops")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                objectMapper.writeValueAsString(
                                        new CreateShopController.ActionRequest(shopName, description)
                                )
                        )
        );

        //then
        resultActions.andExpect(status().isForbidden());
    }

}