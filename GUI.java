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
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormart, menuColor;
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;

    Function_File file = new Function_File(this);


    public static void main(String[] args) throws Exception {
        new GUI();
    }
    public GUI () {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
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
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("SaveAs");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
    }

    @Override
    public void actionPerformed (ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New" : file.newFile();
            break;
            case "Open" : file.open();
            break;
        }
    }

}