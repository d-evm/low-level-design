package users;

public class Sender extends User{
    public Sender (int userId, String username){
        super(userId, username);
    }

    @Override
    void ack(){
        System.out.println("send ack");
    }
}