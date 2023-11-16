package uni.lodz.project.interfaces;

public interface Rentable {

    public boolean isRented = false;
    public void rent(String name);
    public void stopRent();
}
