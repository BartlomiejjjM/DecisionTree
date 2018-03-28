package decisiontree;

public class Main {

    public static void main(String[] args) {

        Question<Integer, String> root = new Question<>(i -> i >= 0 );
        root.no(new Answer<>("Number is negative"));
        Question<Integer, String> isEven = new Question<>(i -> i%2==0);
        root.yes(isEven);
        isEven.no(new Answer<>("Number is odd"));
        Question<Integer, String> isGreaterThan100 = new Question<>(i -> i > 100);
        isEven.yes(isGreaterThan100);
        isGreaterThan100.no(new Answer<>("Number is even but less or equal 100"));
        isGreaterThan100.yes(new Answer<>("Number is even and greater than 100"));

        System.out.println(root.ask(-7));
        System.out.println(root.ask(1));
        System.out.println(root.ask(4));
        System.out.println(root.ask(55));
        System.out.println(root.ask(98));
        System.out.println(root.ask(104));


    }
}
