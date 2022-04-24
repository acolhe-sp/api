package com.sptech.apikraken.useCases.donors;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDonorValidateUseCase implements IUseCase<Donor, Donor> {

    @Autowired
    private IDonorRepository iDonorRepository;

    @Override
    public Donor execute(Donor donor) {

        if (iDonorRepository.findByCpf(donor.getCpf()).isEmpty()) {

            return iDonorRepository.save(donor);

        }
        return null;
    }

}
