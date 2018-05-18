package mainclient;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField request;

    @FXML
    TextField response;

    public void onStartBotButtonClick(){
        Main.createBot();
        System.out.println("Bot started");
    }

    public void onCreateClientButtonClick(){
        Main.createClient();
        System.out.println("Client created");
    }

    public void onCreateAnswerButtonClick(){
        Main.getBot().addMessage(request.getText(),response.getText());
        request.setText("");
        response.setText("");
    }
}