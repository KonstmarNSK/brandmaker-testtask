package controllers;

import beans.PeopleService;
import entities.Person;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Singleton
@Path("/api")
public class PeopleRestController {
    @EJB
    private PeopleService peopleService;

    @POST
    @Path("/create-person")
    public void createPerson(@FormParam("name") String name, @FormParam("last-name") String lastName,
                             @FormParam("email") String email, @FormParam("birthdate") String strBirthdate){

        LocalDate birtDate = LocalDate.parse(strBirthdate, DateTimeFormatter.ISO_LOCAL_DATE);
        Person person = new Person();

        person.setFirstName(name);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setBirthDate(birtDate);

        peopleService.addPerson(person);
    }

    @GET
    @Path("/get-all-people")
    public List<Person> getAllPeople(){
        return peopleService.getAllPeople();
    }

    @GET
    @Path("/delete-person")
    public void deletePerson(@QueryParam("person-id") long personID){
        Person person = new Person();
        person.setId(personID);

        peopleService.deletePerson(person);
    }
}
