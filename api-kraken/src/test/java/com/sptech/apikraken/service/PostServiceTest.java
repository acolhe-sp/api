package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.ngo.NgoDTO;
import com.sptech.apikraken.dto.request.post.PostDTO;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.Post;
import com.sptech.apikraken.utils.list.ListaObj;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PostService.class)
class PostServiceTest {

    @MockBean
    PostService service;
    @Test
    void createComDadosValidos() {
        PostDTO post = mock(PostDTO.class);
        when(service.create(post)).thenReturn(mock(Post.class));

        Post teste = service.create(post);

        assertNotNull(teste);
    }

    @Test
    void createComDadosInvalidos() {
        PostDTO postagem = mock(PostDTO.class);
        when(service.create(postagem)).thenReturn(null);

        Post teste = service.create(postagem);

        assertNull(teste);
    }

    @Test
    void getAll() {
        Post postagem1 = mock(Post.class);
        Post postagem2 = mock(Post.class);
        ListaObj<Post> lista = new ListaObj<>(5);
        lista.adiciona(postagem1);
        lista.adiciona(postagem2);

        when(service.getAll()).thenReturn(lista);
        ListaObj<Post> teste = service.getAll();

        assertNotNull(teste.getElemento(0));
        assertNotNull(teste.getElemento(1));
        assertNull(teste.getElemento(2));
        assertEquals(2, teste.getTamanho());
    }

    @Test
    void deleteCenarioValido() {
        Post postagem1 = mock(Post.class);
        Post postagem2 = mock(Post.class);
        Post postagem3 = mock(Post.class);

        ListaObj<Post> lista = new ListaObj<>(5);

        lista.adiciona(postagem1);
        lista.adiciona(postagem2);
        lista.adiciona(postagem3);

        when(service.delete(postagem1.getId())).thenReturn(lista.removeElemento(postagem1));
        assertEquals(2, lista.getTamanho());

        when(service.delete(postagem2.getId())).thenReturn(lista.removeElemento(postagem2));
        assertEquals(1, lista.getTamanho());

        when(service.delete(postagem3.getId())).thenReturn(lista.removeElemento(postagem3));
        assertEquals(0, lista.getTamanho());
    }
}