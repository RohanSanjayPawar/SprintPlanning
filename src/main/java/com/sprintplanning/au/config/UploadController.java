package com.sprintplanning.au.config;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@CrossOrigin
public class UploadController  {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://temp/";
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
  //  @PostMapping("/upload") // //new annotation since 4.3
    @RequestMapping(value = "/upload", method= RequestMethod.POST, 
    headers = ("content-type=multipart/*"))
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
    	System.out.println(UPLOADED_FOLDER);
    	System.out.println(file);
        if (file.isEmpty()) {
            return "Upload Failed";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Upload Success";
    }

}
