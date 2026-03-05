package interviewcodingquestions;

public class SortThreeNumbersSmart {

    public static void main(String[] args) {

        int a = 511;
        int b = 5;
        int c = 1000;

        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        int middle = a + b + c - smallest - largest;

        System.out.println(smallest + "," + middle + "," + largest);
    }
}