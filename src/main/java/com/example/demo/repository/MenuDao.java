package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Menu;

@Repository //�U�� //interface 
public interface MenuDao extends JpaRepository<Menu,String> {

}