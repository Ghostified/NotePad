import java.awt.FileDialog;

public class Function_File {
    GUI gui;
    public Function_File ( GUI gui) {
        this.gui = gui;

    }

    public void newFile () {
        //What happens when new is clicked
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open () {

        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
    }
}
