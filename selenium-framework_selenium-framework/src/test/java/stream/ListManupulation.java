package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListManupulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numberList1=Arrays.asList(1,345,null,123,100,456);
		
		List<Integer> numberList2=numberList1.stream()
		.filter(i->Objects.nonNull(i))
		.filter(i->i.toString().startsWith("1"))
		.collect(Collectors.toList());
		
		System.out.println(numberList2);
	}

}


//List<Integer> numberList=Arrays.asList(1,32,null,123,100,456);
//
//List<Integer> numberList2=numberList.stream()
//.filter(i-> Objects.nonNull(i))
//.filter(i->i.toString().startsWith("1"))
//.collect(Collectors.toList());
//
//
//System.out.println(numberList2)
