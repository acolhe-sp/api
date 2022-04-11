package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.NgoDTO;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.list.ListaObj;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.ngos.RegisterNGOValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import com.sptech.apikraken.utils.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NGOService implements IService<NgoDTO, Boolean> {

    @Autowired private INGORepository iNGORepository;
    @Autowired private IUserRepository iUserRepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterNGOValidateUseCase registerNGOValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;

    @Override
    public Boolean create(NgoDTO ngo) {

        User userRegister = null;

        try {

            Address newAddress = new Address(
                    ngo.getAddressDTO().getState(),
                    ngo.getAddressDTO().getDistrict(),
                    ngo.getAddressDTO().getCep(),
                    ngo.getAddressDTO().getStreet(),
                    ngo.getAddressDTO().getNumber(),
                    ngo.getAddressDTO().getComplement()
            );

            User newUser = new User(
                    ngo.getImg(),
                    ngo.getName(),
                    ngo.getEmail(),
                    ngo.getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    ngo.getUserType(),
                    ngo.isConnect()
            );

            userRegister = this.registerUserValidateUseCase.execute(newUser);

            if (userRegister != null) {

                NGO newNGO = new NGO(ngo.getCnpj(), ngo.getDescription(), ngo.getCategory(), userRegister);

                return this.registerNGOValidateUseCase.execute(newNGO);

            }

        } catch (Exception e) {
            throw new Error("NGOService - Erro ao registrar usuário");
        }

        return false;
    }

    @Override
    public Boolean update(Integer id, NgoDTO newNGO) {

        if (iNGORepository.existsById(id)) {

            try {

                newNGO.setId(id);
                this.create(newNGO);

            } catch(Exception e) {

            }

        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {

        if (iNGORepository.existsById(id)) {
            iNGORepository.deleteById(id);
            iUserRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public ListaObj<NGO> getAll() {

        return (ListaObj<NGO>) iNGORepository.findAll();
    }
}
