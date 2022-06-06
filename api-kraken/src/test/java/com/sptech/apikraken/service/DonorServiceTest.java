package com.sptech.apikraken.service;

import com.sptech.apikraken.controllers.DonorController;
import com.sptech.apikraken.dto.request.donor.DonorDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.utils.list.ListaObj;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DonorService.class})
@RunWith(MockitoJUnitRunner.class)
class DonorServiceTest {
    @MockBean
    DonorService service;
    @Test
    void createComDadosValidos() {
        DonorDTO donor = mock(DonorDTO.class);
        when(service.create(donor)).thenReturn(mock(Donor.class));

        Donor teste = service.create(donor);

        assertNotNull(teste);
    }

    @Test
    void createComDadosInvalidos() {
        DonorDTO donorInvalido = mock(DonorDTO.class);
        when(service.create(donorInvalido)).thenReturn(null);

        Donor teste = service.create(donorInvalido);

        assertNull(teste);
    }

    @Test
    void getAll() {
        Donor donor1 = mock(Donor.class);
        Donor donor2 = mock(Donor.class);
        Donor donor3 = mock(Donor.class);

        ListaObj<Donor> lista = new ListaObj<>(10);
        lista.adiciona(donor1);
        lista.adiciona(donor2);
        lista.adiciona(donor3);

        when(service.getAll()).thenReturn(lista);

        ListaObj<Donor> teste = service.getAll();

        assertNotNull(teste.getElemento(0));
        assertNotNull(teste.getElemento(1));
        assertNotNull(teste.getElemento(2));
        assertNull(teste.getElemento(3));
        assertEquals(3, teste.getTamanho());
    }
}