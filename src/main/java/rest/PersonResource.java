package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonsDTO;
import facades.PersonFacade;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;

@Path("/pers")
public class PersonResource
{
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

//    @Path("/hello-world")
//    @GET
//    @Produces("text/plain")
    //    PersonDTO addPerson(String fName, String lName, String phone);

    //    PersonDTO deletePerson(int id);

    //    PersonDTO getPerson(int id);

    //    PersonsDTO getAllPersons();

    //    PersonDTO editPerson(PersonDTO p);



    @GET
    @Produces("text/plain")
    public String hello()
    {
        return "Hello, World!";
    }

    @GET
    @Path("/all")
    @Produces("application/JSON")
    public String allPersons() {
        PersonsDTO persons = new PersonsDTO(FACADE.getAllPersons());
        return GSON.toJson(persons);
    }


}