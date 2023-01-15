package br.com.peopleapi.peopleapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.peopleapi.peopleapi.dtos.PeopleTestDTO;
import br.com.peopleapi.peopleapi.factory.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PeopleControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;
    private Long countTotalPeoples;
    private PeopleTestDTO peopleDTO;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalPeoples = 5L;
        peopleDTO = Factory.createPeopleDTO();
    }

    @Test
    public void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(peopleDTO);
        ResultActions result = mockMvc.perform(put("/people/{id}", nonExistingId).content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

    @Test
    public void updateShouldReturnPeopleDTOWhenIdExists() throws Exception {

        String jsonBody = objectMapper.writeValueAsString(peopleDTO);
        String expectedName = peopleDTO.getFirstName();
        String expectedCPF = peopleDTO.getCpf();
        ResultActions result = mockMvc.perform(put("/api/v1/people/{id}", existingId).content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").value(existingId));
        result.andExpect(jsonPath("$.firstName").value(expectedName));
        result.andExpect(jsonPath("$.cpf").value(expectedCPF));
    }

    @Test
    public void findAllShouldReturnPage() throws Exception {
        ResultActions result = mockMvc
                .perform(get("/api/v1/people/page").accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.totalElements").value(countTotalPeoples));
        result.andExpect(jsonPath("$.content[0].firstName").value("Andre"));
    }
}
