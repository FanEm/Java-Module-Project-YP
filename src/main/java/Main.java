import java.util.Scanner;

public class Main {
    private static final int CAR_COUNT = 3;

    public static void main(String[] args) {
        Race race = new Race();

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= CAR_COUNT; i++) {
            String name = readName(scanner, i, race);
            int speed = readSpeed(scanner, i);

            race.addCar(new Car(name, speed));
        }

        scanner.close();

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
    }

    private static String readName(Scanner scanner, int carNumber, Race race) {
        while(true) {
            System.out.println("Введите название машины №" + carNumber);
            String name = scanner.nextLine().trim();

            try {
                Car.validateName(name);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (race.containsCar(name)) {
                System.out.println("Машина с таким именем уже есть. Введите другое имя");
                continue;
            }

            return name;
        }
    }

    private static int readSpeed(Scanner scanner, int carNumber) {
        while(true) {
            System.out.println("Введите скорость машины №" + carNumber);
            try {
                int speed = Integer.parseInt(scanner.nextLine().trim());
                Car.validateSpeed(speed);
                return speed;
            } catch (NumberFormatException e) {
                System.out.println("Ожидается целое число");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
