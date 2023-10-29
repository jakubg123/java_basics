package travel_agency;

import java.time.LocalDate;

public class Insurance {
    private int insuranceNumber;
    private LocalDate startDate;
    private LocalDate endDate;

    public Insurance(int insuranceNumber, LocalDate startDate, LocalDate endDate){
        this.insuranceNumber = insuranceNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getInsuranceNumber() {
        return insuranceNumber;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isPolicyActive() {
        LocalDate now = LocalDate.now();
        return (now.isAfter(startDate) && now.isBefore(endDate));
    }

}
