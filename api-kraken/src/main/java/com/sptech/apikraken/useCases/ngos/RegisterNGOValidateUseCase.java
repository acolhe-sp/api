package com.sptech.apikraken.useCases.ngos;

import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterNGOValidateUseCase implements IUseCase<NGO, NGO> {

    @Autowired
    private INGORepository iNgoRepository;

    @Override
    public NGO execute(NGO ngo) {
        try {

            if(!iNgoRepository.findByCnpj(ngo.getCnpj()).isEmpty()) throw new Error("WARN-validation-cnpj-exist");

            return iNgoRepository.save(ngo);

        } catch (Exception e) {
            throw new Error("Error-save-ngo: "+e);
        }
    }

}
