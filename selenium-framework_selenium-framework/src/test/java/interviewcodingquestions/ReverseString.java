package interviewcodingquestions;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="India";
		
		for (int i = input.length()-1; i >=0; i--) {
			
			System.out.print(input.charAt(i));
			
		}

		//----------Another way --------------------------------------
		
		System.out.println("");
		
		String input2="India";
		char [] inputcharaar=input2.toCharArray();
		
		for (int i = input2.length()-1; i>=0 ;i--) {
			
			System.out.print(inputcharaar[i]);
			
		}
		
		
		
		//-------------------------------------
		System.out.println("");
		
		String str = "india";
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed String: " + reversed);
        
        
      //-------------------------------------
      		System.out.println("");
      		
      		

            String str1 = "india";

            String reversed1= new StringBuilder(str1)
                                    .reverse()
                                    .toString();

            System.out.println("Reversed String using StringBuilder: " + reversed1);
	}

}
