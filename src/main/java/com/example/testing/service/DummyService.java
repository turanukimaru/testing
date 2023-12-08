package com.example.testing.service;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.repo.ChildRepository;
import com.example.testing.repo.DummyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyService {
    private final DummyRepository dummyRepository;
    private final ChildRepository childRepository;

    public DummyService(DummyRepository dummyRepository, ChildRepository childRepository) {
        this.dummyRepository = dummyRepository;
        this.childRepository = childRepository;
    }

    public List<Dummy> getDummies() {
        return dummyRepository.findAll();
    }

    public List<Child> getChildren(Long dummyId) {
        return childRepository.findByDummyId(dummyId);
    }

    public void saveDummy(Dummy dummy) {
        dummyRepository.save(dummy);
    }

    public void deleteDummy(Long dummyId) {
        dummyRepository.deleteById(dummyId);
    }
}
