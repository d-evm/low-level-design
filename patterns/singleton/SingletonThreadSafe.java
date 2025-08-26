public class SingletonThreadSafe {
    public static SingletonThreadSafe instance;

    private SingletonThreadSafe(){}

    public static SingletonThreadSafe getInstance(){
        if (instance == null){
            synchronized (SingletonThreadSafe.class){
                if (instance == null){
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }
}
