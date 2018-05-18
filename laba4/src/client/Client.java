package client;

import javafx.scene.control.ListView;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client{

    public static BlockingQueue<String> stringQueue = new LinkedBlockingQueue<>();
    public static ListView messageView;

}