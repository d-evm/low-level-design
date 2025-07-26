package database.users;

public abstract class User {
    public int userId;
    public String username;

    abstract void ack();

    User (int userId, String username){
        this.userId = userId;
        this.username = username;
    }
}