package racing.domain;

import racing.utils.RandomNumber;

public class RandomMoveConditionStrategy implements MoveConditionStrategy {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        if (RandomNumber.makeOneRandomNumber() > MOVE_CONDITION) {
            return true;
        }
        return false;
    }
}
