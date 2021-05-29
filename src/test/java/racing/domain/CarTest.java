package racing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private MoveConditionStrategy moveConditionStrategy;

    @BeforeEach
    void beforeEach() {
        moveConditionStrategy = new RandomMoveConditionStrategy();
    }

    @Test
    @DisplayName("자동차가 이동")
    void move() {
        Car car = new Car("aaa", () -> true);
        car.move(() -> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않음")
    void notMove() {
        Car car = new Car("aaa", () -> false);
        car.move(() -> false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"aaaaa", "bbbb", "ccc"})
    @DisplayName("자동차 이름이 전부 5자 이내인 자동차 생성")
    void makeCarTest(String name) {
        Assertions.assertDoesNotThrow(() -> new Car(name, moveConditionStrategy));
    }

    @DisplayName("자동차 이름이 5자 초과면 에러")
    @ParameterizedTest
    @CsvSource(value = {"123456", "1234567", "12345678"})
    void invalidMakeCarTest(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(name, moveConditionStrategy);
                });
    }
}
