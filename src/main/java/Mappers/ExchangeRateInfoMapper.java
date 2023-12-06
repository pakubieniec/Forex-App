package Mappers;

import DataModel.ExchangeRateInfo;
import DataModel.ExchangeRateInfoDTO;

public class ExchangeRateInfoMapper {
    public static ExchangeRateInfo exchangeRateInfoDTOToExchangeRateInfo(ExchangeRateInfoDTO exchangeRateInfoDTO) {
        ExchangeRateInfo exchangeRateInfo = new ExchangeRateInfo();
        exchangeRateInfo.setDate(exchangeRateInfoDTO.getDate());
        return exchangeRateInfo;
    }
}
