package com.sptech.apikraken.utils.interfaces;

public interface IService<P, R> {

    R create(P object);
    Boolean delete(Integer id);

}
