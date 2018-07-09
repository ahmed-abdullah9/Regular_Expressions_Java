import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;


public class RegularExpression {


	public static void main(String[] args) throws IOException {
		
		String entireFileText = new Scanner(new File("string.txt"))
			    .useDelimiter("\\A").next();
		
		
		Pattern lookingfor_ing = Pattern.compile("ing");
		Matcher match = lookingfor_ing.matcher(entireFileText);

		
				int num =0; 
		while(match.find()) {
		
			num++;
		}
		System.out.println("The number of words that are ended by \"ing\" : "+num);
		
		Pattern countinglines = Pattern.compile("\r\n|\r|\n");
		Matcher matchline = countinglines.matcher(entireFileText);
		
		
		int x=1;
		while(matchline.find()) {
			x++;
		}
		
		System.out.println("The number of lines: "+x);

		
		Pattern findnumbers = Pattern.compile("[1-9]\\d{3,}|5[1-9]\\d|5[1-9]{2}");
		Matcher comparenumber = findnumbers.matcher(entireFileText);

		String y="";
		while(comparenumber.find()) {
			y += (comparenumber.group())+" ";
		}
		
		System.out.println("The numbers that are greater than 500 : "+ y);
		
		
		Pattern checkforwords = Pattern.compile("(\\s+)[a,A]+(\\s+\\w+)");
		Matcher matchword = checkforwords.matcher(entireFileText);
		
		boolean found =false; 
		while(matchword.find()) {

			System.out.println("words preceded by a or A :  "+matchword.group());
			found=true;
		}
		
		if(!found) {
			System.out.println("No words preceded by a or A ");
		}
	}

}

