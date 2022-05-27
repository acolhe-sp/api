package com.sptech.apikraken.useCases.donors;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterDonorValidateUseCase implements IUseCase<Donor, Donor> {

    @Autowired
    private IDonorRepository iDonorRepository;

    @Override
    public Donor execute(Donor donor) {

        List<Donor> userValid = iDonorRepository.findByCpf(donor.getCpf());

        if (userValid.isEmpty() || userValid.get(0).getId().equals(donor.getId())) {
            return iDonorRepository.save(donor);
        }
        return null;
    }

}
