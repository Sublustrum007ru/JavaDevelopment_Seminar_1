package view.client;

import controller.impl.FileOperation;
import view.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ClientGUI extends JFrame {
    private final int WIDTH = 450;
    private final int HEGHT = 450;
    private final JPanel panelTOP = new JPanel(new GridLayout(2, 3));
    private final JTextField textFiledIP = new JTextField("127.0.0.1", 16);
    private final JTextField textFieldPort = new JTextField("8189", 5);
    private final JTextField textFiedLog = new JTextField("Sublustrum007", 15);
    private final JPasswordField textFieldPWD = new JPasswordField("Password");
    private final JButton btnConnect = new JButton("Connetc");

    private final JPanel panelChat = new JPanel(new GridLayout(1, 2));
    private final JTextArea textAreaChat = new JTextArea(15, 15);

    private final JTextArea textAreaSendMsg = new JTextArea();
    private final JButton btnSend = new JButton("Send");
    private final JPanel panelBOTTOM = new JPanel(new GridLayout(1, 2));

    private final JList listUsers = new JList<>();
    private final String[] users = {"Ivan", "Vadim", "Evgeniy", "Anton", "Nataliya", "Anastsiya", "Ekaterina", "Sergey", "Tatyana", "Valentin", "Varvara"};
    private final FileOperation fo = new FileOperation();

    public ClientGUI() {
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
        JScrollPane scrollPane1 = new JScrollPane(textAreaChat);
        JScrollPane scrollPane2 = new JScrollPane(listUsers);
        panelChat.add(scrollPane1);
        panelChat.add(scrollPane2);
        add(panelChat);
        repaint();


        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ServerGUI.checkServerWorking()) {
                    sendMSG(textAreaSendMsg.getText());
                    clerFieldMSG();
                }
            }
        });

        textAreaSendMsg.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (ServerGUI.checkServerWorking()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String msg = textAreaSendMsg.getText();
                        sendMSG(msg);
                        clerFieldMSG();
                    }
                }else{
                    clerFieldMSG();
                }
            }

        });

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ServerGUI.checkServerWorking()) {
                    textAreaChat.setText(null);
                    List<String> temp = fo.readFile("log.txt");
                    for (int i = 0; i < temp.size(); i++) {
                        textAreaChat.append(temp.get(i) + '\n');
                        textAreaChat.setLineWrap(true);
                        textAreaChat.setWrapStyleWord(true);
                        repaint();
                    }
                }


            }
        });

        panelBOTTOM.add(textAreaSendMsg);
        panelBOTTOM.add(btnSend);
        add(panelBOTTOM, BorderLayout.SOUTH);
        repaint();


    }

    public void sendMSG(String message) {
        if (!textAreaSendMsg.getText().isEmpty()) {
            textAreaChat.append(textFiedLog.getText() + ": " + message.replace("\n","") + "\n");
            fo.writeFile("log.txt", textFiedLog.getText() + ": " + message.replace("\n",""));
            repaint();
        }
    }

    public void clerFieldMSG() {
        textAreaSendMsg.setText(null);
    }
}
