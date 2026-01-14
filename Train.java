public class Train
{
    private int trainID;
    private String trainName;
    private String source;
    private String destination;
    private int totalseats;
    private int availableseats;

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public Train(int trainID, String trainName, String source, String destination, int totalseats) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalseats = totalseats;
        this.availableseats = totalseats;
    }

    public boolean bookedseat(int count) {
        if (count <= availableseats) {
            availableseats -= count;
            return true;
        }return  false;

    }
    public  void cancelseat(int count) {
        availableseats += count;
    }

    @Override
    public String toString() {
        return trainID + " | "+trainName+" | "+source+" --> "+destination+" Total seats : "+totalseats+" Available seats :  "+availableseats;
    }
}

