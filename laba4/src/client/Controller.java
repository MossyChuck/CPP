package client;

import bot.Bot;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainclient.Main;
import mainclient.Message;

import java.util.concurrent.LinkedBlockingQueue;

public class Controller extends Application {
    @FXML
    private TextField sendField;

    @FXML
    private ListView messageView;

    private void Poll() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String message;
            while ((message = Client.stringQueue.poll()) != null) {
                Client.messageView.getItems().add(message);
            }
        }
    }

    Thread thread;

    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 500, 400));
        stage.setOnCloseRequest((event) -> {
            try {
                thread.interrupt();
                stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        stage.show();
        chatBot = Main.getBot();
        Client.stringQueue = new LinkedBlockingQueue<>();
        thread = new Thread(this::Poll);
        thread.start();
    }


    private Bot chatBot;


    @FXML
    public void OnSendButtonClick() throws InterruptedException {
        if (chatBot == null) {
            chatBot = Main.getBot();
        }
        if (Client.messageView == null) {
            Client.messageView = messageView;
        }
        chatBot.messageQueue.put(new Message(sendField.getText(), Client.stringQueue));
        sendField.setText("");
    }
}
