package com.sptech.apikraken.service;

public interface IService<P, R> {

    R create(P object);
    R update(Integer id, P newObject);
    R delete(Integer id);

}
