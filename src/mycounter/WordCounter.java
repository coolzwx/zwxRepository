/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class WordCounter {

    private String inFile;
    private String outFile;
//    private static String testString = "Any english text";
    private static String testString = "Any english text";

    public WordCounter(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    private Hashtable words = new Hashtable();

    public Hashtable getWords() {
        return words;
    }

    public void countWords() {
        try {
            Reader reader;
            if (inFile == null) {
                reader = new StringReader(testString);
            } else {
                reader = new FileReader(inFile);
            }
            BufferedReader br = new BufferedReader(reader);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                StringTokenizer st;
                st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();;
                    if (words.containsKey(token)) {
                        Object val = words.get(token);
                        int n = (int) val;
                        n++;
                        words.put(token, n);

                    } else {
                        words.put(token, 1);
                    }
                }
            }
            br.close();
        } catch (Exception ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
