package racing.domain;

public class Car {
    private static final int VALIDATED_NAME_LENGTH = 5;
    private static final int MOVED_DISTANCE = 1;
    private static final int NOT_MOVED_DISTANCE = 0;
    private static final int INITIAL_DISTANCE = 0;

    private String name;
    private DistanceLog distanceLog;
    private MoveConditionStrategy moveConditionStrategy;

    public Car(String name, MoveConditionStrategy moveConditionStrategy) {
        this(name, moveConditionStrategy, INITIAL_DISTANCE);
    }

    public Car(String name, MoveConditionStrategy moveConditionStrategy, int initDistance) {
        validateLength(name);
        this.name = name;
        this.moveConditionStrategy = moveConditionStrategy;
        this.distanceLog = new DistanceLog(initDistance);
    }

    private void validateLength(String name) {
        if (name.length() > VALIDATED_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
    }

    public void move(MoveConditionStrategy moveConditionStrategy) {
        distanceLog.addDistance(createMovedDistance(moveConditionStrategy));
    }

    private int createMovedDistance(MoveConditionStrategy moveConditionStrategy) {
        boolean canMove = moveConditionStrategy.isMovable();
        if (canMove) {
            return MOVED_DISTANCE;
        }

        return NOT_MOVED_DISTANCE;
    }

    public boolean isWinner(int winnerPosition) {
        return distanceLog.isSamePosition(winnerPosition);
    }

    public String getName() {
        return name;
    }

    public int getMovedLogByRound(int round) {
        return distanceLog.getDistanceByRound(round);
    }

    public int getDistance() {
        return distanceLog.getDistance();
    }
}
