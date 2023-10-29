package travel_agency;

public class Agency {


    private static int id;
    private String name;
    private Location location;
    private Reviews[] reviews;

    private Agent[] agents;



    public Agency(String name, Location location, Reviews[] reviews, Agent[] agents){
        id++;
        this.name = name;
        this.location = location;
        this.reviews = reviews;
        this.agents = agents;
    }


//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    public Reviews[] getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(Reviews[] reviews) {
//        this.reviews = reviews;
//    }
//
//    public Agent[] getAgents() {
//        return agents;
//    }
//
//    public void setAgents(Agent[] agents) {
//        this.agents = agents;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Agency.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
