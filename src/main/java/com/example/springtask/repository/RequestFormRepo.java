package com.example.springtask.repository;

import com.example.springtask.Model.RequestForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestFormRepo  extends JpaRepository<RequestForm,Long> {
}
