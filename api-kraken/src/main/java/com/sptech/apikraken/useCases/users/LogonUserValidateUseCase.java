package com.sptech.apikraken.useCases.users;

import com.sptech.apikraken.dto.PayloadRetornoLogon;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class LogonUserValidateUseCase implements IUseCase<User, PayloadRetornoLogon> {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public PayloadRetornoLogon execute(User user) {


        return new PayloadRetornoLogon();

    }

}
