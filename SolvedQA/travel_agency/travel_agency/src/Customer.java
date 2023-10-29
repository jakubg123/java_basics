public class Customer {

    private final int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    private static int totalCustomers;


    public Customer(int id,String name, String surname, String phoneNumber, String email)  {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        totalCustomers++;


    }

    // getters
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public int getId(){
        return id;
    }
    public int getTotalCustomers(){
        return totalCustomers;
    }

    // setters
    public void setName(String name){
       this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }


    @Override
    public String toString() {

        return name + " " + surname + " " + email + " " + phoneNumber;

    }
}
