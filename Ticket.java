public class Ticket {
    private int ticketId;
    private User user;
    private int seatbooked;
    private  Train train;
    private static int counter = 1001;

    public Ticket( User user, int seatbooked, Train train) {
        this.ticketId = counter++;
        this.user = user;
        this.seatbooked = seatbooked;
        this.train = train;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeatbooked() {
        return seatbooked;
    }

    public void setSeatbooked(int seatbooked) {
        this.seatbooked = seatbooked;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }
    @Override
    public String toString()
    {
        return "Ticket ID : " +ticketId + " "+ train.getTrainName() + " | Route : "+ train.getSource() + " --> "+ train.getDestination()
                +" | Seat booked : "+ seatbooked+ " Booked By : "+ user.getFullName();




    }



}
