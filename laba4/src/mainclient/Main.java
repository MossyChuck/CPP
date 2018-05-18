package mainclient;

import bot.Bot;
import client.Client;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.List;

public class Main extends Application {

    private static Bot bot;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainclient.fxml"));
        primaryStage.setTitle("Main client");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
        primaryStage.setOnCloseRequest((event) -> {
            try {
                stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread());
    }

    public static void createBot() {
        bot = new Bot();
        new Thread(bot, "Bot").start();
    }

    public static Bot getBot() {
        return bot;
    }

    public static void createClient() {
        try {
            client.Controller controller = new client.Controller();
            controller.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Application.launch(client.Controller.class, "");

        //client.init(bot);
        //clients.add(client);
    }
}