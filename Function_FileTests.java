
import java.awt.FileDialog;
import java.beans.Transient;
import java.io.BufferedReader;
import static org.mockito.Mockito.mock; // Import the mock method from org.mockito.Mockito
import org.mockito.Mockito; // Import the Mockito class from org.mockito

import static org.mockito.Mockito.mock; // Import the mock method from org.mockito.Mockito
import org.junit.Test; // Import the Test class from org.junit
import org.junit.Test; // Import the Test class from org.junit


public class Function_FileTests {

    private Function_File functionFile;
    private GUI gui;

    @Before
    public void setUp () {
        gui = mock (GUI.class);
        functionFile = new Function_File(gui);
    }

    @Test
    public void testNewFile () {
        functionFile.newFile();
        Mockito.verify(gui.textArea).setText("");
        Mockito.verify(gui.window).setTitle("New");
    }

    @Test
    public void testOpen () {
        FileDialog fileDialog = mock(FileDialog.class);
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(gui.window).thenReturn(fileDialog);
        when(fileDialog.getFile()).thenReturn("file.txt");
        when(fileDialog.getDirectory()).thenReturn("C:/Users/");

        functionFile.open();
        Mockito.verify(gui.window).setTitle("file.txt");
        Mockito.verify(gui.textArea).setText(" ");
        Mockito.verify(bufferedReader).close();
    }

    @Test
    public void testSave () {
        FileDialog fileDialog = mock(FileDialog.class);
        FileWriter fileWriter = mock(FileWriter.class);
        when(gui.window).thenReturn(fileDialog);
        when(fileDialog.getFile()).thenReturn("file.txt");
        when(fileDialog.getDirectory()).thenReturn("C:/Users/");
        when(gui.textArea.getText()).thenReturn("Hello World");

        functionFile.save();
        Mockito.verify(fileWriter).write("Hello World");
        Mockito.verify(fileWriter).close();
    }

    @Test
    public void testSaveAs () {
        FileDialog fileDialog = mock(FileDialog.class);
        FileWriter fileWriter = mock(FileWriter.class);
        when(gui.window).thenReturn(fileDialog);
        when(fileDialog.getFile()).thenReturn("file.txt");
        when(fileDialog.getDirectory()).thenReturn("C:/Users/");
        when(gui.textArea.getText()).thenReturn("Hello World");

        functionFile.saveAs();
        Mockito.verify(fileWriter).write("Hello World");
        Mockito.verify(fileWriter).close();
    }

    @Test(expected = ExitException.class)
    public void testExit () {
        functionFile.exit();
    }
}
