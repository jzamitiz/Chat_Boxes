import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class ChatSubscriber {

    ArrayList <IChat> subscribers = new ArrayList<>();
    String text;
    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(IChat i : subscribers){
                i.chat(text);
            }
        }
    };

    Timer t = new Timer(1000, listener);

    public void subscribe( IChat newSub){
        subscribers.add(newSub);
    }

    public ChatSubscriber(){
        t.start();
    }

    public void chatText(String s){
        text = s;
    }

}
