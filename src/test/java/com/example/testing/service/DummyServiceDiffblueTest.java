package com.example.testing.service;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.repo.ChildRepository;
import com.example.testing.repo.DummyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DummyService.class})
@ExtendWith(SpringExtension.class)
class DummyServiceDiffblueTest {
    @MockBean
    private ChildRepository childRepository;

    @MockBean
    private DummyRepository dummyRepository;

    @Autowired
    private DummyService dummyService;

    /**
     * Method under test: {@link DummyService#getDummies()}
     */
    @Test
    void testGetDummies() {
        ArrayList<Dummy> dummyList = new ArrayList<>();
        when(dummyRepository.findAll()).thenReturn(dummyList);
        List<Dummy> actualDummies = dummyService.getDummies();
        verify(dummyRepository).findAll();
        assertTrue(actualDummies.isEmpty());
        assertSame(dummyList, actualDummies);
    }

    /**
     * Method under test: {@link DummyService#getChildren(Long)}
     */
    @Test
    void testGetChildren() {
        ArrayList<Child> childList = new ArrayList<>();
        when(childRepository.findByDummyId(Mockito.<Long>any())).thenReturn(childList);
        List<Child> actualChildren = dummyService.getChildren(1L);
        verify(childRepository).findByDummyId(Mockito.<Long>any());
        assertTrue(actualChildren.isEmpty());
        assertSame(childList, actualChildren);
    }

    /**
     * Method under test: {@link DummyService#saveDummy(Dummy)}
     */
    @Test
    void testSaveDummy() {
        Dummy dummy = new Dummy();
        ArrayList<Child> childList = new ArrayList<>();
        dummy.setChildList(childList);
        dummy.setComment("Comment");
        dummy.setDummyId(1L);
        dummy.setName("Name");
        dummy.setText("Text");
        when(dummyRepository.save(Mockito.any())).thenReturn(dummy);

        Dummy dummy2 = new Dummy();
        dummy2.setChildList(new ArrayList<>());
        dummy2.setComment("Comment");
        dummy2.setDummyId(1L);
        dummy2.setName("Name");
        dummy2.setText("Text");
        dummyService.saveDummy(dummy2);
        verify(dummyRepository).save(Mockito.any());
        assertEquals("Comment", dummy2.getComment());
        assertEquals("Name", dummy2.getName());
        assertEquals("Text", dummy2.getText());
        assertEquals(1L, dummy2.getDummyId().longValue());
        assertEquals(childList, dummy2.getChildList());
    }

    /**
     * Method under test: {@link DummyService#deleteDummy(Long)}
     */
    @Test
    void testDeleteDummy() {
        doNothing().when(dummyRepository).deleteById(Mockito.<Long>any());
        dummyService.deleteDummy(1L);
        verify(dummyRepository).deleteById(Mockito.<Long>any());
    }
}
