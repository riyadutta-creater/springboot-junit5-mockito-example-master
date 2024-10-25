package com.easy2excel.springbootjunit5mockitoexample.repository;

import com.easy2excel.springbootjunit5mockitoexample.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
