package com.example.btvn.repository;

import com.example.btvn.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    @Query(value="select * from student where name like %?%", nativeQuery = true)
    List<Student> searchByName(String name);
    @Query(value="select * from student where idStatus=?",nativeQuery = true)
    List<Student> searchByStatus(Long id);}
    @Query(value="select * from student where address like %?%", nativeQuery = true)
    List<Student> searchByAddress(String name);
    @Query(value="select * from student join inforegiter on student.idStudent=inforegiter.idStudent where idSubject=?", nativeQuery = true)
    List<Student> searchBySubject(Long id);
//    @Query(value="SELECT * FROM student JOIN inforegiter ON student.idStudent = inforegiter.idStudent " +
//            "WHERE idSubject IN :subject " +
//            "AND sex IN :sex " +
//            "AND idStatus IN :status " +
//            "AND name LIKE '%' || ? || '%';", nativeQuery = true)
//    Page<Student> searchByFilter(@Param("subject") List<Long> subject ,
//                                 @Param("subject") List<Integer> sex  ,
//                                 @Param("subject") List<Long> status ,
//                                 String name , Pageable pageable);
//
//
//}
