import java.util.HashSet;

public class Race {
    private static final int RACE_DURATION_HOURS = 24;

    private Car leader;
    private int leaderDistance;
    private final HashSet<String> carNames = new HashSet<>();

    public boolean containsCar(String name) {
        return carNames.contains(name);
    }

    public void addCar(Car car) {
        if (!carNames.add(car.getName())) {
            throw new IllegalArgumentException("Машина с таким именем уже есть");
        }

        int distance = calculateDistance(car.getSpeed());

        if (leader == null || distance > leaderDistance) {
            leader = car;
            leaderDistance = distance;
        }
    }

    public String getLeaderName() {
        if (leader == null) {
            throw new IllegalStateException("В гонке нет машин");
        }
        return leader.getName();
    }

    private int calculateDistance(int speed) {
        return RACE_DURATION_HOURS * speed;
    }
}
