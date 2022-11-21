package src;
import java.io.FileReader;
import java.io.IOException;

public class FileObserver {


    public FileObserver(String fileName, String versionName){
        
    
        
        createFile(fileName);
        createFile(versionName);
    
        for (int i = 1; i < 10; i++) {
            // write data to file
            writeToFile(fileName);
            // Simultaneous write versions
            writeToFile(versionName, i);
            // Listener to read file version
            int fileVersion = Integer.parseInt(readOneLineFromFile(versionName));
            
            if (version == fileVersion) {
                System.out.println("The version has not changed");
            } else {
                System.out.println("The version has changed, and business processing is performed");
            }
    
            Thread.sleep(100);
        }

    }


    public void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
             boolean result = file.createNewFile();
             System.out.println("create file：" + result);
        }
    }

    public static void writeToFile(String fileName) throws IOException {
        writeToFile(fileName, new Random(1000).nextInt());
    }
    
}
