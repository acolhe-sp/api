package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.ngo.NgoDTO;
import com.sptech.apikraken.dto.response.ngo.NGOComplete;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.utils.list.ListaObj;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.ngos.RegisterNGOValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import com.sptech.apikraken.utils.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;

@Service
public class NGOService implements IService<NgoDTO, NGO> {

    @Autowired private INGORepository iNGORepository;
    @Autowired private IUserRepository iUserRepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterNGOValidateUseCase registerNGOValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;

    @Override
    public NGO create(NgoDTO ngo) {

        User userRegister = null;

        try {
            Address newAddress = null;
            if (ngo.getUser().getAddressDTO().getId() != null) {
                newAddress = new Address(
                    ngo.getUser().getAddressDTO().getId(),
                    ngo.getUser().getAddressDTO().getState(),
                    ngo.getUser().getAddressDTO().getCity(),
                    ngo.getUser().getAddressDTO().getDistrict(),
                    ngo.getUser().getAddressDTO().getCep(),
                    ngo.getUser().getAddressDTO().getStreet(),
                    ngo.getUser().getAddressDTO().getNumber(),
                    ngo.getUser().getAddressDTO().getComplement()
                );
            } else {
                newAddress = new Address(
                    ngo.getUser().getAddressDTO().getState(),
                    ngo.getUser().getAddressDTO().getCity(),
                    ngo.getUser().getAddressDTO().getDistrict(),
                    ngo.getUser().getAddressDTO().getCep(),
                    ngo.getUser().getAddressDTO().getStreet(),
                    ngo.getUser().getAddressDTO().getNumber(),
                    ngo.getUser().getAddressDTO().getComplement()
                );
            }

            User newUser = null;
            if (ngo.getUser().getId() != null) {
                newUser = new User(
                    ngo.getUser().getId(),
                    ngo.getUser().getImg(),
                    ngo.getUser().getName(),
                    ngo.getUser().getEmail(),
                    ngo.getUser().getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    ngo.getUser().getUserType(),
                    ngo.getUser().isConnect()
                );
            } else {
                newUser = new User(
                    ngo.getUser().getImg(),
                    ngo.getUser().getName(),
                    ngo.getUser().getEmail(),
                    ngo.getUser().getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    ngo.getUser().getUserType(),
                    ngo.getUser().isConnect()
                );
            }

            userRegister = this.registerUserValidateUseCase.execute(newUser);

            if (userRegister != null) {
                NGO newNGO = null;
                if (ngo.getId() != null) {
                    newNGO = new NGO(
                        ngo.getId(),
                        ngo.getCnpj(),
                        ngo.getDescription(),
                        ngo.getCategory(),
                        userRegister,
                        ngo.getAssessment()
                    );
                } else {
                    newNGO = new NGO(
                        ngo.getCnpj(),
                        ngo.getDescription(),
                        ngo.getCategory(),
                        userRegister,
                        ngo.getAssessment()
                    );
                }

                return this.registerNGOValidateUseCase.execute(newNGO);

            }

        } catch (Exception e) {
            throw new Error("NGOService - Erro ao registrar usuário");
        }

        return null;
    }

    public NGO update(Integer id, NgoDTO newNGO) {

        if (iNGORepository.existsById(id)) {
            newNGO.setId(id);
            return this.create(newNGO);
        };

        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        if (iNGORepository.existsById(id)) {

            NGO ngo = iNGORepository.getById(id);

            iUserRepository.deleteById(ngo.getUser().getId());
            iNGORepository.deleteById(id);

            return true;
        }
        return false;
    }

    public ListaObj<NGO> getAll() {
        return new ListaObj<NGO>(iNGORepository.findAll());
    }

    public NGOComplete getById(Integer id) {
        if (!iNGORepository.existsById(id)) return null;

        return iNGORepository.getNGOCompleteById(id);
    }

    public List<NGOComplete> getAllComplete() {

        List<NGOComplete> ngos = iNGORepository.consultaNGOComplete();

        for (NGOComplete ngo: ngos) {

            byte[] decoded = Base64Utils.decode(ngo.getImg() != null ? ngo.getImg() : new byte[]{});

            ngo.setImg(decoded);

        }

        return ngos;
    }

    public List<NGOComplete> listNGOsByCategoria(Integer id) {

        return iNGORepository.consultaNGOCompletePelaCategory(id);

    }
}
