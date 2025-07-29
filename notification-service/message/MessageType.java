package message;

public enum MessageType implements Message{
    EMAIL{
        @Override
        public void message(String message){
            System.out.println("sending email");
        }
    },
    FAX{
        @Override
        public void message(String message){
            System.out.println("sending FAX");
        }
    },
    SMS{
        @Override
        public void message(String message){
            System.out.println("sending sms");
        }
    }
}
