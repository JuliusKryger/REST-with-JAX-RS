package entities;

import javax.persistence.*;
import java.util.Date;

@Table(name = "person")
@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private Date created;
    private Date lastEdited;

    public Person(String firstName, String lastName, String phone, Date created, Date lastEdited)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.created = created;
        this.lastEdited = lastEdited;
    }

    public Person()
    {
    }

    public Person(String firstName, String lastName, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getLastEdited()
    {
        return lastEdited;
    }

    public void setLastEdited(Date lastEdited)
    {
        this.lastEdited = lastEdited;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}