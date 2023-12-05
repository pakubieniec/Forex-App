package Mappers;

import DataModel.ExchangeRate;
import DataModel.ExchangeRateDTO;

public final class ExchangeRateMapper {
    public static ExchangeRate exchangeRateDTOToExchangeRate(ExchangeRateDTO exchangeRateDTO) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setTicker(exchangeRateDTO.getTicker());
        exchangeRate.setExchangeAmount(exchangeRateDTO.getExchangeAmount());
        exchangeRate.setRate(exchangeRateDTO.getRate());
        exchangeRate.convertedCurrency(exchangeRateDTO.convertedCurrency(exchangeRateDTO.getExchangeAmount()));
        return exchangeRate;
    }
}
