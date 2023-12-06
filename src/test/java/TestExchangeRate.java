import DataModel.ExchangeRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TestExchangeRate {

    ExchangeRate er = new ExchangeRate();
    @Test
    public void exchange100EURget420ZL(){
        Assertions.assertEquals(420.0, er.convertedCurrency(100));
    }

    @Test
    public void exchange330EURget1386ZL(){
        Assertions.assertEquals(1386.0, er.convertedCurrency(330));
    }

    @Test
    public void exchange0EURget0ZL() {
        Assertions.assertEquals(0, er.convertedCurrency(0));
    }

    @Test
    public void exchangeMinus50EURget0ZL() {
        Assertions.assertEquals(0, er.convertedCurrency(-50));
    }
}
