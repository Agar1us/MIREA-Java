import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Window extends JFrame {

    private int height;
    private String library;
    Window(){
        setSize(800, 475);
        setLayout(null);
        setTitle("Зависимости библиотеки");
        JLabel label = new JLabel("Введите название библиотеки: ");
        label.setBounds(40, 30, 200, 20);
        JLabel labelHeight = new JLabel("Введите глубину зависимостей: ");
        labelHeight.setBounds(40, 60, 200, 20);
        JLabel ansLabel = new JLabel();
        JTextArea text = new JTextArea();
        text.setBounds(250, 30, 300, 20);
        JTextArea textHeight = new JTextArea();
        textHeight.setBounds(250, 60, 100, 20);
        JButton button = new JButton("Подтвердить");
        button.setBounds(560, 30, 150, 20);
        JButton buttonHeight = new JButton("Подтвердить");
        buttonHeight.setBounds(360, 60, 150, 20);
        JButton ansButton = new JButton("Сгенерировать граф");
        ansButton.setBounds(300, 100, 200, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Work.isLibrary(text.getText()))
                        library = text.getText();
                    else
                        library = "";
                } catch (IOException ignored) {}
            }
        });
        buttonHeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Work.isHeight(Integer.parseInt(textHeight.getText())))
                    height = Integer.parseInt(textHeight.getText());
                else height = 0;
            }
        });
        ansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals("", library) && height > 0) {
                    try {
                        ansLabel.setBounds(200, 130, 400, 300);
                        Work.run(library, height);
                        File check = new File("C:\\Users\\kalin\\Desktop\\Java\\MavenDz2\\graph.png");
                        ImageIcon icon = new ImageIcon(check.getPath());
                        Image img = icon.getImage();
                        Image imgScale = img.getScaledInstance(ansLabel.getWidth(), ansLabel.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon finish = new ImageIcon(imgScale);
                        ansLabel.setIcon(finish);
                    } catch (IOException ignored) {}
                }
                else{
                    ansLabel.setBounds(250, 130, 500, 20);
                    ansLabel.setIcon(null);
                    ansLabel.setText("Входные данные были введены некорректно");
                }
            }
        });
        add(label);
        add(labelHeight);
        add(text);
        add(textHeight);
        add(button);
        add(buttonHeight);
        add(ansButton);
        add(ansLabel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
