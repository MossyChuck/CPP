package gui;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JButton addFluButton;
    private JButton addAnginaButton;
    private TextArea log;

    public void build() {
        setLayout(new FlowLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        addFluButton = new JButton("Add flu");
        addAnginaButton = new JButton("Add angina");
        addFluButton.setSize(addAnginaButton.getSize());
        log = new TextArea(13, 30);
        log.setEditable(false);
        JScrollPane sp = new JScrollPane(log);
        Log.setTextArea(log);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        buttonPanel.add(addFluButton);
        buttonPanel.add(addAnginaButton);
        getContentPane().add(buttonPanel);
        getContentPane().add(sp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        setResizable(false);
    }

    //public void log(String message) {
    //    log.setText(log.getText() + message + "\n");
    //}

    public JButton getAddAnginaButton() {
        return addAnginaButton;
    }

    public JButton getAddFluButton() {
        return addFluButton;
    }


}
