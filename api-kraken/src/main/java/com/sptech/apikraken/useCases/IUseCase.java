package com.sptech.apikraken.useCases;

public interface IUseCase<P, R> {

    R execute(P parametros);

}
