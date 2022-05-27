package com.sptech.apikraken.useCases.ngos;

import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterNGOValidateUseCase implements IUseCase<NGO, NGO> {

    @Autowired
    private INGORepository iNgoRepository;

    @Override
    public NGO execute(NGO ngo) {
        List<NGO> userValid = iNgoRepository.findByCnpj(ngo.getCnpj());

        if (userValid.isEmpty() || userValid.get(0).getId().equals(ngo.getId())) {

            return iNgoRepository.save(ngo);

        }

        return null;
    }

}
