package testproject;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSum() {
        assertThat(Calculator.sum(2, 2)).isEqualTo(4);
    }

    @Test
    public void testSubtract() {
        assertThat(Calculator.subtract(3, 2)).isEqualTo(1);
    }

    @Test
    public void testPrivateConstructor() throws Exception {
        var constructor = Calculator.class.getDeclaredConstructor();

        assertThat(constructor.canAccess(null)).isFalse();

        constructor.setAccessible(true);
        Calculator instance = constructor.newInstance();
        assertThat(instance).isNotNull();
    }

    @Test
    public void testSumWithZero() {
        assertThat(Calculator.sum(0, 5)).isEqualTo(5);
        assertThat(Calculator.sum(5, 0)).isEqualTo(5);
        assertThat(Calculator.sum(0, 0)).isZero();
    }

    @Test
    public void testSubtractWithZero() {
        assertThat(Calculator.subtract(5, 0)).isEqualTo(5);
        assertThat(Calculator.subtract(0, 5)).isEqualTo(-5);
    }

    @Test
    public void testSumWithNegative() {
        assertThat(Calculator.sum(-2, 3)).isEqualTo(1);
        assertThat(Calculator.sum(2, -3)).isEqualTo(-1);
    }

    @Test
    public void testSubtractWithNegative() {
        assertThat(Calculator.subtract(-2, -3)).isEqualTo(1);
        assertThat(Calculator.subtract(2, -3)).isEqualTo(5);
    }
}
