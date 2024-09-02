package view.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientWindow extends JFrame {
    private final int WIDTH = 450;
    private final int HEGHT = 450;
    private final JPanel panelTOP = new JPanel(new GridLayout(2, 3));
    private final JTextField textFiledIP = new JTextField("127.0.0.1", 16);
    private final JTextField textFieldPort = new JTextField("8189", 5);
    private final JTextField textFiedLog = new JTextField("Sublustrum007", 15);
    private final JPasswordField textFieldPWD = new JPasswordField("Password");
    private final JButton btnConnect = new JButton("Connetc");

    private final JPanel panelChat = new JPanel(new GridLayout(1,2));
    private final JTextArea textAreaChat = new JTextArea(15, 15);

    private final JTextArea textAreaSendMsg = new JTextArea();
    private final JButton btnSend = new JButton("Send");
    private final JPanel panelBOTTOM = new JPanel(new GridLayout(1,2));

    private final JList listUsers = new JList<>();
    private final String[] users = {"Ivan", "Vadim", "Evgeniy", "Anton"};


    public ClientWindow(){
        setTitle("Client");
        setSize(WIDTH, HEGHT);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);


        textFieldPWD.setEchoChar('*');
        panelTOP.add(textFiledIP);
        panelTOP.add(textFieldPort);
        panelTOP.add(textFiedLog);
        panelTOP.add(textFieldPWD);
        panelTOP.add(btnConnect);
        add(panelTOP, BorderLayout.NORTH);
        repaint();

        listUsers.setListData(users);
        JScrollPane scrollPane = new JScrollPane(listUsers);
        panelChat.add(textAreaChat);
        panelChat.add(scrollPane);
        add(panelChat);
        repaint();

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaChat.setText(textAreaSendMsg.getText() + "\n");
                repaint();
            }
        });
        panelBOTTOM.add(textAreaSendMsg);
        panelBOTTOM.add(btnSend);
        add(panelBOTTOM, BorderLayout.SOUTH);
        repaint();


    }

}
