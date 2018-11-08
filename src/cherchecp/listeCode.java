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

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * créé le 22 oct. 2018 , 16:53:43
 * @author germain
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class listeCode {

    
   
    public static void chargement() {
        //lien fichier et type de csv
        String csvFile = "/sourceDonnees/laposte_hexasmal.csv";
        
        Pattern pattern = Pattern.compile(";");
        
        HashMap<String,String> codepost = new HashMap(); 
        String ville;
        

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {



            codepost = br
            .lines()
            .skip(1)
            .map(x -> pattern.split(x))
            
            .collect(HashMap::new, (map, x) ->
            map.put(x[3], x[2]),
            Map::putAll);

        } catch (IOException e) {
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

}