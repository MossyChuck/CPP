import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JButton complainButton;
    private JButton addDiseaseButton;
    private Log log;

    public Log getLog() {
        return log;
    }

    public void build() {
        setLayout(new FlowLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        complainButton = new JButton("Complain");
        addDiseaseButton = new JButton("Add disease");
        complainButton.setSize(addDiseaseButton.getSize());
        log = new Log(13, 30);
        log.setEditable(false);
        JScrollPane sp = new JScrollPane(log);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        buttonPanel.add(complainButton);
        buttonPanel.add(addDiseaseButton);
        getContentPane().add(buttonPanel);
        getContentPane().add(sp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        setResizable(false);
    }

    public void log(String message) {
        log.setText(log.getText() + message + "\n");
    }

    public JButton getAddDiseaseButton() {
        return addDiseaseButton;
    }

    public JButton getComplainButton() {
        return complainButton;
    }


}
