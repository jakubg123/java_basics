package classes;
import java.util.ArrayList;


import java.sql.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Person p = new Person("Jan Kowalski", "12345678901");
        Person p1 = new Person("Anna Nowak", "23456789012");
        Person n = new Nurse("Jakub", "Gniadek", "2323", true);
        Staff s = new OfficeStaff("aa","aa","aa");
        Person sm = new Doctor("aaa", "bbb", "sadsa",true);


       ArrayList<Person> persons = new ArrayList();

       persons.add(p);
       persons.add(p1);
       persons.add(n);

        for(Person obj : persons){
            System.out.println(obj.toString());
        }



    }
}

