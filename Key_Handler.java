import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Class to handle Keyboard Shortcuts

public class Key_Handler implements KeyListener {

    GUI gui;

    public Key_Handler (GUI gui) {
        this.gui  = gui;

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //S key shortcut to save file with control button
        //The save dialog box should open to save a file 
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S ){
            gui.file.save();
        }

        //Keyboard shortcut to save as 
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S ){
            gui.file.saveAs();

            //Keyboard shortcut to open file menu
        }
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F){
            gui.menuFile.doClick();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }


}
