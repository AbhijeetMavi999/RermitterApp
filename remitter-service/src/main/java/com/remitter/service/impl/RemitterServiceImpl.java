package com.remitter.service.impl;

import com.remitter.entity.Remitter;
import com.remitter.exception.RemitterAlreadyExistException;
import com.remitter.exception.RemitterNotFoundException;
import com.remitter.repository.RemitterRepository;
import com.remitter.service.RemitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class RemitterServiceImpl implements RemitterService {

    @Autowired
    private RemitterRepository remitterRepository;

    @Override
    public Remitter registerRemitter(Remitter remitter) {
        log.info("registerRemitter() method of RemitterServiceImpl is called");
        Remitter isAlreadyExist = remitterRepository.findByEmailId(remitter.getEmailId());
        if(isAlreadyExist != null) {
            log.warn("Remitter already exist by email "+remitter.getEmailId());
            throw new RemitterAlreadyExistException("Remitter already exist by email "+remitter.getEmailId());
        }
        Remitter registeredRemitter = remitterRepository.save(remitter);
        return registeredRemitter;
    }

    @Override
    public Remitter getRemitterByEmailAndPassword(String emailId, String password) {
        log.info("getRemitterByEmailAndPassword() method of RemitterServiceImpl is called");
        Remitter remitter = remitterRepository.findByEmailIdAndPassword(emailId, password);
        if(remitter == null) {
            log.warn("Remitter by EmailId: "+emailId+" and by Password: "+password+" is not found");
            throw new RemitterNotFoundException("Remitter by EmailId: "+emailId+" and by Password: "+password+" is not found");
        }
        return remitter;
    }

    @Override
    public List<Remitter> getAllRemitters() {
        log.info("getAllRemitters() method of RemitterServiceImpl is called");
        List<Remitter> remitters = remitterRepository.findAll();
        if(remitters == null) {
            log.warn("Remitters not found");
            throw new RemitterNotFoundException("Remitters not found");
        }
        return remitters;
    }
}
