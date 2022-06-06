package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.post.PostDTO;
import com.sptech.apikraken.dto.response.post.PostAnalyticsPerfilNGO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.Post;
import com.sptech.apikraken.repository.ILikeDonorPostRepository;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.utils.list.ListaObj;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.IPostRepository;
import com.sptech.apikraken.utils.interfaces.IService;
import com.sptech.apikraken.utils.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IService<PostDTO, Post>, NotificationService<List<Donor>, Post> {

    @Autowired private IPostRepository iPostRepository;
    @Autowired private IDonorRepository iDonorRepository;
    @Autowired private ILikeDonorPostRepository iLikesPosts;

    @Autowired private INGORepository iNGORepository;

    @Override
    public Post create(PostDTO post) {

        try {

            Post postagem = iPostRepository.save(new Post(post));

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
        try {

            iPostRepository.deleteById(id);

            return true;

        } catch (Exception e) {
            System.out.println("erro ao deletar: "+e);
            return false;
        }
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

        return iPostRepository.findAllByNgoIdOrderByIdDesc(id);

    }

    public PostAnalyticsPerfilNGO getAnalyticsPostsPublisher(Integer idNGO, List<Post> list) {

        double count = iLikesPosts.countByPostNgoId(idNGO).doubleValue();

        double mediaLikes = count / list.size();

        return new PostAnalyticsPerfilNGO(
                list.size(),
                list,
                mediaLikes
        );

    }

}
