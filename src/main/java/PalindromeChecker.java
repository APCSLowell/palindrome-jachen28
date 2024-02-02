import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
  {
    String backwards = reverse(word);
  if(word.equals(backwards))
 if(noPunctuation(onlyLetter(noSpaces(word.toLowerCase()))).equals(noSpaces(reverse(noPunctuation(onlyLetter(word.toLowerCase()))))) == true && word.equals(backwards))
    return true;
  return false;
}
public String reverse(String str)
{
    
    String sNew = new String();
  for(int i = str.length()-1; i > -1; i--)
  sNew = sNew + str.substring(i, i+1);

    return sNew;
}

public String noSpaces (String str){
 String s = "";
  for(int i = 0; i < str.length(); i++)
  if(str.substring(i, i+1).equals(" ") != true)
  s = s + str.substring(i, i+1);
  return s;
}

public String noPunctuation(String a){
  String s = new String();
  for(int i = 0; i < a.length(); i++)
    if(a.substring(i, i+1).equals(".") == false && a.substring(i, i+1).equals(",") == false)
      s = a.substring(i, i+1);
  return s;
}

  public String onlyLetter(String b){
    String letters = ""; 
    for(int i = 0; i < b.length(); i++)
      if(Character.isLetter(b.charAt(i)) == true)
       letters = letters + b.substring(i, i+1);
    return letters;
  }
}


