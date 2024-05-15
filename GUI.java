import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener{

    JFrame window;

    //Text Area 
    JTextArea textArea;
    JScrollPane scrollPane;

    //Top Menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormart, menuColor;

    //File menu
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;

    //Formart Menu
    JMenuItem itemWrap;
    JMenu menuFont;
    JMenu menuFontSize; 
    JMenuItem itemFontArial, itemFontComicSaans, itemFontTimesNewRoman;
    JMenuBar itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28;

    Function_File file = new Function_File(this);
    Function_Formart formart = new Function_Formart(this);


    public static void main(String[] args) throws Exception {
        new GUI();
    }
    public GUI () {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormartMenu();
        window.setVisible(true);
    }

    public void createWindow () {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea () {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        window.add(scrollPane);
        
    }
    public void createMenuBar () {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormart = new JMenu("Formart");
        menuBar.add(menuFormart);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    public void createFileMenu () {
        itemNew = new JMenuItem("New ");
        itemNew.addActionListener((java.awt.event.ActionListener) this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save As");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("SaveAs");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }

    public void createFormartMenu () {
        itemWrap = new JMenuItem(" Word Wrap : Off");
        itemWrap.addActionListener(this);
        itemWrap.setActionCommand("Word Wrap");
        menuFormart.add(itemWrap);

        menuFont = new JMenu("Font");
        menuFormart.add(menuFont);

        itemFontArial = new JMenuItem("Arial");
        itemFontArial.addActionListener(this);
        itemFontArial.setActionCommand("Arial");
        menuFont.add(itemFontArial);

        itemFontComicSaans = new JMenuItem("Comic Sans");
        itemFontComicSaans.addActionListener(this);
        itemFontComicSaans.setActionCommand("ComicSans");
        menuFont.add(itemFontComicSaans);

        itemFontTimesNewRoman = new JMenuItem("Time New Roman");
        itemFontTimesNewRoman.addActionListener(this);
        itemFontTimesNewRoman.setActionCommand("TimesNewRoman");
        menuFont.add(itemFontTimesNewRoman);

        menuFontSize = new JMenu();
        menuFormart.add(menuFontSize);
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New" : file.newFile();
            break;
            case "Open" : file.open();
            break;
            case  "SaveAs" : file.saveAs();
            break;
            case "Save" : file.save();
            break;
            case "Exit" : file.exit ();
            break;
        }
    }

}
