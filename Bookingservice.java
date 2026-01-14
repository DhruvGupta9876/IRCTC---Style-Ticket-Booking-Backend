import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    public class Bookingservice {
    private List<Train> trainList= new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();

    public Bookingservice()
    {

        trainList.add(new Train(101,"Rajdhani Express","Delhi","Agra" ,90));
        trainList.add(new Train(102,"Ratlam Express","Ratlam","Agra" ,50));
        trainList.add(new Train(103,"Narmada Express","Indore","Bilaspur" ,80));
        trainList.add(new Train(104,"Amarkantak Express","Pendra","Bhopal" ,70));
        trainList.add(new Train(105,"Satabdi Express","Mumbai","Kerala" ,90));
        trainList.add(new Train(106,"Vande Bharat Express","Kashmir","West Bengal" ,100));

    }

    public List<Train> searchTrains(String source, String destination)
    {
        List<Train> res= new ArrayList<>();
        for (Train train:trainList){


            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination))
            {
                res.add(train);
            }

        }
        return res;
    }

    public  Ticket bookTicket(User user,int trainID , int seatCount)
    {
            for(Train train:trainList)
            {
                if (train.getTrainID() == trainID)
                {
                    if (train.bookedseat(seatCount))
                    {
                        Ticket ticket = new Ticket(user, seatCount, train);
                        ticketList.add(ticket);
                        return ticket;
                    }else {
                        System.out.println("not enough seats Available");
                        return null;
                    }
                }
            }
            System.out.println("Train ID not found");
            return null;

    }

    public List<Ticket> getTicketByUser(User user)
    {
    List<Ticket> res=new ArrayList<>();
    for(Ticket ticket : ticketList)
    {
        if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
        {
            res.add(ticket);

        }
    }
    return res;

}

    public boolean cancelTicket(int ticketId ,User user)
    {
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext())
        {
            Ticket ticket =iterator.next();
            if (ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){

                Train train=ticket.getTrain();
            train.cancelseat(ticket.getSeatbooked());
            iterator.remove();
                System.out.println("Ticket "+ ticketId+" cancelled successfully");
                return true;
            }
        }

        System.out.println("Ticket not found or does not belong to current user ");
        return false;
    }

    public void listALLtrains()
    {
        System.out.println("List of all Trains ");
        for(Train train: trainList)
        {
            System.out.println(train);

        }
    }

}
