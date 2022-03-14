package com.sptech.apikraken.useCases.users;

import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserValidateUseCase implements IUseCase<User, User> {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User execute(User user) {

        if (iUserRepository.findByEmail(user.getEmail()).isEmpty()) {
            return iUserRepository.save(user);
        }

        return null;
    }

}
