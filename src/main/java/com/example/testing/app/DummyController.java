package com.example.testing.app;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.usecase.DummyUseCase;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/dummies")
public class DummyController {
    private final DummyUseCase dummyUseCase;

    public DummyController(DummyUseCase dummyUseCase) {
        this.dummyUseCase = dummyUseCase;
    }

    @GetMapping
    public List<Dummy> list() {
        return dummyUseCase.allDummies();
    }

    @PostMapping
    public Dummy add(@RequestBody @Validated DummyAddRequest request) {
        return dummyUseCase.newDummy(request.toDummy());

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
