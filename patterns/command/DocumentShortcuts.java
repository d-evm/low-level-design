// Receiver - performs the action
class Document{
    public void save(){
        System.out.println("Document saved.");
    }

    public void open(){
        System.out.println("Document opened.");
    }
}

// Command Interface
interface ActionListenerCommand{
    void execute();
}

// Concrete command
class ActionOpen implements ActionListenerCommand{
    final private Document doc;

    ActionOpen(Document doc){
        this.doc = doc;
    }

    @Override
    public void execute(){
        doc.open();
    }
}

// Concrete Command
class ActionSave implements ActionListenerCommand{
    final private Document doc;

    ActionSave(Document doc){
        this.doc = doc;
    }

    @Override
    public void execute (){
        doc.save();
    }
}

// Invoker
class MenuOptions {
    private ActionListenerCommand openCommand;
    private ActionListenerCommand saveCommand;

    public MenuOptions(ActionListenerCommand open, ActionListenerCommand save) {
        this.openCommand = open;
        this.saveCommand = save;
    }

    public void clickOpen() {
        openCommand.execute();
    }

    public void clickSave() {
        saveCommand.execute();
    }
}


public class DocumentShortcuts {
    public static void main(String[] args) {
        Document doc = new Document();

        ActionListenerCommand open = new ActionOpen(doc);
        ActionListenerCommand save = new ActionSave(doc);

        MenuOptions menu = new MenuOptions(open, save);

        menu.clickOpen();
        menu.clickSave();
    }
}
