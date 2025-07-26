package database;

import database.database.Database;
import database.users.*;
import database.message.*;

public class Operations {
    public void add(String stringName){
        Database.getSet().add(stringName);
    }

    private boolean containsUser(String username){
        return Database.getSet().contains(username);
    }

    public void sendMessage(Sender sender, Receiver receiver, String message, String type){
        if (!containsUser(sender.username) || !containsUser(receiver.username)){
            System.out.println("Sender/Receiver not found");
            return;
        }

        switch (type){
            case "EMAIL":
                MessageType.EMAIL.message(message);
                break;
            case "FAX":
                MessageType.FAX.message(message);
                break;
            case "SMS":
                MessageType.SMS.message(message);
                break;
        }
    }
}