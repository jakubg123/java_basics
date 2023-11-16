package uni.lodz.project.enums;

public enum TravelStatus {
   COMPLETED,
   IN_PROGRESS,
   NOT_STARTED;

    public String getStatus()
    {
        return this.name();
    }

}
