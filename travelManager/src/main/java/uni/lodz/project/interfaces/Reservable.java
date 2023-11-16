package uni.lodz.project.interfaces;

import uni.lodz.project.exceptions.NoFreeSeatsException;

public interface Reservable {
    public void reserve(int numberOfSeats) throws NoFreeSeatsException;
}
