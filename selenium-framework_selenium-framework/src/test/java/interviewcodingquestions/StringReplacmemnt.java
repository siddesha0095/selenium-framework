package interviewcodingquestions;

public class StringReplacmemnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data ="My name is siddesha";
		
		char [] dataarray=data.toCharArray();
		
		for (int i = 0; i < dataarray.length; i++) {
			
			if (dataarray[i]==' ') {
				
				dataarray[i]='_';
			}
			
		}
		System.out.println(dataarray);
	}

}
