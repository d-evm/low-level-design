import database.Database;
import users.*;

class OperationsTest {
    public static void main(String[] args){
        Sender sender = new Sender(11, "user1");
        Receiver receiver = new Receiver(12, "user2");

        Operations operations = new Operations();

        Database db = new Database();

        operations.add(sender.username);
        operations.add(receiver.username);

        operations.sendMessage(sender, receiver, "this is first message", "EMAIL");
    }


}