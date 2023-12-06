package com.example.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.testing.entity.Child;
import com.example.testing.entity.Dummy;
import com.example.testing.repo.DummyRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DummyService.class})
@ExtendWith(SpringExtension.class)
class DummyServiceDiffblueTest {
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
        when(dummyRepository.save(Mockito.<Dummy>any())).thenReturn(dummy);

        Dummy dummy2 = new Dummy();
        dummy2.setChildList(new ArrayList<>());
        dummy2.setComment("Comment");
        dummy2.setDummyId(1L);
        dummy2.setName("Name");
        dummy2.setText("Text");
        dummyService.saveDummy(dummy2);
        verify(dummyRepository).save(Mockito.<Dummy>any());
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
