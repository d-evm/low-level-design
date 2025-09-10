import java.util.ArrayList;
import java.util.List;

// Component Interface
interface SystemComponent{
    String getName();
    double getSize();
}

// Composite Class
class Directory implements SystemComponent{
    private String name;
    private double size;
    private List<SystemComponent> components;

    Directory(String n){
        name = n;
        size = 4.0;
        components = new ArrayList<>();
    }

    public void addComponent(SystemComponent component){
        components.add(component);
        size += component.getSize();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getSize(){
        return size;
    }
}

// Leaf Class
class File implements SystemComponent{
    private String name;
    private double size;

    File(String n, double s){
        name = n;
        size = s;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getSize(){
        return size;
    }
}

public class FileSystem {
    public static void main(String[] args) {
        Directory mainDirectory = new Directory("Main Directory");

        SystemComponent file01 = new File("file01", 270);
        mainDirectory.addComponent(file01);

        Directory subDir1 = new Directory("Sub Directory 1");

        SystemComponent file11 = new File("file11", 309.2);
        SystemComponent file12 = new File("file12", 987.4);
        subDir1.addComponent(file11);
        subDir1.addComponent(file12);

        mainDirectory.addComponent(subDir1);

        Directory emptyDir = new Directory("Empty Directory");
        mainDirectory.addComponent(emptyDir);

        /*
        == Structure ==

        Main Directory
        |
        |-- file01
        |
        |-- Sub Directory 1
        |    |
        |    |-- file11
        |    |-- file12
        |
        |-- Empty Directory
        |

         */

        System.out.println(mainDirectory.getName());
        System.out.println(mainDirectory.getSize());

        System.out.println("---------------------");

        System.out.println(file01.getName());
        System.out.println(file01.getSize());

        System.out.println("---------------------");

        System.out.println(subDir1.getName());
        System.out.println(subDir1.getSize());

        System.out.println();

        System.out.println(file11.getName());
        System.out.println(file12.getSize());

        System.out.println();

        System.out.println(file12.getName());
        System.out.println(file12.getSize());

        System.out.println("---------------------");

        System.out.println(emptyDir.getName());
        System.out.println(emptyDir.getSize());
    }
}
