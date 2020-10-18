package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PEOPLE")
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="EMAIL")       private String email;
    @Column(name="FIRST_NAME")  private String firstName;
    @Column(name="LAST_NAME")   private String lastName;
    @Column(name="BIRTH_DATE")  private LocalDate birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
