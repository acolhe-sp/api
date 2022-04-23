package com.sptech.apikraken.useCases.users;

import com.sptech.apikraken.dto.response.PayloadRetornoLogon;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogonUserValidateUseCase implements IUseCase<User, PayloadRetornoLogon> {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public PayloadRetornoLogon execute(User user) {


        return new PayloadRetornoLogon();

    }

}
