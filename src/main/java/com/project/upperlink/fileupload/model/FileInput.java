package com.project.upperlink.fileupload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "documents")
public class FileInput {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512, nullable = false,unique = true)
    private String resume_name;

    private long resume_size;

    @Column(name = "resume_uploadTime")
    private Date resume_uploadTime;

    private byte[] resume_content;


    @Column(length = 512, nullable = false,unique = true)
    private String passport_name;

    private long passport_size;

    @Column(name = "passport_uploadTime")
    private Date passport_uploadTime;

    private byte[] passport_content;

    public FileInput(String resume_name, long resume_size, Date resume_uploadTime, byte[] resume_content, String passport_name, long passport_size, Date passport_uploadTime, byte[] passport_content) {
        this.resume_name = resume_name;
        this.resume_size = resume_size;
        this.resume_uploadTime = resume_uploadTime;
        this.resume_content = resume_content;
        this.passport_name = passport_name;
        this.passport_size = passport_size;
        this.passport_uploadTime = passport_uploadTime;
        this.passport_content = passport_content;
    }

}
