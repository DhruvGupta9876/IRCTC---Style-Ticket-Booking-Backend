import java.util.List;
import java.util.Scanner;

public class IRCTCAPP{


    private final Scanner scanner=new Scanner(System.in);
    private final UserService userService=new UserService();
    private final Bookingservice bookingservice=new Bookingservice();


    public static void main(String[] args) {
        new IRCTCAPP().start();

    }

    public void start()
    {
        while(true) {
            System.out.println("welcome to IRCTC APP");
            if (!userService.isloggedin()) {
                System.out.println("1. Register");
                System.out.println("2. Login ");
                System.out.println("3. Exit ");
                System.out.println("Enter choice : ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("invalid Choice");
                }

            }else

            {
                showUserMenu();
            }
        }
    }

    public void register()

    {
            System.out.println("Enter username : ");
            String username = scanner.next();
            System.out.println("Enter password : ");
            String password = scanner.next();
            System.out.println("Enter Full Name: ");
            scanner.nextLine();
            String fullname= scanner.nextLine();
            System.out.println("Enter Contact: ");
            String contact = scanner.next();

        userService.registerUser(username,password,fullname,contact);
        }

        public void login(){
            System.out.println("Enter username : ");
            String username = scanner.next();
            System.out.println("Enter password : ");
            String password = scanner.next();
            userService.loginUser(username,password);
        }

        public void showUserMenu()
        {
            while (userService.isloggedin())
            {
                System.out.println("Menu");
                System.out.println("1. Search trains: ");
                System.out.println("2. Book Ticketa: ");
                System.out.println("3. view My tickets");
                System.out.println("4. Cancel Tickets : ");
                System.out.println("5. Veiw all trains");
                System.out.println("6. Logout");
                System.out.println("Enter Choice");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> searchTrain();
                    case 2 -> bookTicket();
                    case 3 -> viewMyTicket();
                    case 4 -> cancelTicket();
                    case 5 -> bookingservice.listALLtrains();
                    case 6 -> userService.logoutUser();


                }

            }
        }



    private  void searchTrain(){

        System.out.println("Enter source Station : ");
        String source = scanner.next();
        System.out.println("Enter destination station : ");
        String destination = scanner.next();

        List<Train> trains = bookingservice.searchTrains(source,destination);
        if (trains.isEmpty())
        {
            System.out.println("No Train Found between "+ source + " and " + destination);
            return;
        }
        System.out.println("Train Found");
        for (Train train:trains)
        {
            System.out.println(train);
        }
        System.out.println("do you want to book ticket ?  (yes/no) : ");
        String choice =scanner.next();
        if (choice.equalsIgnoreCase("yes"))
        {
            System.out.println("enter Train ID to book: ");
            int trainID =scanner.nextInt();
            System.out.println("Enter Number of seats you want to book : ");
            int seats = scanner.nextInt();

            Ticket ticket = bookingservice.bookTicket(userService.getCurrentUser(),trainID,seats);
            if (ticket!=null)
            {
                System.out.println("Booking successfull");
                System.out.println(ticket);
            }
        }
        else
        {
            System.out.println("Returning to user  menu ");
        }
    }


    private void bookTicket()
    {
        System.out.println("Enter source Station : ");
        String source = scanner.next();
        System.out.println("Enter destination station : ");
        String destination = scanner.next();
        List<Train> trains = bookingservice.searchTrains(source,destination);
        if (trains.isEmpty())
        {
            System.out.println("No Train Found between "+ source + " and " + destination);
            return;
        }
        System.out.println("Available Trains :" );


        for (Train train:trains)
        {
            System.out.println(train);
        }
        System.out.println("enter Train ID to book: ");
        int trainID =scanner.nextInt();
        System.out.println("Enter Number of seats you want to book : ");
        int seats = scanner.nextInt();

        Ticket ticket = bookingservice.bookTicket(userService.getCurrentUser(),trainID,seats);
        if (ticket!=null)
        {
            System.out.println("Booking successfull");
            System.out.println(ticket);
        }

    }

    private void viewMyTicket()
    {
        List<Ticket> ticketByUser = bookingservice.getTicketByUser(userService.getCurrentUser());
        if (ticketByUser.isEmpty())
        {
            System.out.println("no ticket booked yet");
        }else {
            System.out.println("your Tickets : " );
            for (Ticket ticket:ticketByUser)
            {
                System.out.println(ticket
                );
            }
        }

    }


    private void cancelTicket(){
        System.out.println("enter ticket ID to cancel: ");
        int ticketID =scanner.nextInt();
        bookingservice.cancelTicket(ticketID,userService.getCurrentUser()) ;

    }

         private void exitApp()
         {
             System.out.println("thank you");
             System.exit(0);
         }



}
