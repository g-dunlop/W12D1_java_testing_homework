

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterTest {
    Printer printer;

    @Before
    public void before(){
        printer = new Printer(50, 100);
    }

    @Test
    public void hasSheets(){
        assertEquals(50, printer.getSheets());
    }

    @Test
    public void hasToner(){
        assertEquals(100, printer.getToner());
    }

    @Test
    public void calculatesPagesToPrint(){
        int total = printer.calculateTotalPagesToPrint(5, 10);
        assertEquals(50,total );
    }

    @Test
    public void hasEnoughPaper(){
        int total = printer.calculateTotalPagesToPrint(5, 10);
        assertEquals(true, printer.checkEnoughPaper(printer.getSheets(), total));
    }

    @Test
    public void hasNotEnoughPaper(){
    int total = printer.calculateTotalPagesToPrint(6, 10);
    assertEquals(false, printer.checkEnoughPaper(printer.getSheets(), total));
    }

    @Test
    public void canReducePaperLeft(){
        int total = printer.calculateTotalPagesToPrint(5, 10);
        printer.checkEnoughPaper(printer.getSheets(), total);
        printer.changePaperLeft(printer.getSheets(), total);
        assertEquals(0, printer.getSheets());
    }

    @Test
    public void canReduceToner(){
        int total = printer.calculateTotalPagesToPrint(5, 10);
        printer.checkEnoughPaper(printer.getSheets(), total);
        printer.changePaperLeft(printer.getSheets(), total);
        printer.changeTonerLeft(printer.getToner(), total);
        assertEquals(50, printer.getToner());
    }

    @Test
    public void canRunPrintFunction(){
        printer.print(10, 5);
        assertEquals(0, printer.getSheets());
        assertEquals(50, printer.getToner());
    }
}
