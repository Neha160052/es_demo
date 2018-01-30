package tv.videoready.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "javasampleapproach", type = "customer")
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private int age;

    public Customer(){
    }

    public Customer(String id, String firstname, String lastname, int age){
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
    }

    public void setFirstName(String firstname){
        this.firstName = firstname;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastname){
        this.lastName = lastname;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        String info = String.format("Customer Info: id = %s, firstname = %s, lastname = %s, age = %d", id, firstName, lastName, age);
        return info;
    }
}
