package com.digimaint_sample.demo;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import com.digimaint_sample.demo.controller.UploadController;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UploadControllerTest {

    @Test
    void testHandleFileUpload() throws IOException {
        UploadController controller = new UploadController();
        MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "Hello World!".getBytes());

        String result = controller.handleFileUpload(file);

        assertEquals("redirect:/upload?success", result);

        File uploadedFile = new File("uploads/test.txt");
        assertTrue(uploadedFile.exists());
    }

    @Test
    void testHandleFileUploadNoFile() {
        UploadController controller = new UploadController();

        String result = controller.handleFileUpload(null);

        assertEquals("redirect:/upload?error", result);
    }

}
