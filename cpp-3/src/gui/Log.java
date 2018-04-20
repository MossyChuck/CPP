package gui;

import javax.swing.*;
import java.awt.*;

public class Log {

    private static TextArea textArea;

    public static void log(String message) {
        textArea.setText(textArea.getText() + message + "\n");
    }

    public static void setTextArea(TextArea ta){
        textArea = ta;
    }

}
