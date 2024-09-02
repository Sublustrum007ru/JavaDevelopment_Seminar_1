package view.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame{

    private static final int WIDTH = 300;
    private static final int HEIDTH = 350;
    private static boolean isServerWorking = false;

    JPanel pnButton, pnState;
    JButton btnStart, btnStop;
    JTextArea textArea;

    public ServerWindow(){
        setTitle("Server");
        setSize(WIDTH, HEIDTH);
        setVisible(true);
        setLocationRelativeTo(null);
        pnButton = new JPanel(new GridLayout(1, 3));
        pnState = new JPanel(new GridLayout(1,1));
        textArea = new JTextArea("Server is spoted" + isServerWorking);
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking == true){
                    textArea.setText("The server is already runnig");
                    return;
                }
                isServerWorking = true;
                textArea.setText("Server started " + isServerWorking);
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking == false){
                    textArea.setText("The server is already stopped");
                    return;
                }
                isServerWorking = false;
                textArea.setText("Server stopped " + isServerWorking);
            }
        });
        pnState.add(textArea);
        add(pnState, BorderLayout.SOUTH);
        pnButton.add(btnStart);
        pnButton.add(btnStop);
        add(pnButton, BorderLayout.CENTER);
        repaint();
    }

}
