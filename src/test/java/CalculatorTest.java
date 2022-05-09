import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void before(){
        calculator = new Calculator();
    }

    @Test
    public void canAdd(){
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void canSubtract(){
        assertEquals(2, calculator.subtract(4,2));
    }

    @Test
    public void canMultiply(){
        assertEquals(9, calculator.multiply(3, 3));
    }

    @Test
    public void canDivide(){
        assertEquals(5, calculator.divide(25, 5), 0.0);
    }
}
