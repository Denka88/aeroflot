import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

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
//            Scanner scan = new Scanner(System.in);
//            Task task = new Task();
//
//            SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
//            Date date = new Date();
//            System.out.print("Введите имя задачи: ");
//            task.setName(scan.nextLine());
//            writer.write(task.getName() + " | ");
//
//            System.out.print("Введите описание задачи: ");
//            task.setDescription(scan.nextLine());
//            writer.write(task.getDescription() + " | ");
//
//            int year = date.getYear();
//            int month = Calendar.getInstance().get(Calendar.MONTH);
//            int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//            task.setCreateDate(year, month, day);
//
//            writer.write(formater.format(task.getCreateDate())+ " | ");
//            System.out.print("Введите количество дней на выполнение задачи: ");
//            String deadline = scan.nextLine();
//            task.setDeadline(Integer.parseInt(deadline));
//            writer.write(deadline);
//            writer.append("\n");
//
//            writer.flush();

            Scanner scan = new Scanner(System.in);
            Flight flight = new Flight();
            SimpleDateFormat dateFormater = new SimpleDateFormat("dd.MM.yyyy");
            DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss");
            Date date = new Date();
            LocalTime time = LocalTime.now();

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

            System.out.print("Введите время отправления: ");
            String stringTime = scan.nextLine();
            time = LocalTime.parse(stringTime, timeFormater);
            flight.setSendTime(time);
            writer.write(stringTime + " | ");
            
            writer.flush();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
