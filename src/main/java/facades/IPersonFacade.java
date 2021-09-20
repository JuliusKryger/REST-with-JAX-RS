package facades;

import dtos.PersonDTO;
import entities.Person;

import java.util.List;

public interface IPersonFacade
{
    //
    PersonDTO addPerson(String fName, String lName, String phone);

    //
    PersonDTO deletePerson(int id);

    //
    PersonDTO getPerson(int id);

    //
    List<Person> getAllPersons();

    //
    PersonDTO editPerson(PersonDTO p);
}
