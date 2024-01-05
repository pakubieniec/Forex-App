package services;

import DataModel.DataFromForexApi;
import DataModel.ExchangeRate;
import Mappers.JSONMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SaveToCsvFile {
    JSONMapper mapper = new JSONMapper();
    DataFromForexApi dataFrom = new DataFromForexApi();
    FetchToTheForexAPI fetch = new FetchToTheForexAPI();
    ExchangeRate er = new ExchangeRate();

    public void addDataToCSV(String output, double exchangeAmount, String date) {
        try {

            BufferedWriter outfile = new BufferedWriter(new FileWriter(output, true));

            CSVWriter writer = new CSVWriter(outfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();
            if (date == null) {
                String fetchInfo = fetch.getRespondsWithLatestDate();
                dataFrom = mapper.mapJsonToJava(fetchInfo);
            } else {
                String fetchInfo = fetch.getRespondsWithHistoricalDate(date);
                dataFrom = mapper.mapJsonToJava(fetchInfo);
            }
            String d = dataFrom.getDate();
            String b = dataFrom.getBase();

            String amount = String.valueOf(er.convertedCurrency(exchangeAmount, date));

            data.add(new String[]{d, b, amount});
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
