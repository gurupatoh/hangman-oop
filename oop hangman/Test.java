
// import java.util.*;
public class Test extends wordbank { // inheritance 


    public static void main(String[] args) {

        wordbank rules = new wordbank();
        rules.dispayRules();
        wordbank category = new wordbank();
        //    call display method to display category
        category.display();
        //    call wordphrase  method to containing wordphrases in the category
        wordbank word = new wordbank();
        word.wordphrase();

    }

}