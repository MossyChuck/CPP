package bot;

import mainclient.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bot implements Runnable
{
    private Map<String, String> messages = new HashMap<>();
    public BlockingQueue<Message> messageQueue;

    public Bot(){
        messages.put("Hello", "Hello");
        messages.put("Bye", "Good bye!");
        messages.put("How are you?", "I'm fine, thank you");
        messageQueue = new LinkedBlockingQueue<>();
    }

    public void addMessage(String request, String response){
        messages.put(request,response);
    }

    @Override
    public void run() {
        while (true){
            Message message;
            while ((message = messageQueue.poll()) != null){
                String outMessage = messages.getOrDefault(message.messageData, "Don`t understand you!");
                if (outMessage != null) {
                    try {
                        message.sender.put(outMessage);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        message.sender.put("I don't know");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}