package com.outeseratest.raspberry.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalcularIntervalosIntegrationTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    void deveRetornarJsonComIntervalosCorretos() throws Exception {
        String expectedJson = Files.readString(new ClassPathResource("csv/interval_expected.json").getFile().toPath());

        String actualJson = mockMvc.perform(get("/api/awards/producers/intervals"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(actualJson).isEqualToIgnoringWhitespace(expectedJson);
    }
}
