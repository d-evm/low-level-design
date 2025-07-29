package database;

import java.util.HashSet;
import java.util.Set;

public class Database {
    private static Set<String> db;

    public Database(){
        db = new HashSet<>();   // lazy initialization
    }

    public static Set<String> getSet(){
        return db;
    }
}
