package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.ngo.NgoDTO;
import com.sptech.apikraken.dto.request.ngo.UpdateDescriptionNgoDTO;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.Donor;
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

        return null;
    }

    public Boolean update(Integer id, NgoDTO newNGO) {

        if (iNGORepository.existsById(id)) {

            try {

                newNGO.setId(id);
                this.create(newNGO);

            } catch(Exception e) {
                throw new Error("Erro ao atualizar"+e);
            }

        }
        return false;
    }

    public Boolean updateDescription(UpdateDescriptionNgoDTO newDesc) {

        if (iNGORepository.existsById(newDesc.getId())) {
            try {

                iNGORepository.updateDescription(newDesc.getId(), newDesc.getDescription());
                return true;

            } catch(Exception e) {
                throw new Error("NGOService - Erro ao atualizar descrição: "+e);
            }
        }
        return false;
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
}
