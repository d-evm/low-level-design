public class Logger {
    private static volatile Logger instance;

    private Logger(){
        System.out.println("Logger instance created by " + Thread.currentThread().getName());
    }

    public static Logger getInstance(){
        if (instance == null){
            synchronized (Logger.class){
                if (instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log (String message){
        System.out.println(Thread.currentThread().getName() + " logs: " + message);
    }
}
