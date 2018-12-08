package com.rent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rent.controller.mapper.PersonMapper;
import com.rent.datatransferobject.PersonDTO;
import com.rent.domainobject.PersonDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.ZonedDateTime;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private static ObjectMapper objectMapper;

    @Test
    public void createPerson() throws Exception {
        PersonDO person = new PersonDO();
        person.setId(1L);
        person.setDateCreated(ZonedDateTime.now());
        person.setEmail("vinicius.global@gmail.com");
        person.setName("Marcos");
        person.setPassportNumber("FU871263");
        person.setTelephone("21376873");
        PersonDTO dto = PersonMapper.makePersonDTO(person);
        mockMvc.perform(post("/v1/persons").with(user("rent").password("rent"))
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(dto)))
                .andExpect(status().isOk());


//        mvc.perform(get(VERSION + ARRIVAL + "all")
//                .with(user("rent").password("rent"))
//                .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].city", is(arrival.getCity())));
    }
}
