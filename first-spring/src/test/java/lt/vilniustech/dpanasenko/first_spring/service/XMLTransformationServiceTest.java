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

/**
 * The type Xml transformation service test.
 */
class XMLTransformationServiceTest {

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private XMLTransformationService xmlTransformationService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Transform to xml should return file path.
     *
     * @throws Exception the exception
     */
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

    /**
     * Transform to xml should handle exception.
     *
     * @throws IOException the io exception
     */
    @Test
    void transformToXML_shouldHandleException() throws IOException {
        Customer customer = new Customer();
        customer.setId(2);

        when(fileStorageService.saveFile(anyString(), any())).thenThrow(new IOException());

        String result = xmlTransformationService.transformToXML(customer);

        assertNull(result);
    }

    /**
     * Transform to xml should log exception.
     *
     * @throws IOException the io exception
     */
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
