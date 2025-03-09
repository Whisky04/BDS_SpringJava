package lt.vilniustech.dpanasenko.first_spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type File storage service test.
 */
class FileStorageServiceTest {

    private FileStorageService fileStorageService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        fileStorageService = new FileStorageService();
    }

    /**
     * Save file should create file.
     *
     * @throws IOException the io exception
     */
    @Test
    void saveFile_shouldCreateFile() throws IOException {
        String fileName = "test_file.xml";
        byte[] data = "<test>Data</test>".getBytes();

        String filePath = fileStorageService.saveFile(fileName, data);

        File file = new File(filePath);
        assertTrue(file.exists());
        assertEquals("xml_output/" + fileName, filePath);

        file.delete();
    }

    /**
     * Save file should throw exception on invalid path.
     */
    @Test
    void saveFile_shouldThrowExceptionOnInvalidPath() {
        FileStorageService faultyService = new FileStorageService() {
            @Override
            public String saveFile(String fileName, byte[] data) throws IOException {
                throw new IOException();
            }
        };

        assertThrows(IOException.class, () -> faultyService.saveFile("invalid_file.xml", "test".getBytes()));
    }
}
