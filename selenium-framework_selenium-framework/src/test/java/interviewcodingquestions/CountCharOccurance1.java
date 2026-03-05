package interviewcodingquestions;

public class CountCharOccurance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="abaaacaawwwwa";
		
		char inputarr[]=input.toCharArray();
		int count=0;
		
		for (int i = 0; i < input.length()-1; i++) {
			
			if (inputarr[i]=='a')
			{
				count=count+1;
			}
			
		}
		
		System.out.println("A oocurance "+count);

	}

}
