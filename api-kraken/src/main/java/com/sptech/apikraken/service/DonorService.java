package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.donor.DonorDTO;
import com.sptech.apikraken.dto.request.donor.UpdateDocumentsDonorDTO;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.list.ListaObj;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.donors.RegisterDonorValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import com.sptech.apikraken.utils.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService implements IService<DonorDTO, Boolean> {

    @Autowired
    private IDonorRepository iDonorRepository;
    @Autowired private IUserRepository iUserRepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterDonorValidateUseCase registerDonorValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;


    @Override
    public Boolean create(DonorDTO donor) {

        User userRegister = null;

        try {
            Address newAddress = new Address(
                    donor.getAddressDTO().getState(),
                    donor.getAddressDTO().getDistrict(),
                    donor.getAddressDTO().getCep(),
                    donor.getAddressDTO().getStreet(),
                    donor.getAddressDTO().getNumber(),
                    donor.getAddressDTO().getComplement()
            );

            User newUser = new User(
                    donor.getImg(),
                    donor.getName(),
                    donor.getEmail(),
                    donor.getPassword(),
                    this.registerAddressUseCase.execute(newAddress),
                    donor.getUserType(),
                    donor.isConnect()
            );

            userRegister = this.registerUserValidateUseCase.execute(newUser);

            if (userRegister != null) {

                Donor newDonor = new Donor(donor.getRg(), donor.getCpf(), userRegister);

                return this.registerDonorValidateUseCase.execute(newDonor);

            }

        } catch (Exception e) {
            throw new Error("DonorService - Erro ao registrar usuário");
        }

        return false;
    }

    public Boolean update(Integer id, DonorDTO newDonor) {
        if (iDonorRepository.existsById(id)) {
            newDonor.setId(id);
            return this.create(newDonor);
        };

        return false;
    }

    public Boolean updateDocs(Integer id, UpdateDocumentsDonorDTO newDocs) {
        if (iDonorRepository.existsById(id)) {

            iDonorRepository.updateDocumentos(id, newDocs.getCpf(), newDocs.getRg());
            return true;

        };
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        if (iDonorRepository.existsById(id)) {
            iDonorRepository.deleteById(id);
            iUserRepository.deleteById(id);

            return true;
        }
        return false;
    }

    public ListaObj<Donor> getAll() {
        return new ListaObj<Donor>(iDonorRepository.findAll());
    }

}
