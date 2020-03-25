package carRacing;

import carRacing.domain.MoveRandom;
import carRacing.domain.MoveStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void setCars(int input) {
        MoveStrategy moveRandom = new MoveRandom(new Random());
        RacingGame racingGame = new RacingGame(input, VehicleType.CAR, moveRandom);


        assertThat(racingGame.vehicles).hasSize(input);
    }


    @ParameterizedTest
    @CsvSource(value = {"1 2 4:1", "2 3 0:0", "3 4 2:0", "4 5 9:1"}, delimiter = ':')
    void moveTest(String input, String expected) {
        String[] inputs = input.split(" ");
        int numberOfCar = Integer.parseInt(inputs[0]);
        int time = Integer.parseInt(inputs[1]);
        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(inputs[2]);
            }
        });
        RacingGame racingGame = new RacingGame(numberOfCar, VehicleType.CAR, moveRandom);

        racingGame.start(time);

        assertThat(racingGame.observe().stream().allMatch(i -> (i == (Integer.parseInt(expected)*time)))).isTrue();
    }

}