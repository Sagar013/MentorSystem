package com.mentorsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorsys.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
