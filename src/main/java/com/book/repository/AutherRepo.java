package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.model.Author;

public interface AutherRepo extends JpaRepository<Author, Integer> {

}
