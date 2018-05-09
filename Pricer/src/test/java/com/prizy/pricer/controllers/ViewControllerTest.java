package com.prizy.pricer.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.prizy.pricer.models.Product;
import com.prizy.pricer.rest.controllers.ProductController;
import com.prizy.pricer.services.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(secure=false)
public class ViewControllerTest {
	
	@Autowired
    private MockMvc mockMvc;	
	@Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private ProductService productServiceMock;
    @Before
    public void setUp() {
         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }       
    
    Product product1;
    @Before
    public void setUpProduct() throws Exception{
        product1 = new Product();        
        product1.setBarcode("235268845711068308");
        product1.setDescription("The Prizy Pricer");
        product1.setPrice(18.95);
        product1.setAvgPrice(16.56);
        product1.setHighestPrice(20.89);
        product1.setLowestPrice(15.50);
        product1.setIdealPrice(19.45);
        product1.setPriceCollectCount(1);
    }
        
    @Test
    public void testList() throws Exception {
        assertThat(this.productServiceMock).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/products/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("index"))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(content().string(Matchers.containsString("Prizy Pricer")))
                .andDo(print());
    }
    
    @Test
    public void testShowProduct() throws Exception {
        assertThat(this.productServiceMock).isNotNull();
        when(productServiceMock.getProductById("235268845711068308"));
        MvcResult result= mockMvc.perform(get("/products/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("product"))
                .andExpect(model().attribute("product", hasProperty("barcode", is("235268845711068308"))))
                .andExpect(model().attribute("product", hasProperty("higestPrice", is("20.5"))))
                .andExpect(model().attribute("product", hasProperty("description", is("The Prizy Pricer"))))
                .andExpect(model().attribute("product", hasProperty("price", is("18.95"))))
                .andExpect(model().attribute("product", hasProperty("priceCollectCount", is("1"))))
                .andReturn();
        MockHttpServletResponse mockResponse=result.getResponse();
        assertThat(mockResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");
        Collection<String> responseHeaders = mockResponse.getHeaderNames();
        assertNotNull(responseHeaders);
        assertEquals(1, responseHeaders.size());
        assertEquals("Check for Content-Type header", "Content-Type", responseHeaders.iterator().next());
        String responseAsString=mockResponse.getContentAsString();
        assertTrue(responseAsString.contains("The Prizy Pricer"));
        verify(productServiceMock, times(1)).getProductById("235268845711068308");
        verifyNoMoreInteractions(productServiceMock);
    }

	private Object hasProperty(String string, Matcher<String> matcher) {		
		return null;
	}


}
