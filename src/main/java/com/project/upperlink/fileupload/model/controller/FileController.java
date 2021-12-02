package com.project.upperlink.fileupload.model.controller;


import com.project.upperlink.fileupload.model.FileInput;
import com.project.upperlink.fileupload.model.repository.FileUploadRepository;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/upload")
//@CrossOrigin(origins = "http://localhost:8081")
public class FileController {

    private FileUploadRepository uploadRepository;

    @PostMapping
    public void uploadFile(@RequestParam("resume") MultipartFile resume,@RequestParam("passport") MultipartFile passport,
                           RedirectAttributes ra)
            throws IOException {

        //Upload Applicant Resume
        String resumeName = StringUtils.cleanPath(resume.getOriginalFilename());

        String passportName = StringUtils.cleanPath(passport.getOriginalFilename());

        FileInput fileUpload = new FileInput();
        fileUpload.setResume_name(resumeName);
        fileUpload.setResume_content(resume.getBytes());
        fileUpload.setResume_size(resume.getSize());
        fileUpload.setResume_uploadTime(new Date());

        fileUpload.setPassport_name(passportName);
        fileUpload.setPassport_content(passport.getBytes());
        fileUpload.setResume_size(passport.getSize());
        fileUpload.setPassport_uploadTime(new Date());

        ra.addFlashAttribute("message","The files have been uploaded successfully.");

        uploadRepository.save(fileUpload);

    }
}
