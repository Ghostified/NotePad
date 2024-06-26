import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener{

    JFrame window;

    //Text Area 
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    //Top Menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormart, menuColor;

    //File menu
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;

    //Edit Items 
    JMenuItem itemUndo, itemRedo; 

    //Formart Menu
    JMenuItem itemWrap;
    JMenu menuFont;
    JMenu menuFontSize; 
    JMenuItem itemFontArial, itemFontComicSaans, itemFontFelipa, itemFontAlgerian;
    JMenuItem itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28;

    //Color Options 
    JMenuItem itemColor1, itemColor2, itemColor3;

    Function_File file = new Function_File(this);
    Function_Formart formart = new Function_Formart(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);

    Key_Handler keyHandler = new Key_Handler(this);

    UndoManager undoManager = new UndoManager();


    public static void main(String[] args) throws Exception {
        new GUI();
    }
    public GUI () {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormartMenu();
        createColorMenu();
        createEditMenu();

        formart.selectedFont = "Felipa";
        formart.createFont(15);
        formart.wordWrap();
        color.changeColor("white");
        window.setVisible(true);
    }

    public void createWindow () {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea () {
        textArea = new JTextArea();
        textArea.addKeyListener(keyHandler);

        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened (UndoableEditEvent e) {
                    undoManager.addEdit(e.getEdit());
                }
            }
        );
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
        itemWrap = new JMenuItem("Word Wrap : Off");
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
        itemFontComicSaans.setActionCommand("Comic Sans");
        menuFont.add(itemFontComicSaans);

        itemFontFelipa = new JMenuItem("Felipa");
        itemFontFelipa.addActionListener(this);
        itemFontFelipa.setActionCommand("felipaFont");
        menuFont.add(itemFontFelipa);

        itemFontAlgerian = new JMenuItem("Algerian");
        itemFontAlgerian.addActionListener(this);
        itemFontAlgerian.setActionCommand("Algerian");
        menuFont.add(itemFontAlgerian);

        menuFontSize = new JMenu("Font Size");
        menuFormart.add(menuFontSize);

        //Add Fonts
        itemFontSize8 = new JMenuItem("8");
        itemFontSize8.addActionListener(this);
        itemFontSize8.setActionCommand("size8");
        menuFontSize.add(itemFontSize8);

        itemFontSize12 = new JMenuItem("12");
        itemFontSize12.addActionListener(this);
        itemFontSize12.setActionCommand("size12");
        menuFontSize.add(itemFontSize12);

        itemFontSize16 = new JMenuItem("16");
        itemFontSize16.addActionListener(this);
        itemFontSize16.setActionCommand("size16");
        menuFontSize.add(itemFontSize16);

        itemFontSize20 = new JMenuItem("20");
        itemFontSize20.addActionListener(this);
        itemFontSize20.setActionCommand("size20");
        menuFontSize.add(itemFontSize20);

        itemFontSize24 = new JMenuItem("24");
        itemFontSize24.addActionListener(this);
        itemFontSize24.setActionCommand("size24");
        menuFontSize.add(itemFontSize24);

        itemFontSize28 = new JMenuItem("28");
        itemFontSize28.addActionListener(this);
        itemFontSize28.setActionCommand("size28");
        menuFontSize.add(itemFontSize28);

    }

    public void createColorMenu() {
        itemColor1 = new JMenuItem("Green");
        itemColor1.addActionListener(this);
        itemColor1.setActionCommand("Green");
        menuColor.add(itemColor1);

        itemColor2 = new JMenuItem("Blue");
        itemColor2.addActionListener(this);
        itemColor2.setActionCommand("Blue");
        menuColor.add(itemColor2);

        itemColor3 = new JMenuItem("Red");
        itemColor3.addActionListener(this);
        itemColor3.setActionCommand("Red");
        menuColor.add(itemColor3);
    }

    public void createEditMenu () {
        itemUndo = new JMenuItem("Undo");
        itemUndo.addActionListener(this);
        itemUndo.setActionCommand("Undo");
        menuEdit.add(itemUndo);

        itemRedo = new JMenuItem("Redo");
        itemRedo.addActionListener(this);
        itemRedo.setActionCommand("Redo");
        menuEdit.add(itemRedo);
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
            case  "Undo" : edit.undo();
            break;
            case "Redo" : edit.redo();
            break;
            case "Word Wrap": formart.wordWrap();
            break;
            case "Arial" : formart.setFont(command);
            break;
            case "Comic Sans" : formart.setFont(command);
            break;
            case "felipaFont" : formart.setFont(command);
            break; 
            case "Algerian" : formart.setFont(command);
            break;
            case  "size8" : formart.createFont(8);
            break;
            case "size12" : formart.createFont(12);
            break;
            case "size16" : formart.createFont(16);
            break;
            case "size20" : formart.createFont(20);
            break;
            case "size24" : formart.createFont(24);
            break;
            case"size28" : formart.createFont(28);
            break;
            case "Green" : color.changeColor(command);
            break;
            case "Blue" : color.changeColor(command);
            break;
            case "Red" : color.changeColor(command);
            break;
        }
    }

}
