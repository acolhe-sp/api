package com.sptech.apikraken.useCases.ngos;

import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterNGOValidateUseCase implements IUseCase<NGO, Boolean> {

    @Autowired
    private INGORepository iNgoRepository;

    @Override
    public Boolean execute(NGO ngo) {

        if(iNgoRepository.findByCnpj(ngo.getCnpj()).isEmpty()) {

            iNgoRepository.save(ngo);
            return true;

        }

        return false;

    }

}
