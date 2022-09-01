
/**
 * JAVADOC
 *
 * constructor
 *
 * turnIntoArr() -> turns into an array
 * HangManLogic(String w) - > gets word as private var
 * String wordArr(int i) - passes an into and turns into arr
 * Boolean check(String input) - passes a string and verifies it
 *
 */
import java.util.*;

public class HangManLogic {

    private String word;
    private String[] word2;
    private String[] words;
    private ArrayList<String> tokenWords;
    private int whereToT = 0;
    private ArrayList<Integer> tokenWords2;
    //  private String [] attempts;

    /* constructor sets word as w and the arrays */
    public HangManLogic(String word) {
        this.word = word;
        this.word2 = new String[this.word.length()];
        this.words = new String[this.word.length()];
        this.tokenWords = new ArrayList<>();
        this.tokenWords2 = new ArrayList<>();
        initTokenWords();

        //   this.attempts = new String[Integer.MAX_VALUE];
    }

    /**
     * wordArr
     *
     * @param i
     * @return the sub string of word and it incriminates i
     */
    public String wordArr(int i) { //substring
        return word.substring(i, i + 1);
    }

    public void initTokenWords() {
        StringTokenizer st = new StringTokenizer(word);
        while (st.hasMoreTokens()) {
            tokenWords.add(st.nextToken());

        }
        for (int i = 0; i < tokenWords.size(); i++) {
            tokenWords2.add(tokenWords.get(i).length());
        }
        int e = 0;
        for (int i = 0; i < tokenWords.size(); i++) {
            e = e + tokenWords.get(i).length();
            if (e > 8) {
                System.out.println(e);
                tokenWords2.add(e);
                e=0;
            }
        }
        for(int i = 0; i < tokenWords2.size(); i++){
            System.out.println(tokenWords2.get(i));
        }

    }

    /**
     * turnIntoArr
     *
     */
    public void turnIntoArr() { //turns into arr
        for (int i = 0; i < words.length; i++) {
            words[i] = wordArr(i);
            if (wordArr(i).equals(" ")) {
                word2[i] = " ";
            }
        }
    }

    /**
     * showArr
     *
     * @return String
     */
    public String showArr() {
        String temp = "<html>";
        int i2 = 0;
        int i3=0;
        int i4=0;
        for (int i = 0; i < word2.length; i++) {
            if (word2[i] == null) {
                temp += "_ ";

            } else {
                
                if (word2[i] == " "){
                    temp +="&nbsp;";
                }else{
                    temp += word2[i];
                }
            }
            try {
                if (i == tokenWords.get(i3).length()) {
                    System.out.println("arrayList: "+tokenWords2.get(i2));
//                    System.out.println("i2: "+i2);
                    if (i4 == tokenWords2.get(i2)) {
                        temp += "<br>";
                        i2++;
                        i4=0;
                    }
                   
                    i3++;
                }
                
                

            } catch (Exception e) {
                i2 = 0;

            }
            i4++;

        }
        temp += "</html>";
                
        //obj.setText(temp);   
        return temp;

    }

    /**
     * check
     *
     * @param input
     * @return Boolean
     *
     */
    public boolean check(String input) {
        boolean check = false;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(input) && word2[i] == null) {
                word2[i] = input; //thid inputd if iits in array
                check = true; //sets as trie
            }

        }
        return check;
    }

    /**
     * checks win
     *
     * @return Boolean
     */
    public boolean win() {
        boolean win = false;
        String t = "";
        for (int i = 0; i < word2.length; i++) {
            t += word2[i];

        }
        if (t.equals(word)) {
            win = true;
        }
        return win;
    }

}
