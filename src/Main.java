import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        Имя файла всегда постоянно
        String fileName = "flight.txt";
        FileOperations.createFile(fileName);


        /**
         * Главное меню
         * Создано с помошью do-while и switch-case
         * Пока menu не равно 5, программа будет продолжать работу
         */
        byte menu;
        do{
            System.out.print("""
                    ===Главное меню===
                    1.Создать рейс
                    2.Посмотреть список рейсов
                    3.Удалить рейс
                    4.Поиск рейсов
                    5.Завершить работу программы
                    """);
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
                    FileOperations.findFlight(fileName);
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