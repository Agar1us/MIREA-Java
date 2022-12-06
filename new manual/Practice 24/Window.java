import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Window extends JFrame {

    public Window(){
        setSize(600, 400);
        String [] strFiles = {"Text", "Image", "Music"};
        JMenu file = new JMenu("File");
        JMenu create = createJMenu(strFiles, "Create");
        JMenu open = createJMenu(strFiles, "Open");
        file.add(create);
        file.add(open);
        JMenuBar fullMenu = new JMenuBar();
        fullMenu.add(file);
        setJMenuBar(fullMenu);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private JMenu createJMenu(String [] items, String name){
        JMenu ans = new JMenu(name);
        for (int i = 0; i < 3; ++i){
            int finalI = i;
            ans.add(new JMenuItem(new AbstractAction(items[i]) {
                public void actionPerformed(ActionEvent e) {
                    if (finalI == 0) {
                        try {
                            IDocument doc = Factory.getDocument(new CreateText());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (finalI == 1) {
                        try {
                            IDocument doc = Factory.getDocument(new CreateImage());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        try {
                            IDocument doc = Factory.getDocument(new CreateMusic());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }));
        }
        return ans;
    }

    public static void main(String [] args){
        new Window();
    }
}
