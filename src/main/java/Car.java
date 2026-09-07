public class Car {
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 250;

    private final String name;
    private final int speed;

    Car(String name, int speed) {
        validateName(name);
        validateSpeed(speed);
        this.name = name.trim();
        this.speed = speed;
    }

    public static void validateSpeed(int speed) {
        if (!isSpeedValid(speed)) {
            throw new IllegalArgumentException(String.format("Скорость должна быть от %d до %d", MIN_SPEED, MAX_SPEED));
        }
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не должно быть пустым");
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    private static boolean isSpeedValid(int speed) {
        return speed >= MIN_SPEED && speed <= MAX_SPEED;
    }
}
