import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
}
