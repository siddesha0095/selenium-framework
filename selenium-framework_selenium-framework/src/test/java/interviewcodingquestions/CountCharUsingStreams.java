package interviewcodingquestions;

public class CountCharUsingStreams {

    public static void main(String[] args) {

        String str = "abqwaaassaa";

        long count = str.chars()
                        .filter(ch -> ch == 'a')
                        .count();

        long count1=str.chars().filter(ch->ch=='a').count();
        System.out.println("Count of a: " + count);
        System.out.println("Count of a: " + count1);
    }
}
