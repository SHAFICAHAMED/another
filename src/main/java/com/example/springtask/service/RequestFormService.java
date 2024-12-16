package com.example.springtask.service;

import com.example.springtask.Model.RequestForm;
import com.example.springtask.repository.RequestFormRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RequestFormService {

    private final RequestFormRepo requestFormRepo;

    public RequestFormService(RequestFormRepo requestFormRepo) {
        this.requestFormRepo = requestFormRepo;
    }

    public List<RequestForm> create(RequestForm user) {
        return Collections.singletonList(requestFormRepo.save(user));
    }

    public Optional<RequestForm> getById(long id) {
        return requestFormRepo.findById(id);
    }

    public void deleteById(long id) {
        requestFormRepo.deleteById(id);
    }

    public List<RequestForm> read() {
        return requestFormRepo.findAll();
    }
}
