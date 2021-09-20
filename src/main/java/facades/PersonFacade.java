package facades;

import dtos.PersonDTO;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade implements IPersonFacade
{
    private static EntityManagerFactory emf;
    private static PersonFacade instance;

    //Private Constructor to ensure Singleton
    private PersonFacade ()
    {
    }

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public PersonDTO addPerson(String fName, String lName, String phone)
    {
        EntityManager em = emf.createEntityManager();
        PersonDTO stupidPerson;
        stupidPerson = new PersonDTO(new Person(fName,lName,phone));
        try
        {
            em.getTransaction().begin();
            em.persist(stupidPerson);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        return stupidPerson;
    }

    @Override
    public PersonDTO deletePerson(int id)
    {
        return null;
    }

    @Override
    public PersonDTO getPerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            PersonDTO stupidPerson = em.find(PersonDTO.class, id);
            return stupidPerson;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getAllPersons()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Person> query = em.createQuery("Select person from Person person",Person.class);
            return query.getResultList();
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public PersonDTO editPerson(PersonDTO p)
    {
        return null;
    }
}
