package com.example.testing.usecase;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.service.DummyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DummyUseCase {
    private final DummyService dummyService;

    public DummyUseCase(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @Transactional
    public List<Dummy> allDummies(){
        return dummyService.getDummies();
    }

    @Transactional
    public List<Child> findChildren(Long dummyId) {
        return dummyService.getChildren(dummyId);
    }
    @Transactional
    public Dummy newDummy(Dummy dummy) {
        dummyService.saveDummy(dummy);
        return dummy;
    }
    @Transactional
    public void deleteDummy(Long dummyId) {
        dummyService.deleteDummy(dummyId);
    }
}
