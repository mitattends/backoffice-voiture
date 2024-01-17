package com.example.backofficeVoiture.util;

public class Utilities {
    public static String buildStringSequence(String prefix, int number, Long sequence){
        String sequenceString = sequence + "";
        int sizeString = sequenceString.length();
        String zero = "";
        while(sizeString < number){
            zero += "0";
            sizeString += 1;
        }
        return  prefix + zero + sequence;
    }
}
