package com.example.btvn.repository;

import com.example.btvn.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFilter extends JpaRepository <Student,Long> {
//    @Query(value="SELECT * FROM student JOIN inforegiter ON student.idStudent = inforegiter.idStudent " +
//            "WHERE idSubject IN :subject " +
//            "AND sex IN :sex " +
//            "AND idStatus IN :status " +
//            "AND name LIKE '%' || ? || '%';", nativeQuery = true)
//    Page<Student> searchByFilter(@Param("subject") List<Long> subject ,
//                                 @Param("subject") List<Integer> sex  ,
//                                 @Param("subject") List<Long> status ,
//                                 String name , Pageable pageable);
}
