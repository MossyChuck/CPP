import javax.swing.*;
import java.awt.*;

public class Log extends JTextArea {

    public void log(String message) {
        this.setText(this.getText() + message + "\n");
    }

    public Log() {
        super();
    }

    public Log(int rows, int cols) {
        super();
        this.setRows(rows);
        this.setColumns(cols);
    }
}
