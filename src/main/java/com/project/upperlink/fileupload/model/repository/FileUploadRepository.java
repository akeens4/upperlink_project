package com.project.upperlink.fileupload.model.repository;

import com.project.upperlink.fileupload.model.FileInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public interface FileUploadRepository extends JpaRepository<FileInput,Long> {

//    @Query("SELECT new FileInput(d.id, d.filename, d.size) FROM FileInput d ORDER BY d.uploadTime DESC")
//    List<FileInput> findAll();

}
