package com.digimaint_sample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Define the directory where the uploaded files will be saved
                String uploadDir = "uploads/";

                // Create the directory if it doesn't exist
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Save the uploaded file to the specified directory
                String fileName = file.getOriginalFilename();
                File dest = new File(uploadDir + fileName);
                file.transferTo(dest);

                return "redirect:/upload?success";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/upload?error";
    }
}