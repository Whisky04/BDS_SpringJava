package lt.vilniustech.dpanasenko.first_spring.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The type File storage service.
 */
@Service
public class FileStorageService {

    private static final String XML_DIRECTORY = "xml_output/";

    /**
     * Instantiates a new File storage service.
     */
    public FileStorageService() {
        createDirectory();
    }

    private void createDirectory() {
        File directory = new File(XML_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * Save file string.
     *
     * @param fileName the file name
     * @param data     the data
     * @return the string
     * @throws IOException the io exception
     */
    public String saveFile(String fileName, byte[] data) throws IOException {
        String filePath = XML_DIRECTORY + fileName;
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(data);
        }
        return filePath;
    }
}
