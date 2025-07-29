package users;

public class Receiver extends User{
    public Receiver (int userId, String username){
        super(userId, username);
    }

    @Override
    void ack(){
        System.out.println("receive ack");
    }
}