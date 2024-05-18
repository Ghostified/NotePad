import java.awt.Font;
public class Function_Formart {

    GUI gui;
    Font arial, comicSansMs, felipa, algerian;
    String selectedFont;

    public Function_Formart  (GUI gui) {
        this.gui = gui; 
    }

    public void wordWrap () {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.itemWrap.setText("Word Wrap: On");
        }
        else if (gui.wordWrapOn == true){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.itemWrap.setText("Word Wrap: Off");

        }
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMs = new Font("Comic Sans Ms", Font.PLAIN, fontSize);
        felipa = new Font("Felipa", Font.PLAIN, fontSize);
        algerian = new Font("Algerian", Font.PLAIN, fontSize);

        //setFont method to change the size
        setFont(selectedFont);
    }

    //method to set font to the text area
    public void setFont (String font ) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial" : 
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans" : 
                gui.textArea.setFont(comicSansMs);
                break;
            case "felipaFont" : 
                gui.textArea.setFont(felipa);
                break;
            case "Algerian" :
                gui.textArea.setFont(algerian);
        }
    }
}
