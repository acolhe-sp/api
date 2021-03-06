package com.sptech.apikraken.useCases.addresses;

import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.repository.IAddressRepository;
import com.sptech.apikraken.utils.interfaces.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterAddressUseCase implements IUseCase<Address, Address> {

    @Autowired
    private IAddressRepository iAddressRepository;

    @Override
    public Address execute(Address address) {
        System.out.println("entrou ad");

        try {
            return iAddressRepository.save(address);
        } catch (Exception e) {
            throw new Error("Error-register-address");
        }
    }
}
