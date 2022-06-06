package service;

import com.sptech.apikraken.dto.request.ngo.NgoDTO;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.utils.list.ListaObj;
import com.sptech.apikraken.service.NGOService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {NGOService.class})
class NGOServiceTest {

    @MockBean
    NGOService service;
    @Test
    void createComDadosValidos() {
        NgoDTO ong = mock(NgoDTO.class);
        when(service.create(ong)).thenReturn(mock(NGO.class));

        NGO teste = service.create(ong);

        assertNotNull(teste);
    }

    @Test
    void createComDadosInvalidos() {
        NgoDTO ong = mock(NgoDTO.class);
        when(service.create(ong)).thenReturn(null);

        NGO teste = service.create(ong);

        assertNull(teste);
    }

    @Test
    void getAll() {
        NGO ong1 = mock(NGO.class);
        NGO ong2 = mock(NGO.class);

        ListaObj<NGO> lista = new ListaObj<>(10);
        lista.adiciona(ong1);
        lista.adiciona(ong2);

        when(service.getAll()).thenReturn(lista);

        ListaObj<NGO> teste = service.getAll();

        assertNotNull(teste.getElemento(0));
        assertNotNull(teste.getElemento(1));
        assertNull(teste.getElemento(2));
        assertEquals(2, teste.getTamanho());
    }
}