package interviewcodingquestions;

public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "I Love India";

		String[] strdata = str.split(" ");
		
		System.out.println("beofre reverse senetence");

		for (String s : strdata) {

			System.out.print(s+" ");

		}
		System.out.println("");
		System.out.println("After reversse sentence");
		
		for (int i = strdata.length-1; i >= 0; i--) {
			
			System.out.print(strdata[i]+ " ");
			
		}

	}

}
