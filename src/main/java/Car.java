public class Car {
    public static final int MAX_SPEED = 250;

    private final String name;
    private final int speed;

    Car(String name, int speed) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не должны быть пустым");
        }

        if (!isSpeedValid(speed)) {
            throw new IllegalArgumentException("Скорость должна быть от 1 до " + MAX_SPEED);
        }

        this.name = name.trim();
        this.speed = speed;
    }

    public static boolean isSpeedValid(int speed) {
        return speed > 0 && speed <= MAX_SPEED;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
