package travel_agency;

public class Destination {
    private int id;

    private Location location;
    private MeanOfTransport transport;

    public Destination(int id, Location location, MeanOfTransport transport)
    {
        this.id = id;
        this.location = location;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }


    public MeanOfTransport getTransport() {
        return transport;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTransport(MeanOfTransport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return id + " " + location.toString() + " " + transport.getName();
    }



    

}
