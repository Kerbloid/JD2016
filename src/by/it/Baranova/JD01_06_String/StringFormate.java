package by.it.Baranova.JD01_06_String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ekaterina on 2/13/16.
 */
public class StringFormate {

    public static String[] StringToArray(String sb){
        Pattern p1=Pattern.compile("[-,;:.!?\\s]+");
        String [] words=p1.split(sb);

        return words;


    }

    /**
     * Меняет пятый символ в словах короче 7 символов, и 7 в словах длинее 7 на "#"
     * @param sb текст, передоваемый для форматирования
     * @return sbnew отформатированный текст
     */
    public static StringBuffer ReplaceCharAt (String sb){
      StringBuffer sbnew=new StringBuffer(sb);
      String regex="([А-Яа-яё]{5,})";
      Pattern p1=Pattern.compile(regex);
      Matcher m1=p1.matcher(sbnew);
      while (m1.find()) {
          int pos = m1.start();
          if (m1.group().length() <= 6) {
              sbnew.setCharAt(pos + 4, '#');
          }
          if (m1.group().length() > 6) {
              sbnew.setCharAt(pos + 6, '#');
          }
      }
      return sbnew;
      }

    /**
     * Подсчитывает сколько раз каждое слово повторяется в тексте
     * @param poetry передает матрицу слов, составляющих отрывок
     */
    public static void WordsQuantity (String [] poetry){
        int n=poetry.length;
        String [] wordsnew=new String[n];
        for (int i=0;i<n;i++){
            wordsnew[i]=poetry[i];
        }
        String regex="[А-Яа-яё]{1,}";
        Pattern p1=Pattern.compile(regex);
        for (int i=0;i<n;i++) {
            Matcher m1=p1.matcher(wordsnew[i]);
            boolean b=m1.matches();
            int kol=1;
            for (int j = i + 1; j < n; j++) {
                if (wordsnew[i].equalsIgnoreCase(wordsnew[j])==true&&b==true){
                    kol++;
                    wordsnew[j]="#";
                }
            }
            if (b==true){
                System.out.println("Слово '"+wordsnew[i]+"' встречается "+kol+" раз ");
            }
        }
    }

    /**
     * Подсчитывает количество слов, начинающихся и заканчивающихся гласной
     * @param sb текст, передоваемый для форматирования
     * @return
     */
    public static int VowelQuantity (String sb){

        String regex="\\b[аоеиуыэюяАОЕИУЫЭЮЯ]\\b";
        String regex2="(\\b[аоеиуыэюяАОЕИУЫЭЮЯ])([А-Яа-яё]{0,})([аоеиуыэюяАОЕИУЫЭЮЯ]\\b)";
        Pattern p1=Pattern.compile(regex);
        Pattern p2=Pattern.compile(regex2);
        int kol=0;
        Matcher m1=p1.matcher(sb);
        Matcher m2=p2.matcher(sb);
        while (m1.find()){
            kol++;
        }
        while (m2.find()){
            kol++;
        }
        return kol;
    }

    /**
     * Remove all words that begin from consanant and concern 5 letters
     * @param sb - line that should be formatted
     * @return new line without word
     */
    public static String DeleteFiveLetters (String sb) {
        String sbnew = new String(sb);
        String regex = "(\\b[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧЩШ])([А-Яа-яё]{4})\\b";
        String sb_removedwords = sbnew.replaceAll(regex, "");

        return sb_removedwords;
    }

    /**
     * Сортировка предложений по убыванию в них количества слов в них
     * @param sb текст, передоваемый для форматирования
     */
    public static  void SortSentences (String sb){
        String sbnew=new String(sb);
        sbnew=sbnew.replaceAll("\n"," ");
        Pattern p1=Pattern.compile("[;:.!?]{1,} ");
        String [] sentences=p1.split(sbnew);
        int n=sentences.length;

        String regex="([А-Яа-яё]{1,})";
        Pattern p2=Pattern.compile(regex);
        int [] wordsquantity=new int [n];
        for (int i=0;i<n;i++){
            int kol=0;
            Matcher m1=p2.matcher(sentences[i]);
            while (m1.find()){
                kol++;
            }
            wordsquantity[i]=kol;
        }

        //Сортируем массивы по убыванию
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (wordsquantity[i]<wordsquantity[j]){
                    int extra=wordsquantity[i];
                    wordsquantity[i]=wordsquantity[j];
                    wordsquantity[j]=extra;
                    String extraS=sentences[i];
                    sentences[i]=sentences[j];
                    sentences[j]=extraS;
                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.println(sentences[i]+" ");
        }
    }
}


