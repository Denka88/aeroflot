import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String fileName = "flight.txt";
        FileOperations.createFile(fileName);

        byte menu;
        do{
            System.out.printf("""
                    ===Главное меню===
                    1.Создать рейс
                    2.Посмотреть список рейсов
                    3.Удалить рейс
                    4.Поиск рейсов
                    5.Завершить работу программы
                    """, fileName);
            menu = scan.nextByte();
            switch(menu){
                case 1:
                    FileOperations.writeFile(fileName);
                    break;
                case 2:
                    FileOperations.readFile(fileName);
                    break;
                case 3:
                    FileOperations.deleteFlightFromFile(fileName);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.print("Досвидания");
                    break;
                default:
                    System.out.println("Такого пункта в меню нет");
                    break;
            }

        }while (menu != 5);


    }
}