package by.it.daylidovich.JD01_09;

import by.it.daylidovich.JD01_09.varables.Float.VariableFloat;
import by.it.daylidovich.JD01_09.varables.Matrix.VariableMatrix;
import by.it.daylidovich.JD01_09.varables.Variable;
import by.it.daylidovich.JD01_09.varables.Vector.VariableVector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    public static String readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rLine = reader.readLine();
        return rLine;
    }

    public static String readFirstTerm(String string){
        Matcher matcher = Pattern.compile("([0-9\\[\\]\\{\\}.,]+)([+\\-*/])").matcher(string);
        if (matcher.find())
            return matcher.group(1);
        else
            return null;
    }

    public static String readSecondTerm(String string){
        Matcher matcher = Pattern.compile("([+\\-*/= ])([0-9\\[\\]\\{\\}.,]+)").matcher(string);
        if (matcher.find())
            return matcher.group(2);
        else
            return null;
    }

    public static String readOperation(String string){
        Matcher matcher = Pattern.compile("[+\\-*/=]").matcher(string);
        if (matcher.find())
            return matcher.group();
        else
            return null;
    }

    public static String readNameVarable(String string){
        Matcher matcher = Pattern.compile("([A-z]+)([ =])").matcher(string);
        if (matcher.find())
            return matcher.group(1);
        else
            return null;
    }

    public static Variable getVarable(String string) throws IOException {
        Matcher matcher = Pattern.compile("[\\[\\{]").matcher(string);
        int count = 0;
        while (matcher.find())
            count++;
        switch (count){
            case 0:
                return new VariableFloat(string);
            case 1:
                return  new VariableVector(string);
            default:
                return new VariableMatrix(string);
        }
    }
}
