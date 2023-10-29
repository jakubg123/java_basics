package travel_agency;

public class Reviews {
    private static int id;
    private String name;

    private String reviewBody;

    public Reviews(String name, String reviewBody){
        id++;
       this.name = name;
       this.reviewBody = reviewBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Reviews.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    @Override
    public String toString() {
        return this.reviewBody;
    }
}
