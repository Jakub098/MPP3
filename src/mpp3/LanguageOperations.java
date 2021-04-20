package mpp3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LanguageOperations {

    private String fileName;

    private FileReader fr;
    private BufferedReader br;
    String line;

    private List<Language> myLangList;
    private Map<Character, Integer> signsCounter = new HashMap<Character, Integer>();
    char[] array = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public LanguageOperations(String fileName) {
        this.fileName = fileName;
        getDataFromFile(fileName);

//        prepairMap();
        printHashMap();
//        printList();

    }

    public void getDataFromFile(String fileName) {
        String[] tmpData;
        String textToUpdate;
        myLangList = new ArrayList<>();

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            line = "";
            textToUpdate = "";
            while ((line = br.readLine()) != null) {
                LanguageName langName;
                tmpData = line.split("\t");
//                System.out.println(line);
//                System.out.println(tmpData[0]);

                switch (tmpData[0]) {
                    case "NO":
                        langName = LanguageName.NO;
                        break;
                    case "DA":
                        langName = LanguageName.DA;
                        break;
                    case "SV":
                        langName = LanguageName.SV;
                        break;
                    default:
                        langName = null;
                }

//                textToUpdate = tmpData[1];
                textToUpdate = wrapString(tmpData[1]);
//                System.out.println(textToUpdate);
//                System.err.println(tmpData[1].getClass());



                myLangList.add(new Language(
                        langName, textToUpdate
                ));

//                System.err.println(textToUpdate);
                for (Character c : textToUpdate.toCharArray()){
                    if (signsCounter.containsKey(c)) signsCounter.replace(c, signsCounter.get(c).intValue() + 1);
                    else signsCounter.put(c, 1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printList() {
        for (Language language : myLangList) {
            System.out.println(language);

        }
    }

    public String wrapString(String exampleText) {

        return exampleText.replaceAll("\\W", "").toLowerCase();
    }

    public void printHashMap() {
        for (int i = 0 ; i < array.length ; i++){
            System.out.println(array[i] + ": " + (signsCounter.get(array[i]) == null ? "0" : signsCounter.get(array[i])));
        }
    }

}
