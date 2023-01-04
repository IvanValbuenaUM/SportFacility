package sportfacility.logic;

import sportfacility.data.entities.Customer;
import sportfacility.data.entities.Timetable;
import sportfacility.data.entities.facilities.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final int todayH = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    private final int todayD = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private final int todayM = Calendar.getInstance().get(Calendar.MONTH);
    private final int todayY = Calendar.getInstance().get(Calendar.YEAR);
    private List<Customer> customerLinkedList;
    private List<Facility> facilitiesLinkedList;
    private List<Timetable> timetableLinkedList;

    public void start() {
        customerLinkedList = new LinkedList<>();
        facilitiesLinkedList = new LinkedList<>();
        timetableLinkedList = new LinkedList<>();
        try {
            LoadCustomers();
            LoadFacilities();
            LoadTimetables();
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("WELCOME TO OUR SPORT FACILITY");
        System.out.println();
        MainMenu();
    }


    private void MainMenu() {
        int c;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            System.out.println("What do you want to do?" + "\n" + "(1) Sign up" + "\n" + "(2) Register" + "\n" + "(3) Exit");
            try {
                c = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid input");
                continue;
            }
            u.close();
            switch (c) {
                case 1:
                    SignUp();
                    break;
                case 2:
                    Register();
                    break;
                case 3:
                    Exit();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + c + " not understood");
            }
        }
    }

    private void SignUp() {
        System.out.println();
        System.out.println("Please introduce your customer information");
        System.out.print("ID: ");
        String id = AskForValidID();
        System.out.print("Membership nº: ");
        int mem = AskForValidMembershipNumber();
        boolean existed = false;
        Customer found = null;
        for (Customer c : customerLinkedList) {
            if (c.getId().equals(id) && c.getMembershipNumber() == mem) {
                found = c;
                existed = true;
            }
        }
        if (existed)
            MemberMenu(found);
        else
            System.out.println("No customer with that information found!");
    }

    private void Register() {
        System.out.println("Thank you for choosing us!");
        System.out.println("Lets create your account!");
        Customer cus = NewCustomerInfo();
        System.out.println("New account created!!");
        System.out.println("Thank you " + cus.getName() + " your membership number is " + cus.getMembershipNumber());
        System.out.println();
    }

    private void Exit() {
        try {
            SaveCustomers();
            SaveFacilities();
            SaveTimetables();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("The application will shutdown");
        System.out.println("See you another day!");
    }

    private Customer NewCustomerInfo() {
        System.out.println("Introduce the required information");
        Scanner reader = new Scanner(System.in);
        System.out.print("Name: ");
        String name = reader.next();
        System.out.print("Surname: ");
        String surname = reader.next();
        System.out.print("Age: ");
        int age = AskForValidAge();
        System.out.print("ID: ");
        String id = AskForValidID();
        int membershipNumber = GetNonExistingMembershipNumber();

        Customer newCustomer = new Customer(name, surname, age, id, membershipNumber);
        customerLinkedList.add(newCustomer);
        
        reader.close();

        return newCustomer;
    }

    private String AskForValidID() {
        String id;
        while (true) {
            Scanner u = new Scanner(System.in);
            id = u.next();
            try {
                new Customer("A", "A", 18, id, 1);
            } catch (IllegalArgumentException e) {
                System.out.println("Please try to introduce a ID (6 numbers followed by 1 letter)");
                System.out.print("ID: ");
                continue;
            }
            u.close();
            break;
        }
        return id;
    }

    private int AskForValidAge() {
        int age;
        while (true) {
            Scanner u = new Scanner(System.in);
            try {
                age = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid age");
                System.out.print("Age: ");
                continue;
            }
            if (age < 18) {
                System.out.println("Please try to introduce an age over 18");
                System.out.print("Age: ");
                continue;
            }
            u.close();
            break;
        }
        return age;
    }

    private int AskForValidMembershipNumber() {
        int mem;
        while (true) {
            Scanner u = new Scanner(System.in);
            try {
                mem = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid membership number");
                System.out.print("Membership nº: ");
                continue;
            }
            try {
                new Customer("A", "A", 18, "111111A", mem);
            } catch (IllegalArgumentException e) {
                System.out.println("Please try to introduce a membership number (number between 0 and 9999)");
                System.out.print("Membership nº: ");
                continue;
            }
            u.close();
            break;
        }
        return mem;
    }

    private int GetNonExistingMembershipNumber() {
        Random r;
        boolean found = false;
        int n = 0;
        while (!found) {
            found = true;
            r = new Random();
            n = r.nextInt(10000);
            for (Customer c : customerLinkedList) {
                if (c.getMembershipNumber() == n) {
                    found = false;
                    break;
                }
            }
        }
        return n;
    }

    private void MemberMenu(Customer c) {
        System.out.println();
        System.out.println("Welcome back " + c.getName() + "!");
        System.out.println("What would you like to do?");
        System.out.println();
        int i;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            PrintOptionsMember();
            try {
                i = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid option");
                continue;
            }
            u.close();
            switch (i) {
                case 1:
                    SeeMyReservations(c);
                    break;
                case 2:
                    MakeAReservation(c);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Going back to the main menu " + c.getName());
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + i + " is not valid");
            }
        }
    }

    private void PrintOptionsMember() {
        System.out.println("(1) My reservations");
        System.out.println("(2) Make a reservation");
        System.out.println("(3) Exit");
    }

    private void SeeMyReservations(Customer c) {
        if (c.getReservations().isEmpty()) {
            System.out.println();
            System.out.println(c.getName() + ", you do not have any reservations yet");
        } else {
            System.out.println(c.getName() + ", your reservations are:");
            for (Timetable t : c.getReservations()) {
                System.out.println(t.toString());
            }
        }
        System.out.println();
    }

    private void MakeAReservation(Customer c) {
        System.out.println();
        System.out.println("Choose what kind of facility you want");
        System.out.println();
        int i;
        boolean exit = false;
        while (!exit) {
            Scanner u = new Scanner(System.in);
            PrintOptionsFacility();
            try {
                i = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid option");
                continue;
            }
            u.close();
            switch (i) {
                case 1:
                    ReserveBasketCourt(c);
                    break;
                case 2:
                    ReserveFootballCourt(c);
                    break;
                case 3:
                    ReservePadelCourt(c);
                    break;
                case 4:
                    ReserveTennisCourt(c);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Going back to the member menu " + c.getName());
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Input " + i + " is not valid");
            }
        }
    }

    private void PrintOptionsFacility() {
        System.out.println("(1) Basket Court");
        System.out.println("(2) Football Court");
        System.out.println("(3) Padel Court");
        System.out.println("(4) Tennis Court");
        System.out.println("(5) Exit");
    }

    private void ReserveBasketCourt(Customer c) {
        MakeTheReservationBasketCourts(c);
    }

    private void ReserveFootballCourt(Customer c) {
        MakeTheReservationFootballCourts(c);
    }

    private void MakeTheReservationBasketCourts(Customer theCustomer) {
        System.out.println("Basketball Courts (" + todayD + "/" + (todayM + 1) + "/" + todayY + "): ");
        System.out.println();
        List<BasketCourt> basketCourts = new LinkedList<>();
        for (Facility f : facilitiesLinkedList) {
            if (f.getFacilityCode().charAt(0) == 'b')
                basketCourts.add((BasketCourt) f);
        }
        for (Facility f : basketCourts) {
            System.out.print(f.AvailableString());
            ShowTimeTableGiven(f);
            System.out.println();
        }
        while (true) {
            Scanner u = new Scanner(System.in);
            System.out.print("Select the code of the court you want to reserve: ");
            String code = u.next();
            boolean isFound = false;
            for (BasketCourt bc : basketCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    isFound = true;
                    break;
                }
            }
            Facility theFacility = null;
            for (Facility f : facilitiesLinkedList) {
                if (f.getFacilityCode().equals(code))
                    theFacility = f;
            }
            if (!isFound) {
                System.out.println();
                System.out.println("Please introduce a valid code");
                continue;
            }
            System.out.print("Select the starting hour (format 24h from 8 to 18, even hours): ");
            int hour;
            try {
                hour = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid hour (example: \"10\")");
                continue;
            }
            if (hour < 8 || hour > 18) {
                System.out.println("Please try to introduce a hour between 8 and 18");
                continue;
            } else if (hour % 2 != 0) {
                System.out.println("Remember to introduce a even hour");
                continue;
            } else if (hour < todayH) {
                System.out.println("This hour has already passed");
                continue;
            }
            System.out.println();
            List<Integer> listHours = new LinkedList<>();
            for (BasketCourt bc : basketCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    for (Timetable tt : bc.getReservations()) {
                        listHours.add(tt.getStartReservation().get(Calendar.HOUR_OF_DAY));
                    }
                }
            }
            boolean error = false;
            for (Integer integer : listHours) {
                if (integer == hour) {
                    error = true;
                    break;
                }
            }
            if (error) {
                System.out.println("Please try to introduce an available hour");
                continue;
            }
            facilitiesLinkedList.removeIf(value -> value.getFacilityCode().charAt(0) == 'b');
            facilitiesLinkedList.addAll(basketCourts);
            Calendar[] calendars = GetCalendars(hour);
            Timetable event;
            assert theFacility != null;
            event = new Timetable(GetNonExistingTimetableNumber(), calendars[0], calendars[1], theCustomer, theFacility, theFacility.getMaxCapacity());
            timetableLinkedList.add(event);
            for (Customer c : customerLinkedList) {
                c.addReservation(event);
                break;
            }
            System.out.println("The basketball court " + theFacility.getFacilityCode() + " has been reserved by " + theCustomer.getName() + " at " + hour + ":00 until " + (hour + 2) + ":00!");
            System.out.println();
            u.close();
            break;
        }
    }

    private void MakeTheReservationFootballCourts(Customer theCustomer) {
        System.out.println("Football Courts (" + todayD + "/" + (todayM + 1) + "/" + todayY + "): ");
        System.out.println();
        List<FootballCourt> footballCourts = new LinkedList<>();
        for (Facility f : facilitiesLinkedList) {
            if (f.getFacilityCode().charAt(0) == 'f')
                footballCourts.add((FootballCourt) f);
        }
        for (Facility f : footballCourts) {
            System.out.print(f.AvailableString());
            ShowTimeTableGiven(f);
            System.out.println();
        }
        while (true) {
            Scanner u = new Scanner(System.in);
            System.out.print("Select the code of the court you want to reserve: ");
            String code = u.next();
            boolean isFound = false;
            for (FootballCourt bc : footballCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    isFound = true;
                    break;
                }
            }
            Facility theFacility = null;
            for (Facility f : facilitiesLinkedList) {
                if (f.getFacilityCode().equals(code))
                    theFacility = f;
            }
            if (!isFound) {
                System.out.println();
                System.out.println("Please introduce a valid code");
                continue;
            }
            System.out.print("Select the starting hour (format 24h from 8 to 18, even hours): ");
            int hour;
            try {
                hour = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid hour (example: \"10\")");
                continue;
            }
            if (hour < 8 || hour > 18) {
                System.out.println("Please try to introduce a hour between 8 and 18");
                continue;
            } else if (hour % 2 != 0) {
                System.out.println("Remember to introduce a even hour");
                continue;
            } else if (hour < todayH) {
                System.out.println("This hour has already passed");
                continue;
            }
            System.out.println();
            List<Integer> listHours = new LinkedList<>();
            for (FootballCourt bc : footballCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    for (Timetable tt : bc.getReservations()) {
                        listHours.add(tt.getStartReservation().get(Calendar.HOUR_OF_DAY));
                    }
                }
            }
            boolean error = false;
            for (Integer integer : listHours) {
                if (integer == hour) {
                    error = true;
                    break;
                }
            }
            if (error) {
                System.out.println("Please try to introduce an available hour");
                continue;
            }
            facilitiesLinkedList.removeIf(value -> value.getFacilityCode().charAt(0) == 'f');
            facilitiesLinkedList.addAll(footballCourts);
            Calendar[] calendars = GetCalendars(hour);
            Timetable event;
            assert theFacility != null;
            event = new Timetable(GetNonExistingTimetableNumber(), calendars[0], calendars[1], theCustomer, theFacility, theFacility.getMaxCapacity());
            timetableLinkedList.add(event);
            for (Customer c : customerLinkedList) {
                c.addReservation(event);
                break;
            }
            System.out.println("The football court " + theFacility.getFacilityCode() + " has been reserved by " + theCustomer.getName() + " at " + hour + ":00 until " + (hour + 2) + ":00!");
            System.out.println();
            u.close();
            break;
        }
    }

    private void ReservePadelCourt(Customer theCustomer) {
        System.out.println("Padel Courts (" + todayD + "/" + (todayM + 1) + "/" + todayY + "): ");
        System.out.println();
        List<PadelCourt> padelCourts = new LinkedList<>();
        for (Facility f : facilitiesLinkedList) {
            if (f.getFacilityCode().charAt(0) == 'p')
                padelCourts.add((PadelCourt) f);
        }
        for (Facility f : padelCourts) {
            System.out.print(f.AvailableString());
            ShowTimeTableGiven(f);
            System.out.println();
        }
        while (true) {
            Scanner u = new Scanner(System.in);
            System.out.print("Select the code of the court you want to reserve: ");
            String code = u.next();
            boolean isFound = false;
            for (PadelCourt bc : padelCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    isFound = true;
                    break;
                }
            }
            Facility theFacility = null;
            for (Facility f : facilitiesLinkedList) {
                if (f.getFacilityCode().equals(code))
                    theFacility = f;
            }
            if (!isFound) {
                System.out.println();
                System.out.println("Please introduce a valid code");
                continue;
            }
            System.out.print("Select the starting hour (format 24h from 8 to 18, even hours): ");
            int hour;
            try {
                hour = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid hour (example: \"10\")");
                continue;
            }
            if (hour < 8 || hour > 18) {
                System.out.println("Please try to introduce a hour between 8 and 18");
                continue;
            } else if (hour % 2 != 0) {
                System.out.println("Remember to introduce a even hour");
                continue;
            } else if (hour < todayH) {
                System.out.println("This hour has already passed");
                continue;
            }
            System.out.println();
            List<Integer> listHours = new LinkedList<>();
            for (PadelCourt bc : padelCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    for (Timetable tt : bc.getReservations()) {
                        listHours.add(tt.getStartReservation().get(Calendar.HOUR_OF_DAY));
                    }
                }
            }
            boolean error = false;
            for (Integer integer : listHours) {
                if (integer == hour) {
                    error = true;
                    break;
                }
            }
            if (error) {
                System.out.println("Please try to introduce an available hour");
                continue;
            }
            facilitiesLinkedList.removeIf(value -> value.getFacilityCode().charAt(0) == 'p');
            facilitiesLinkedList.addAll(padelCourts);
            Calendar[] calendars = GetCalendars(hour);
            Timetable event;
            assert theFacility != null;
            event = new Timetable(GetNonExistingTimetableNumber(), calendars[0], calendars[1], theCustomer, theFacility, theFacility.getMaxCapacity());
            timetableLinkedList.add(event);
            for (Customer c : customerLinkedList) {
                c.addReservation(event);
                break;
            }
            System.out.println("The padel court " + theFacility.getFacilityCode() + " has been reserved by " + theCustomer.getName() + " at " + hour + ":00 until " + (hour + 2) + ":00!");
            System.out.println();
            u.close();
            break;
        }
    }

    private void ReserveTennisCourt(Customer theCustomer) {
        System.out.println("Tennis Courts (" + todayD + "/" + (todayM + 1) + "/" + todayY + "): ");
        System.out.println();
        List<TennisCourt> TennisCourts = new LinkedList<>();
        for (Facility f : facilitiesLinkedList) {
            if (f.getFacilityCode().charAt(0) == 't')
                TennisCourts.add((TennisCourt) f);
        }
        for (Facility f : TennisCourts) {
            System.out.print(f.AvailableString());
            ShowTimeTableGiven(f);
            System.out.println();
        }
        while (true) {
            Scanner u = new Scanner(System.in);
            System.out.print("Select the code of the court you want to reserve: ");
            String code = u.next();
            boolean isFound = false;
            for (TennisCourt bc : TennisCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    isFound = true;
                    break;
                }
            }
            Facility theFacility = null;
            for (Facility f : facilitiesLinkedList) {
                if (f.getFacilityCode().equals(code))
                    theFacility = f;
            }
            if (!isFound) {
                System.out.println();
                System.out.println("Please introduce a valid code");
                continue;
            }
            System.out.print("Select the starting hour (format 24h from 8 to 18, even hours): ");
            int hour;
            try {
                hour = u.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please try to introduce a valid hour (example: \"10\")");
                continue;
            }
            if (hour < 8 || hour > 18) {
                System.out.println("Please try to introduce a hour between 8 and 18");
                continue;
            } else if (hour % 2 != 0) {
                System.out.println("Remember to introduce a even hour");
                continue;
            } else if (hour < todayH) {
                System.out.println("This hour has already passed");
                continue;
            }
            System.out.println();
            List<Integer> listHours = new LinkedList<>();
            for (TennisCourt bc : TennisCourts) {
                if (bc.getFacilityCode().equals(code)) {
                    for (Timetable tt : bc.getReservations()) {
                        listHours.add(tt.getStartReservation().get(Calendar.HOUR_OF_DAY));
                    }
                }
            }
            boolean error = false;
            for (Integer integer : listHours) {
                if (integer == hour) {
                    error = true;
                    break;
                }
            }
            if (error) {
                System.out.println("Please try to introduce an available hour");
                continue;
            }
            facilitiesLinkedList.removeIf(value -> value.getFacilityCode().charAt(0) == 'p');
            facilitiesLinkedList.addAll(TennisCourts);
            Calendar[] calendars = GetCalendars(hour);
            Timetable event;
            assert theFacility != null;
            event = new Timetable(GetNonExistingTimetableNumber(), calendars[0], calendars[1], theCustomer, theFacility, theFacility.getMaxCapacity());
            timetableLinkedList.add(event);
            for (Customer c : customerLinkedList) {
                c.addReservation(event);
                break;
            }
            System.out.println("The tennis court " + theFacility.getFacilityCode() + " has been reserved by " + theCustomer.getName() + " at " + hour + ":00 until " + (hour + 2) + ":00!");
            System.out.println();
            u.close();
            break;
        }
    }

    private Calendar[] GetCalendars(int hour) {
        Calendar[] aux = new Calendar[2];
        String todayStart;
        String todayEnd;
        if (todayD < 10) {
            if (todayM < 9) {
                todayStart = "0" + todayD + "/0" + (todayM + 1) + "/" + todayY + " " + hour;
                todayEnd = "0" + todayD + "/0" + (todayM + 1) + "/" + todayY + " " + (hour + 2);
            } else {
                todayStart = "0" + todayD + "/" + (todayM + 1) + "/" + todayY + " " + hour;
                todayEnd = "0" + todayD + "/" + (todayM + 1) + "/" + todayY + " " + (hour + 2);
            }
        } else {
            if (todayM < 9) {
                todayStart = todayD + "/0" + (todayM + 1) + "/" + todayY + " " + hour;
                todayEnd = todayD + "/0" + (todayM + 1) + "/" + todayY + " " + (hour + 2);
            } else {
                todayStart = todayD + "/" + (todayM + 1) + "/" + todayY + " " + hour;
                todayEnd = todayD + "/" + (todayM + 1) + "/" + todayY + " " + (hour + 2);
            }
        }
        todayStart += ":00:00";
        todayEnd += ":00:00";

        Calendar calS = Calendar.getInstance();
        Calendar calE = Calendar.getInstance();
        try {
            calS.setTime(dateFormat.parse(todayStart));
            calE.setTime(dateFormat.parse(todayEnd));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        aux[0] = calS;
        aux[1] = calE;
        return aux;
    }

    private String GetNonExistingTimetableNumber() {
        Random r;
        boolean found = false;
        int n = 0;
        while (!found) {
            found = true;
            r = new Random();
            n = r.nextInt(100);
            for (Timetable t : timetableLinkedList) {
                if (Integer.parseInt(t.getId().substring(2, 4)) == n) {
                    found = false;
                    break;
                }
            }
        }
        return "tt" + n;
    }

    private void ShowTimeTableGiven(Facility f) {
        List<Integer> listHours = new LinkedList<>();
        for (int i = 8; i < 19; i = i + 2) {
            listHours.add(i);
        }
        for (Timetable t : timetableLinkedList) {
            if (f.getFacilityCode().equals(t.getFacility().getFacilityCode()))
                listHours.remove((Object) t.getStartReservation().get(Calendar.HOUR_OF_DAY));
        }
        for (Integer i : listHours) {
            System.out.print("   ");
            System.out.print(i + ":" + "00"
                    + " -> " + (i + 2) + ":" + "00");
        }
        System.out.println();
    }

    private void LoadCustomers() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/sportfacility/data/files/Customers"));

        while (input.hasNext()) {
            String[] line = input.nextLine().split("-");
            String name = line[0];
            String surname = line[1];
            int age = Integer.parseInt(line[2]);
            String id = line[3];
            int membershipNumber = Integer.parseInt(line[4]);

            Customer newCustomer = new Customer(name, surname, age, id, membershipNumber);
            customerLinkedList.add(newCustomer);
        }
        input.close();
    }

    private void LoadFacilities() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/sportfacility/data/files/Facilities"));

        while (input.hasNext()) {
            String[] line = input.nextLine().split("-");
            String code = line[0];
            int capacity = Integer.parseInt(line[1]);
            int priceHour = Integer.parseInt(line[2]);
            int nChangingRooms = Integer.parseInt(line[3]);
            int nFloodLights = Integer.parseInt(line[4]);
            int extraLightsPrice = Integer.parseInt(line[5]);
            Facility f = null;
            if (code.charAt(0) == 'b') {
                int basketBallsRented = Integer.parseInt(line[6]);
                f = new BasketCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, basketBallsRented);
            } else if (code.charAt(0) == 'f') {
                int footBallsRented = Integer.parseInt(line[6]);
                f = new FootballCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, footBallsRented);
            } else if (code.charAt(0) == 'p') {
                int padelRacquetsRented = Integer.parseInt(line[6]);
                int padelBallsRented = Integer.parseInt(line[7]);
                f = new PadelCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, padelRacquetsRented, padelBallsRented);
            } else if (code.charAt(0) == 't') {
                int tennisRacquetsRented = Integer.parseInt(line[6]);
                int tennisBallsRented = Integer.parseInt(line[7]);
                f = new TennisCourt(code, capacity, priceHour, nChangingRooms, nFloodLights, extraLightsPrice, tennisRacquetsRented, tennisBallsRented);
            }
            facilitiesLinkedList.add(f);
        }
        input.close();
    }

    private void LoadTimetables() throws FileNotFoundException, ParseException {
        Scanner input = new Scanner(new File("src/main/java/sportfacility/data/files/Timetables"));

        while (input.hasNext()) {
            String[] line = input.nextLine().split("-");
            String codeT = line[0];
            Calendar calStart = Calendar.getInstance();
            Calendar calEnd = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            calStart.setTime(sdf.parse(line[1]));
            calEnd.setTime(sdf.parse(line[2]));
            String codeC = line[3];
            Customer customer = null;
            for (Customer c : customerLinkedList) {
                if (c.getMembershipNumber() == Integer.parseInt(codeC))
                    customer = c;
            }
            String codeF = line[4];
            Facility facility = null;
            for (Facility f : facilitiesLinkedList) {
                if (f.getFacilityCode().equals(codeF))
                    facility = f;
            }
            int nPeople = Integer.parseInt(line[5]);

            Timetable timetable = new Timetable(codeT, calStart, calEnd, customer, facility, nPeople);
            timetableLinkedList.add(timetable);
            for (Customer c : customerLinkedList) {
                assert customer != null;
                if (c.getMembershipNumber() == customer.getMembershipNumber())
                    c.addReservation(timetable);
            }
        }
        input.close();
    }

    private void SaveCustomers() throws IOException {
        File myObj = new File("src/main/java/sportfacility/data/files/Customers");

        StringBuilder str = new StringBuilder();
        for (Customer c : customerLinkedList) {
            str.append(c.getName()).append("-").append(c.getSurname()).append("-").append(c.getAge()).append("-").append(c.getId()).append("-").append(c.getMembershipNumber()).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(myObj));
        writer.write(str.toString());

        writer.close();
    }

    private void SaveTimetables() throws IOException {
        File myObj = new File("src/main/java/sportfacility/data/files/Timetables");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        StringBuilder str = new StringBuilder();
        for (Timetable t : timetableLinkedList) {
            String start = dateFormat.format(t.getStartReservation().getTime());
            String end = dateFormat.format(t.getEndReservation().getTime());
            str.append(t.getId()).append("-").append(start).append("-").append(end).append("-").append(t.getCustomer().getMembershipNumber()).append("-").append(t.getFacility().getFacilityCode()).append("-").append(t.getFacility().getMaxCapacity()).append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(myObj));
        writer.write(str.toString());

        writer.close();
    }

    private void SaveFacilities() throws IOException {
        File myObj = new File("src/main/java/sportfacility/data/files/Facilities");

        StringBuilder str = new StringBuilder();
        for (Facility f : facilitiesLinkedList) {
            str.append(f.serialize());
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(myObj));
        writer.write(str.toString());

        writer.close();
    }

}
