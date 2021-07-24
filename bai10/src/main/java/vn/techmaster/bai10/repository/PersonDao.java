package vn.techmaster.bai10.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import vn.techmaster.bai10.entity.Person;

public class PersonDao extends Dao<Person> {
    public PersonDao() {
        collections = new ArrayList<>();

    }

    @Override
    public List<Person> getAll() {
        // TODO Auto-generated method stub
        return collections;
    }

    @Override
    public Optional<Person> get(int id) {
        // TODO Auto-generated method stub
        return collections.stream().filter(p -> p.getId()==id).findFirst();
    }

    @Override
    public void add(Person person) {
        // TODO Auto-generated method stub
        int id; 
        if(collections.isEmpty()) {
            id = 1 ;
        }else{
            Person lastPerson = collections.get(collections.size()-1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        collections.add(person);
    }

    @Override
    public void update(Person person) {
        // TODO Auto-generated method stub
        get(person.getId()).ifPresent(existPerson -> {
            existPerson.setName(person.getName());
            existPerson.setJob(person.getJob());
            existPerson.setGender(person.getGender());
            existPerson.setBirthDate(person.getBirthDate());
            existPerson.setPhoto(person.getPhoto());
        });
    }

    @Override
    public void delete(Person person) {
        // TODO Auto-generated method stub
        deleteById(person.getId());
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        get(id).ifPresent(existPerson -> collections.remove(existPerson));
    }

  
}
