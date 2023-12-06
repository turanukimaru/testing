package com.example.testing.logic.app;

import com.example.testing.app.GreetingController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GreetingController.class})
@ExtendWith(SpringExtension.class)
class GreetingControllerDiffblueTest {
    @Autowired
    private GreetingController greetingController;

    /**
     * Method under test: {@link GreetingController#dummy()}
     */
    @Test
    void testDummy() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hi");
        MockMvcBuilders.standaloneSetup(greetingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Hi!\"}"));
    }

    /**
     * Method under test: {@link GreetingController#dummy()}
     */
    @Test
    void testDummy2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hi", "Uri Variables");
        MockMvcBuilders.standaloneSetup(greetingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Hi!\"}"));
    }
}
