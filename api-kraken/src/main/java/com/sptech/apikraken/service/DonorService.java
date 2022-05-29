package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.donor.DonorDTO;
import com.sptech.apikraken.dto.request.donor.UpdateDocumentsDonorDTO;
import com.sptech.apikraken.entity.*;
import com.sptech.apikraken.entity.keys.FollowKey;
import com.sptech.apikraken.list.ListaObj;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.IFollowDonorNGORepository;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.donors.RegisterDonorValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import com.sptech.apikraken.utils.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService implements IService<DonorDTO, Donor> {

    @Autowired private IDonorRepository iDonorRepository;

    @Autowired private INGORepository ingoRepository;

    @Autowired private IFollowDonorNGORepository followReposotory;

    @Autowired private IUserRepository iUserRepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterDonorValidateUseCase registerDonorValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;


    @Override
    public Donor create(DonorDTO donor) {

        User userRegister = null;

        try {
            Address newAddress = null;
            if (donor.getUser().getAddressDTO().getId() != null) {
                newAddress = new Address(
                    donor.getUser().getAddressDTO().getId(),
                    donor.getUser().getAddressDTO().getState(),
                    donor.getUser().getAddressDTO().getCity(),
                    donor.getUser().getAddressDTO().getDistrict(),
                    donor.getUser().getAddressDTO().getCep(),
                    donor.getUser().getAddressDTO().getStreet(),
                    donor.getUser().getAddressDTO().getNumber(),
                    donor.getUser().getAddressDTO().getComplement()
                );
            } else {
                newAddress = new Address(
                    donor.getUser().getAddressDTO().getState(),
                    donor.getUser().getAddressDTO().getCity(),
                    donor.getUser().getAddressDTO().getDistrict(),
                    donor.getUser().getAddressDTO().getCep(),
                    donor.getUser().getAddressDTO().getStreet(),
                    donor.getUser().getAddressDTO().getNumber(),
                    donor.getUser().getAddressDTO().getComplement()
                );
            }

            User newUser = null;
            if (donor.getUser().getId() != null) {
                newUser = new User(
                    donor.getUser().getId(),
                    donor.getUser().getImg(),
                    donor.getUser().getName(),
                    donor.getUser().getEmail(),
                    donor.getUser().getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    donor.getUser().getUserType(),
                    donor.getUser().isConnect()
                );
            } else {
                newUser = new User(
                    donor.getUser().getImg(),
                    donor.getUser().getName(),
                    donor.getUser().getEmail(),
                    donor.getUser().getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    donor.getUser().getUserType(),
                    donor.getUser().isConnect()
                );
            }

            userRegister = this.registerUserValidateUseCase.execute(newUser);

            if (userRegister != null) {

                Donor newDonor = null;
                if (donor.getId() != null) {
                    newDonor = new Donor(
                        donor.getId(),
                        donor.getRg(),
                        donor.getCpf(),
                        userRegister,
                        donor.getNotifications()
                    );
                } else {
                    newDonor = new Donor(
                            donor.getRg(),
                            donor.getCpf(),
                            userRegister,
                            donor.getNotifications()
                    );
                }

                return this.registerDonorValidateUseCase.execute(newDonor);

            }

        } catch (Exception e) {
            throw new Error("DonorService - Erro ao registrar usuário: "+e.getMessage());
        }

        return null;
    }

    public Donor update(Integer id, DonorDTO newDonor) {
        if (iDonorRepository.existsById(id)) {
            newDonor.setId(id);
            return this.create(newDonor);
        };

        return null;
    }

    public Boolean updateDocs(Integer id, UpdateDocumentsDonorDTO newDocs) {
        if (iDonorRepository.existsById(id)) {

            iDonorRepository.updateDocuments(id, newDocs.getCpf(), newDocs.getRg());
            return true;

        };
        return false;
    }

    public Boolean turnFollowState(Integer id, Integer idOng) {
        if (iDonorRepository.existsById(id) && ingoRepository.existsById(id)) {

            boolean existFollow = followReposotory.existsById(new FollowKey(id, idOng));

            if (existFollow) {
                followReposotory.deleteById(new FollowKey(id, idOng));
                return false;
            } else {
                followReposotory.save(
                    new FollowDonorNGO(
                        new FollowKey(id, idOng),
                        iDonorRepository.findById(id).get(),
                        ingoRepository.findById(idOng).get()
                    )
                );
                return true;
            }
        } else {
            throw new IllegalArgumentException("Id Donor ou Id Ong inválidos");
        }
    }

    public Boolean checkFollowState(Integer id, Integer idOng) {
        if (iDonorRepository.existsById(id) && ingoRepository.existsById(id)) {

            return followReposotory.existsById(new FollowKey(id, idOng));

        } else {
            throw new IllegalArgumentException("Id Donor ou Id Ong inválidos");
        }
    }

    @Override
    public Boolean delete(Integer id) {
        if (iDonorRepository.existsById(id)) {

            Donor donor = iDonorRepository.getById(id);

            iDonorRepository.deleteById(id);
            iUserRepository.deleteById(donor.getUser().getId());

            return true;
        }
        return false;
    }

    public ListaObj<Donor> getAll() {
        return new ListaObj<Donor>(iDonorRepository.findAll());
    }

    public Donor getById(Integer id) {
        if (!iDonorRepository.existsById(id)) return null;

        return iDonorRepository.findById(id).get();
    }

}
