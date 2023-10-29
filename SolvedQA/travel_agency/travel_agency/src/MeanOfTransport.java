public class MeanOfTransport {
    private int id;
    private String name;
    private Customer[] seats;

    private static int availableSeats;
    public MeanOfTransport(int id, String name, int seatCount){
        this.id = id;
        this.name = name;
        this.seats = new Customer[seatCount];
        this.availableSeats = seatCount;
    }

    public int getId() {
        return id;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getName() {
        return name;
    }

    public Customer[] getSeats() {
        return seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean bookSeat(Customer customer) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                seats[i] = customer;
                availableSeats--;
                return true;
            }
        }
        return false;
    }

    public boolean isSeatAvailable() {
        for (Customer seat : seats) {
            if (seat == null) {
                return true;
            }
        }
        return false;
    }





}
