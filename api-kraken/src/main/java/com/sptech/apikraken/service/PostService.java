package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.post.PostDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.Post;
import com.sptech.apikraken.list.ListaObj;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.IPostRepository;
import com.sptech.apikraken.utils.interfaces.IService;
import com.sptech.apikraken.utils.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IService<PostDTO, Post>, NotificationService<List<Donor>, Post> {

    @Autowired
    private IPostRepository iPostRepository;
    @Autowired
    private IDonorRepository iDonorRepository;

    @Autowired
    private IDonorRepository iNGORepository;

    @Override
    public Post create(PostDTO post) {

        try {

            Post postagem = iPostRepository.save(new Post(post));

            System.out.println(postagem);

//            if (postagem.getNgo().getFollowers().size() > 0) {
//                this.notificate(postagem.getNgo().getFollowers(), postagem);
//            }

            return postagem;

        } catch (Exception e) {
            throw new Error("Error-create-post: " + e);
        }

    }

    public ListaObj<Post> getAll() {
        return new ListaObj<Post>(iPostRepository.findAll());
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public void notificate(List<Donor> list, Post postagem) {
        for (Donor donor: list) {
            donor.getNotifications().add(postagem);
            try {
                iDonorRepository.updateNotifications(donor.getId(), donor.getNotifications());
            } catch (Exception e) {
                throw new Error("Error-update-notifications");
            }
        }
    }

    public List<Post> getByPublisherId(Integer id) {

        return iPostRepository.findAllByNgoId(id);

    }

}
