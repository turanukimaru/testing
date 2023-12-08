package com.example.testing.app;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.usecase.DummyUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/dummies")
public class DummyController {
    private final DummyUseCase dummyUseCase;

    public DummyController(DummyUseCase dummyUseCase) {
        this.dummyUseCase = dummyUseCase;
    }

    @GetMapping
    public List<Dummy> list() {
        return dummyUseCase.allDummies();
    }
    @PutMapping
    public Dummy add() {
        return dummyUseCase.newDummy();

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dummyUseCase.deleteDummy(id);
    }

    @GetMapping("/{id}/children")
    public List<Child> children(@PathVariable Long id) {
        return dummyUseCase.findChildren(id);
    }
}
