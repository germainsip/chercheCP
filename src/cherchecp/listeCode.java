/*
 *  ___ _                    _                   
 * |_ _| |_  __ __ _____ _ _| |__ ___  ___ _ _   
 *  | ||  _| \ V  V / _ \ '_| / /(_-< / _ \ ' \  
 * |___|\__|  \_/\_/\___/_| |_\_\/__/ \___/_||_| 
 *  _ __ _  _   _ __  __ _ __| |_ (_)_ _  ___    
 * | '  \ || | | '  \/ _` / _| ' \| | ' \/ -_)   
 * |_|_|_\_, | |_|_|_\__,_\__|_||_|_|_||_\___|   
 *       |__/                                    
 */
package cherchecp;

import java.util.*;
import java.util.regex.Pattern;

/**
 * créé le 22 oct. 2018 , 16:53:43
 *
 * @author germain
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;

public class listeCode {

    HashMap<String, String> codepost = new HashMap();

    public void chargement() {
        //lien fichier et type de csv
        String csvFile = "laposte.csv";

        Pattern pattern = Pattern.compile(";");

        String ville;
        BufferedReader br;

        try {

            InputStream is = getClass().getClassLoader().getResourceAsStream("sourceCSV/laposte.csv");
            br = new BufferedReader(new InputStreamReader(is));

            codepost = br
                    .lines()
                    .skip(1)
                    .map(x -> pattern.split(x))
                    .collect(HashMap::new, (map, x)
                            -> map.put(x[3], x[2]),
                            Map::putAll);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        //vérification la création
//        codepost.forEach((k,v) -> System.out.println("ville: "+k+" code postal: "+v));
//        System.out.println("taille du Hash = " + codepost.size());
//        System.out.println("");
//        System.out.println("Entrez une ville");
//        ville = saisieChaine().toUpperCase();
//        
//        System.out.println("Le code postale de "+ville+ " = "+codepost.get(ville));

    }

    /*
    * 
     */

    /**
     * pour passer d'une chaine accentuée à une chaine majuscule sans accent
     *
     * @param c chaine de caractère
     * @return chaine de caractère majuscule sans accent
     */
    public String chaineStandard(String c) {
        String tmp = c.toUpperCase();
        tmp = Normalizer.normalize(tmp, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        tmp = pattern.matcher(tmp).replaceAll("");
        System.out.println(tmp);
        return tmp.toUpperCase();
    }
}
