package com.sptech.apikraken.useCases.donors;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDonorValidateUseCase implements IUseCase<Donor, Boolean> {

    @Autowired
    private IDonorRepository iDonorRepository;

    @Override
    public Boolean execute(Donor donor) {

        if (iDonorRepository.findByCpf(donor.getCpf()).isEmpty()) {

            iDonorRepository.save(donor);
            return true;

        }

        return false;
    }


}
