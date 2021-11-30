package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void op_add() {
        int a=2;
        int b=3;
        int expectedResult = 5;
        int result = sample.op(Sample.Operation.ADD, a, b);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void op_mult() {
        int a=2;
        int b=3;
        int expectedResult = 6;
        int result = sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void fact_neg() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-1))
            .withMessage("N should be positive");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "13, 1932053504"
    })
    void fact_test_cases(int n, int expectedResult) {
        int result = sample.fact(n);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}

