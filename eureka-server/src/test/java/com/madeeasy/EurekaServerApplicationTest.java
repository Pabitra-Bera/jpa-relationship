package com.madeeasy;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EurekaServerApplication.class)
class EurekaServerApplicationTest {

    @Autowired
    private EurekaServerApplication eurekaServerApplication;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void main() throws Exception {
        mockMvc.perform(get("/eureka/"))
                .andExpect(status().isOk());
    }


}