package com.sptech.apikraken.service;

public interface NotificationService<T, S> {

    void notificate(T list, S object);

}
