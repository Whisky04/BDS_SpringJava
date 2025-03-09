package lt.vilniustech.dpanasenko.first_spring.service;

import lt.vilniustech.dpanasenko.first_spring.model.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class XMLTransformationServiceTest {

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private XMLTransformationService xmlTransformationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void transformToXML_shouldReturnFilePath() throws Exception {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");

        String expectedPath = "xml_output/customer_1.xml";
        when(fileStorageService.saveFile(anyString(), any())).thenReturn(expectedPath);

        String result = xmlTransformationService.transformToXML(customer);

        assertNotNull(result);
        assertEquals(expectedPath, result);
        verify(fileStorageService, times(1)).saveFile(anyString(), any());
    }

    @Test
    void transformToXML_shouldHandleException() throws IOException {
        Customer customer = new Customer();
        customer.setId(2);

        when(fileStorageService.saveFile(anyString(), any())).thenThrow(new IOException());

        String result = xmlTransformationService.transformToXML(customer);

        assertNull(result);
    }

    @Test
    void transformToXML_shouldLogException() throws IOException {
        Customer customer = new Customer();
        customer.setId(3);

        when(fileStorageService.saveFile(anyString(), any())).thenThrow(new IOException());

        String result = xmlTransformationService.transformToXML(customer);

        assertNull(result);
        verify(fileStorageService, times(1)).saveFile(anyString(), any());
    }
}
