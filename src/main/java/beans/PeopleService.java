package beans;

import entities.Person;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class PeopleService {
    @EJB
    private PeopleRepository peopleRepository;

    public void addPerson(Person person){
        peopleRepository.savePerson(person);
    }

    public void deletePerson(Person person){
        peopleRepository.deletePerson(person);
    }

    public List<Person> getAllPeople(){
        return peopleRepository.getAllPeople();
    }
}
