package com.example.testing.service;

import com.example.testing.entity.Dummy;
import com.example.testing.repo.DummyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyService {
    private final DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public List<Dummy> getDummies() {
        return dummyRepository.findAll();
    }

    public void saveDummy(Dummy dummy) {
        dummyRepository.save(dummy);
    }

    public void deleteDummy(Long dummyId) {
        dummyRepository.deleteById(dummyId);
    }
}
