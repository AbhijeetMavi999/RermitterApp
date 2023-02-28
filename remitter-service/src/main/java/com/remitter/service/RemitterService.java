package com.remitter.service;

import com.remitter.entity.Remitter;

import java.util.List;

public interface RemitterService {

    public Remitter registerRemitter(Remitter remitter);

    public Remitter getRemitterByEmailAndPassword(String emailId, String password);

    List<Remitter> getAllRemitters();
}
