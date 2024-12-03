import com.sun.jdi.Value;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class FileOperations {
    
    public static void createFile(String fileName){
        File newFile = new File(fileName);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
                System.out.println("Файл успешно создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            Scanner scan = new Scanner(System.in);
            Flight flight = new Flight();
            SimpleDateFormat dateFormater = new SimpleDateFormat("dd.MM.yyyy");
            DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm");

            System.out.print("Введите номер рейса: ");
            String flightNumber = scan.nextLine();
            flight.setFlightNumber(Integer.parseInt(flightNumber));
            writer.write(flightNumber + " | ");

            System.out.print("Введите маршрут: ");
            flight.setRoute(scan.nextLine());
            writer.write(flight.getRoute() + " | ");

            System.out.print("Введите промежуточные места посадки: ");
            flight.setBoardingPoints(scan.nextLine());
            writer.write(flight.getBoardingPoints() + " | ");

            System.out.print("Введите время отправления(чч:мм): ");
            String stringTime = scan.nextLine();
            LocalTime time = LocalTime.parse(stringTime, timeFormater);
            flight.setSendTime(time);
            writer.write(stringTime + " | ");

            System.out.print("Введите дни отправления(дд.мм.гггг): ");
            String stringDays = scan.nextLine();
            Date date = dateFormater.parse(stringDays);
            flight.setSendDate(date);
            writer.write(dateFormater.format(date) + " | ");

            System.out.print("Введите количество свободных мест на каждом рейсе: ");
            String emptyPlaces= scan.nextLine();
            flight.setEmptyPlaces(Integer.parseInt(emptyPlaces));
            writer.write(emptyPlaces);

            writer.append("\n");

            writer.flush();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Flight> readFile(String fileName) {
        ArrayList<Flight> flightList = new ArrayList<>();
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm");


        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader fileScanner = new BufferedReader(reader);
            while (fileScanner.ready()) {
                String line = fileScanner.readLine();
                String[] dataArray = line.split(" \\| ");
                int flightNumber = Integer.parseInt(dataArray[0]);
                String route = dataArray[1];
                String boardingPoints = dataArray[2];
                LocalTime sendTime = LocalTime.parse(dataArray[3], timeFormater);
                Date sendDate = formater.parse(dataArray[4]);
                int emptyPlaces = Integer.parseInt(dataArray[5]);
                Flight flight = new Flight(flightNumber, route, boardingPoints, sendTime, sendDate, emptyPlaces);
                flightList.add(flight);
            }
            fileScanner.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\n");
        int i = 0;
        for (Flight flight : flightList) {
            System.out.println(i++ + ". " + flight.getFlightNumber() + " " + flight.getRoute() + " " + flight.getBoardingPoints() + " " + flight.getSendTime() + " " + formater.format(flight.getSendDate()) + " " + flight.getEmptyPlaces());
        }
        System.out.print("\n");
        return flightList;
    }

    public static void deleteFlightFromFile(String fileName) {

        Scanner scan = new Scanner(System.in);

        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");

        ArrayList<Flight> flights = readFile(fileName);

        System.out.print("Введите номер для удаления: ");
        int numForDelete = scan.nextInt();

        Flight deleteTarget = null;
        for (Flight flight : flights) {
            if (flights.indexOf(flight) == numForDelete) {
                deleteTarget = flight;
                break;
            }
        }
        if (deleteTarget != null) {
            flights.remove(deleteTarget);
        }

        try{
            FileWriter writer = new FileWriter(fileName);
            for (Flight flight : flights) {
                writer.write(flight.getFlightNumber() + " | ");
                writer.write(flight.getRoute() + " | ");
                writer.write(flight.getBoardingPoints() + " | ");
                writer.write(flight.getSendTime() + " | ");
                writer.write(formater.format(flight.getSendDate()) + " | ");
                writer.write(flight.getEmptyPlaces() + " | ");
                writer.append("\n");
                writer.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void findFlight(String fileName){

        Scanner scan = new Scanner(System.in);

        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm");
        

        ArrayList<Flight> flights = readFile(fileName);
        ArrayList<Flight> targets = new ArrayList<>();

        System.out.print("Поиск: ");
        String search = scan.nextLine();

        Flight target = null;
        for (Flight flight : flights) {
            if (String.valueOf(flight.getFlightNumber()).equals(search) || flight.getRoute().equals(search) || flight.getBoardingPoints().equals(search) || flight.getSendTime().format(timeFormater).equals(search)  || formater.format(flight.getSendDate()).equals(search) || String.valueOf(flight.getEmptyPlaces()).equals(search)) {
                target = flight;
                targets.add(target);
            }
        }
        
        if (!targets.isEmpty()) {
            System.out.println("+++Рейс найден+++\n");
        }
        else {
            System.out.println("---Рейс не найден---");
        }
        for(Flight flight : targets){
            System.out.println(flights.indexOf(flight) + ". " + flight.getFlightNumber() + " " + flight.getRoute() + " " + flight.getBoardingPoints() + " " + flight.getSendTime() + " " + formater.format(flight.getSendDate()) + " " + flight.getEmptyPlaces());
        }
        System.out.println();
        
    }
    
}
