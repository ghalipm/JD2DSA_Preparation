package GoogleFoobarChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * “You’ve caught two of your fellow minions passing coded notes back and forth —
 * while they’re on duty, no less! Worse, you’re pretty sure it’s not job-related —
 * they’re both huge fans of the space soap opera “”Lance & Janice””. You know how
 * much Commander Lambda hates waste, so if you can prove that these minions are
 * wasting her time passing non-job-related notes, it’ll put you that much closer
 * to a promotion.
 *
 * Fortunately for you, the minions aren’t exactly advanced cryptographers.
 * In their code, every lowercase letter [a..z] is replaced with the corresponding
 * one in [z..a], while every other character (including uppercase letters and
 * punctuation) is left untouched. That is, ‘a’ becomes ‘z’, ‘b’ becomes ‘y’, ‘c’
 * becomes ‘x’, etc. For instance, the word “”vmxibkgrlm””, when decoded,
 * would become “”encryption””.
 *
 * Write a function called solution(s) which takes in a string and returns
 * the deciphered string so you can show the commander proof that these
 * minions are talking about “”Lance & Janice”” instead of doing their jobs.”
 *
 * TEST CASES
 * Inputs:
 *
 * (string) s = “wrw blf hvv ozhg mrtsg’h vkrhlwv?”
 *
 * Output:
 *
 * (string) “did you see last night’s episode?”
 *
 * Inputs:
 *
 * (string) s ="Yvzs! I xzm’g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"
 *
 * Output:
 *
 * (string) “Yeah! I can’t believe Lance lost his job at the colony!!”
 * Only small letters encoded, not the capital letters encoded!
 * If you want to use Capital and small letters encoding, then start from regular text:
 * encode regular text and then decode it.
 *
 * Use verify [file] to test your solution and see how it does. When you are
 * finished editing your code, use submit [file] to submit your answer. If your
 * solution passes the test cases, it will be removed from your home folder.
 *
 *Only the lowercase characters need to be deciphered. The other characters remain
 * unchanged. First, create a dictionary to store the encoded characters and
 * their deciphered counterparts. Next, use a for loop to iterate through
 * every character in the input string. If the character is lowercase, pull
 * its deciphered value from the dictionary. If not, add the character to
 * the answer string.
 *
 * In my opinion, this problem was designed to test the participant’s knowledge
 * of the str and dict data types and their built-in methods.
 *
 */
public class GF_Level1_Problem1 {


public static String decoder(String str){
    String strDecoded="";
    for (int i = 0; i <str.length(); i++) {
        int charValue=str.charAt(i);
        //System.out.println(str.charAt(i)+"="+ charValue);
        if(charValue>=97 && charValue<=122) {
            strDecoded = strDecoded +(char)(122 - charValue+97);
        }else{strDecoded+=(char)str.charAt(i);}
    }
    return strDecoded;
}

//using map
public static Map<Character, Character> mapTableSmallLetters(){
    Map<Character, Character> mapSmall = new HashMap<>();
    for (int i = 97; i <123 ; i++) {
        mapSmall.put( (char)i, (char)(122-i+97));
    }
    return mapSmall;
}

    public static Map<Character, Character> mapTableCapitalLetters() {
        Map<Character, Character> mapCapital = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char decodedChar = (char) ('Z' - (ch - 'A'));
            mapCapital.put(ch, decodedChar);
        }
        return mapCapital;
    }

    public static Map<Character, Character> mapTableAllLetters() {
        Map<Character, Character> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char decodedChar = (char) ('z' - (ch - 'a'));
            map.put(ch, decodedChar);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            char decodedChar = (char) ('Z' - (ch - 'A'));
            map.put(ch, decodedChar);
        }
        return map;
    }

    public static String mapDecoder(String str) {
        Map<Character, Character> mapSmall = mapTableSmallLetters();
        Map<Character, Character> mapCapital = mapTableCapitalLetters();

        StringBuilder strDecoded = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (mapSmall.containsKey(currentChar)) {
                strDecoded.append(mapSmall.get(currentChar));
            } else if(mapCapital.containsKey(currentChar)){
                strDecoded.append(mapCapital.get(currentChar));
            }
            else {
                strDecoded.append(currentChar);
            }
        }
        return strDecoded.toString();
    }

    public static Map<Character, Character> mapTableAllLetters2(String str){
        Map<Character, Character> map = new HashMap<>();
        for (int i = 97; i <123 ; i++) {
            map.put( (char)i, (char)(122-i+97));
        }
        for (int i = 65; i <91 ; i++) {
            map.put( (char)i, (char)(90-i+65));
        }
        //System.out.println("mapTableAllLetters = " + map);
        return map;
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        String strCoded="Yvzs! I xzm’g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!";
        String strFull="Greetings from Canada! We welcome immigrants here, but be realistic, there is no such a thing called Canadian Dream!";
        //print char value
//       System.out.println((char)'a'+"="+(int)'a'); //a=97
//       System.out.println((char)'z'+"="+(int)'z'); // z=122
//        System.out.println((char)'A' + "=" + (int)'A');//A=65
//        System.out.println((char)'Z' + "=" + (int)'Z');//Z=90

        System.out.println("mapTableSmallLetters() = " + mapTableSmallLetters());
        System.out.println("mapTableCapitalLetters() = " + mapTableCapitalLetters());
        System.out.println("strCoded = " + strCoded);
        System.out.println("decoder(strCoded) = " + decoder(strCoded));
        System.out.println("==================================");
        System.out.println("mapDecoder(strCoded) = " + mapDecoder(strCoded));

        String strOriginal="Hi Son! I am going to give you hundred dollar if you find out what the magic word is. " +
                "It is 'Drop me 100$ in my pocket please!!' ";

        String decodedSmallLetters=decoder(strCoded);
        String decodedAllLetters=mapDecoder(strCoded);
        System.out.println("=============================");
        System.out.println("decodedSmallLetters = " + decodedSmallLetters);
        System.out.println("decodedAllLetters = " + decodedAllLetters);
        System.out.println("++++++++++++++++++");
        String twiceDecoding=decoder(decodedAllLetters);
        System.out.println("decoder(decoder(strToBeEncoded)) = " + twiceDecoding);
        //Assert.assertEquals( twiceDecoding,strToBeEncoded);

        System.out.println("mapTableAllLetters() = " + mapTableAllLetters());
        System.out.println("======decoder vs mapDecoder======");
        String oneDecoded=mapDecoder(strFull);
        System.out.println("mapDecoder(strFull) = " + mapDecoder(strFull));
        String twiceDecoded=mapDecoder(oneDecoded);
        System.out.println("twiceDecoded = " + twiceDecoded);


    }

}
