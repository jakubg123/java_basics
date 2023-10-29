import java.util.Arrays;

public class Destination {
    private int id;
    private String name;
    private MeanOfTransport transport;

    public Destination(int id, String name, MeanOfTransport transport)
    {
        this.id = id;
        this.name = name;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MeanOfTransport getTransport() {
        return transport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransport(MeanOfTransport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {


        return id + " " + name + " " + transport.getName();

    }



    

}
