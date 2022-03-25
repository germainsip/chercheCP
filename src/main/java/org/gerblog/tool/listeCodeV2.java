package org.gerblog.tool;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listeCodeV2 {
    private List<String[]> listeDuCSV;

    public listeCodeV2() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("sourceCSV/laposte.csv");
        assert is != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        //File csv = new File(getClass().getResourceAsStream("/sourceCSV/laposte.csv"));
        try (CSVReader reader = new CSVReaderBuilder(br).withCSVParser(csvParser).withSkipLines(1).build()) {
            this.listeDuCSV = reader.readAll();
           // r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    /**
     * renvoie la liste des codes postaux de la ville s'ils existent
     * @param ville ville à rechercher
     * @return liste des codes postaux
     */
    public List<String> cpSearch(String ville){
        List<String> list = new ArrayList<>();
        String villeStd = chaineStandard(ville);
        listeDuCSV.forEach(x -> {
            if(x[1].equals(villeStd)) list.add(x[2]);
        });
        return list;
    }

    /**
     * pour passer d'une chaine accentuée à une chaine majuscule sans accent
     *
     * @param chaine chaine de caractère
     * @return chaine de caractère majuscule sans accent
     */
    private String chaineStandard(String chaine){
        String tmp = StringUtils.stripAccents(chaine);
        return tmp.toUpperCase();
    }
}
