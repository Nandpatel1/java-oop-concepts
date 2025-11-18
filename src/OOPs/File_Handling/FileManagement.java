package OOPs.File_Handling;
import java.io.*;


class Logger {
    private String path;
    Logger(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
        }
        this.path = path;
    }

    public void log(String message){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(message);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Failed to Log this message" + e.getMessage());
        }
    }
}

public class FileManagement {
    public static String filePath = "E:\\Code\\Desktop\\CODE\\OOPs Java\\src\\OOPs\\logfile.txt";

    public static void createFile() throws IOException {
        File file = new File(filePath);
        System.out.println(file.exists());

        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.canRead());
    }

    public static void writeOnFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write("Hello !!");
            bw.newLine();
            bw.write("How are you ?");
            // bw.flush();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFromFile() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
//            String line;
//            while((line = br.readLine()) != null) {
//                System.out.println(line);
//            }

            int ch;
            while((ch = br.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
    }

    public static void tryWithResources() {

        // Don't have to write br.close() for this
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while((ch = br.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
//        FileManagement.createFile();
//        FileManagement.writeOnFile();
//        FileManagement.readFromFile();
//        FileManagement.tryWithResources();

//        Logger logger = new Logger(filePath);
//        logger.log("Log 1");
//        logger.log("Log 2");
//        logger.log("Log 3");
    }
}
