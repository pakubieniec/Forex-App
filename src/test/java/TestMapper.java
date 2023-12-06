import DataModel.ExchangeRate;
import DataModel.ExchangeRateDTO;
import DataModel.ExchangeRateInfo;
import DataModel.ExchangeRateInfoDTO;
import Mappers.ExchangeRateInfoMapper;
import Mappers.ExchangeRateMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMapper {
    ExchangeRate exchangeRate = new ExchangeRate("CAN", 100, 3.8);
    ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO("CAN", 100, 3.8);
    ExchangeRateInfo exchangeRateInfo = new ExchangeRateInfo("2022-01-01");
    ExchangeRateInfoDTO exchangeRateInfoDTO = new ExchangeRateInfoDTO("2022-01-01");

    @Test
    public void exchangeRateDTOObjIsEqualsExchangeRateObj() {
        Assertions.assertEquals(exchangeRate, ExchangeRateMapper.exchangeRateDTOToExchangeRate(exchangeRateDTO));
    }

    @Test
    public void exchangeRateInfoDTOObjIsEqualsExchangeRateInfoObj() {
        Assertions.assertEquals(exchangeRateInfo, ExchangeRateInfoMapper.exchangeRateInfoDTOToExchangeRateInfo(exchangeRateInfoDTO));
    }
}
