package org.gerblog.tool;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listeCodeV2 {
    //TODO: use opencsv to parse csv
    private List<String[]> listeDuCSV;

    public listeCodeV2() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("sourceCSV/laposte.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        //File csv = new File(getClass().getResourceAsStream("/sourceCSV/laposte.csv"));
        try (CSVReader reader = new CSVReaderBuilder(br).withCSVParser(csvParser).withSkipLines(1).build()) {
            this.listeDuCSV = reader.readAll();
           // r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }

    public List<String> cpSearch(){
        List<String> list = new ArrayList<>();
        listeDuCSV.forEach(x -> {
            if(x[1].equals("AMIENS"))
            {list.add(x[2]);
            System.out.println(x[1]);}
        });
        //list.add(listeDuCSV.get(0)[0]);

       // System.out.println(listeDuCSV.get(0));

        return list;
    }
}
