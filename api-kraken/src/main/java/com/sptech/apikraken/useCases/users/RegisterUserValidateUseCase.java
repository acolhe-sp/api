package com.sptech.apikraken.useCases.users;

import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserValidateUseCase implements IUseCase<User, User> {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User execute(User user) {

        List<User> userValid = iUserRepository.findByEmail(user.getEmail());

        if (userValid.isEmpty() || userValid.get(0).getId().equals(user.getId())) {

            iUserRepository.save(user);
            return user;

        }

        return null;
    }

}
