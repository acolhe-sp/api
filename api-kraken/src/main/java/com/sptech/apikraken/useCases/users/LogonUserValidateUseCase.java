package com.sptech.apikraken.useCases.users;

import com.sptech.apikraken.dto.response.PayloadRetornoLogon;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogonUserValidateUseCase {

    @Autowired
    private IUserRepository iUserRepository;

    public PayloadRetornoLogon execute(User user, Donor donor) {
        return new PayloadRetornoLogon(user, donor, true);
    }

    public PayloadRetornoLogon execute(User user, NGO ngo) {
        return new PayloadRetornoLogon(user, ngo, true);
    }

}
