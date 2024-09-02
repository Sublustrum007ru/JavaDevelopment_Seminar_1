package controller;

import view.server.ServerWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    private static final String MSG_GATETYPE = "Выберите режим игры";
    private static final String MSG_PVC = "Человек против компьютера";
    private static final String MSG_PVP = "Человек против человека";
    private static final String MSG_GETSIZE = "Выбирете размер поля";
    private static String MSG_SETSIZE_PREFICX = "Установленный размер поля: ";
    private static final String MSG_GETWINLEN = "Выберите длинну для победы";
    private static String MSG_SETWINLEN_PREFICX = "Установленная длинна: ";
    private static final int MIN_FIELDSIZE = 3;
    private static final int MAX_FIELDSIZE = 10;

    JButton btnStart;
    JLabel label1, label2, label3, label4;
    JSlider fieldSize, winLen;

    SettingWindow(GameWindow gameWindow) {

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);
        setTitle("Settings");
        setResizable(false);
        setLayout(new GridLayout(15, 12));
        add(new JLabel(MSG_GATETYPE));

        ButtonGroup bg = new ButtonGroup();
        JRadioButton pvc = new JRadioButton(MSG_PVC);
        JRadioButton pvp = new JRadioButton(MSG_PVP);
        label1 = new JLabel(MSG_GATETYPE);
        bg.add(pvc);
        bg.add(pvp);
        add(pvc);
        add(pvp);
        add(new JLabel(MSG_GETSIZE));
        label3 = new JLabel(MSG_SETSIZE_PREFICX + MIN_FIELDSIZE);
        fieldSize = new JSlider(MIN_FIELDSIZE, MAX_FIELDSIZE, MIN_FIELDSIZE);
        winLen = new JSlider(MIN_FIELDSIZE, MAX_FIELDSIZE, MIN_FIELDSIZE);
        fieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label3.setText(MSG_SETSIZE_PREFICX + fieldSize.getValue());
                repaint();
            }
        });
        btnStart = new JButton("Start game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, fieldSize.getValue(), fieldSize.getValue(), winLen.getValue());
                setVisible(false);
            }
        });
        add(label3);
        add(fieldSize);
        add(new JLabel(MSG_GETWINLEN));
        label4 = new JLabel(MSG_SETWINLEN_PREFICX + MIN_FIELDSIZE);
        winLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label4.setText(MSG_SETWINLEN_PREFICX + winLen.getValue());
                repaint();
            }
        });
        add(label4);
        add(winLen);
        JPanel panelGroup = new JPanel(new GridLayout(1, 2));
        JButton serverStart = new JButton("Server");
        panelGroup.add(btnStart);
        panelGroup.add(serverStart);
        serverStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServerWindow();
            }
        });
        add(panelGroup, BorderLayout.SOUTH);


    }

}
