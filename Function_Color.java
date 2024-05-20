import java.awt.*;
public class Function_Color {
    GUI gui;
    public Function_Color (GUI gui) {
        this.gui= gui;
    }
    public void changeColor (String color) {
        switch (color ) {
        case "Green" : 
                gui.window.getContentPane().setBackground(Color.green);
                gui.textArea.setBackground(Color.green);
                gui.textArea.setForeground(Color.white);
                break;
        case "Blue" : 
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.black);
            break;
        case "Red" : 
            gui.window.getContentPane().setBackground(Color.red);
            gui.textArea.setBackground(Color.red);
            gui.textArea.setForeground(Color.white);
            break;    
        }
    }
}
