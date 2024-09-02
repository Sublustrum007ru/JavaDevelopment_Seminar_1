package controller;

import view.client.ClientWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIDTH = 507;

    JButton btnStart, btnExit, btnChat;
    SettingWindow settingWindow;
    Map map;

    public GameWindow(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIDTH);

        setLocationRelativeTo(null);
        setTitle("Крести / Нолики");
        setResizable(false);
        btnStart = new JButton("Settings for \"New Game\"");
        btnChat = new JButton("Chat");
        btnExit = new JButton("Exit");
        settingWindow = new SettingWindow(this);
        map = new Map();

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientWindow();
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1,3));
        panBottom.add(btnStart);
        panBottom.add(btnChat);
        panBottom.add(btnExit);

        add(panBottom, BorderLayout.NORTH);
        add(map);

        setVisible(true);
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX,sizeY, winLen);
    }
}
