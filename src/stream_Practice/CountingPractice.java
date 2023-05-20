package stream_Practice;

import java.util.Arrays;

public class CountingPractice {
    public static void main(String[] args) {
        String text="Python is a high level programming language. Python is predominantly used in Data Sciences ";
        String word="Python";
        //count the number of elements in the stream
        long count = CountingPractice.word_counting_in_list(text);
        System.out.println(" Total word count in  the text = " + count);

        System.out.println(" The word "+word + " showed up " + count_word_frequency_in_list(text, word)+" times in the text");

    }

    public static long word_counting_in_list(String list){
        return list.split(" ").length;
    }

    public static long count_word_frequency_in_list(String list, String str){
        return Arrays.stream(list.split(" ")).filter(w -> w.equals(str)).count();
    }

}
