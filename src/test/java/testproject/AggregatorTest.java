package testproject;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class AggregatorTest {

    @Test
    public void testInitialState() {
        Aggregator agr = new Aggregator();
        assertThat(agr.getSum()).isZero();
    }

    @Test
    public void testSingleAddition() {
        Aggregator agr = new Aggregator();
        double val = 20;
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val);
    }

    @Test
    public void testMultipleAdditions() {
        Aggregator agr = new Aggregator();
        double val = 15;
        agr.addValue(val);
        agr.addValue(val);
        assertThat(agr.getSum()).isEqualTo(val * 2);
    }
}
