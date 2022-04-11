package com.sptech.apikraken.utils.interfaces;

public interface IUseCase<P, R> {

    R execute(P parametros);

}
