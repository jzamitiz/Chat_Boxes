import javax.swing.*;
import java.awt.event.*;

public class ChatBox extends JPanel implements IChat{

    public void chat(String now){
        chat_text.setText(now);
    }

    private ChatSubscriber tp;
    private int number_of_user;
    private JButton send_button;
    private JPanel chat_window;
    private JTextField text_input;
    private JTextArea chat_text;


    public ChatBox(int winNum, ChatSubscriber cs) {

        number_of_user = winNum;
        tp = cs;
        tp.subscribe(this);
        add(chat_window);

        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typed_text;
                String text = text_input.getText();
                chat_text.append("Chatter "+ number_of_user + " : ");
                chat_text.append(text + "\n");
                text_input.setText("");
                typed_text = chat_text.getText();
                tp.chatText(typed_text);
            }
        });
    }

    public JButton getSend_button(){
        return this.send_button;
    }

    public static void setChatBox(int winNum, ChatSubscriber cs){

        JFrame jf = new JFrame();
        jf.add(new ChatBox(winNum,cs));
        jf.setTitle("Chatter " + winNum);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}
