import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Function_File {
    GUI gui;
    String fileName;
    String fileAddress;


    public Function_File ( GUI gui) {
        this.gui = gui;
       

    }

    public void newFile () {
        //What happens when new is clicked
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }


    //Method to open  a file dialog, 
    //display the file name on the title name 
    //get the directory of the file
    public void open () {

        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        //Test if we can return the file name and directory address 

        System.out.println("File name and address:  " + fileAddress  + " " + fileName);

        //Open a reader to read a file 
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName)); //to fetch the adress in order to read the file
            
            gui.textArea.setText(" ");
            String line = null;

            while ((line = bufferedReader.readLine()) != null ) {
                gui.textArea.append( line + "\n");
            }
            bufferedReader.close();

        } catch ( IOException e){
            System.out.println("FILE NOT OPENED");
        }
    }

    //Method to save file 
    public void save () {
        if (fileName == null) {
            saveAs();
        } 
        else {
            try {
                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                fileWriter.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void saveAs () {
        //Overrides the content of the file name 
        FileDialog fileDialog = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fileWriter = new FileWriter(fileAddress+ fileName);
            fileWriter.write(gui.textArea.getText());
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("SOMETHING WRONG");
        }
    }

    //method to exit the application
    public void exit () {
        System.exit(0);
    }
}
