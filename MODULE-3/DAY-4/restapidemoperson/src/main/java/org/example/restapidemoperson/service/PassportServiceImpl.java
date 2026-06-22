package org.example.restapidemoperson.service;


import org.example.restapidemoperson.dao.PersonDao;
import org.example.restapidemoperson.model.Passport;
import org.example.restapidemoperson.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PassportServiceImpl {
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private PersonDao personDao;
    public Passport addPassport(Passport passport){
        Person person=passport.getPerson();
        personDao.save(person);
        return passportRepository.save(passport);
    }
    public List<Passport> getAll(){
        return passportRepository.findAll();
    }
}