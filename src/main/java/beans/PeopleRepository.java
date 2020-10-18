package beans;

import entities.Person;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class PeopleRepository {
    @PersistenceContext(unitName = "PEOPLE_PU")
    private EntityManager em;

    public List<Person> getAllPeople(){
        return em.createQuery("select p from Person p").getResultList();
    }

    public void savePerson(Person person){
        em.persist(person);
    }

    public void deletePerson(Person person){
        em.remove(person);
    }
}
