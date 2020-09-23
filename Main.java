import java.util.*;

public class Main {
    public static void main(String[] args) {

        int number_of_users;
        ChatSubscriber addSubscription = new ChatSubscriber();
        Scanner input = new Scanner(System.in);
        System.out.println("*************Welcome to Chatter App!**************\n");
        System.out.println("How many Chatters would you like to have? Enter a number! ");
        number_of_users = input.nextInt();

        for (int i = 1; i <= number_of_users; i++)
        {
            new ChatBox(i, addSubscription);
            ChatBox.setChatBox(i, addSubscription);
        }
    }
}
