package com.rud.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rud.crud.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
