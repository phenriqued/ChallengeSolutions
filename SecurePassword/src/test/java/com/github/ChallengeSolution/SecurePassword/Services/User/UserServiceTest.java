package com.github.ChallengeSolution.SecurePassword.Services.User;

import com.github.ChallengeSolution.SecurePassword.DTOs.User.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JacksonTester<UserDTO> userDTOJson;

    @Test
    @DisplayName("Deverá retornar uma lista dos critérios que não foram atendidos e 400 Bad Request")
    void validatePasswordScenarioOne() throws Exception{
        mockMvc.perform(post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        userDTOJson.write(new UserDTO("Jonas", "teste")).getJson()
                )).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$",containsInAnyOrder(
                    "A senha deve possuir pelo menos 8 caracteres",
                        "A senha deve possuir pelo menos um caractere maiúsculo e minúsculo",
                        "A senha deve possuir pelo menos um dígito númerico",
                        "A senha deve possuir pelo menos um caractere especial (e.g, !@#$%)."
                )));
    }

    @Test
    @DisplayName("Deverá retornar 201 No Content")
    void validatePasswordScenarioTwo() throws Exception {
        mockMvc.perform(post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        userDTOJson.write(new UserDTO("Jonas", "TestOne123@")).getJson()
                )).andExpect(status().isNoContent());

    }

}