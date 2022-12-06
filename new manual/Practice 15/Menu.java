import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Menu extends JFrame {
    final private JComboBox menu;
    private JLabel labelStart, labelChoose;

    Menu(){
        setSize(1000, 100);
        setLayout(new FlowLayout());
        String [] stringMenu = {"Australia", "China", "England", "Russia"};
        menu = new JComboBox<>(stringMenu);
        menu.setBounds(80, 50, 140, 20);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (menu.getSelectedItem() == "Australia")
                    labelChoose.setText("Кто-то считает Австралию придатком Китая, но на самом деле, это страна имеет более важную роль в экономике мира");
                else if (menu.getSelectedItem() == "China")
                    labelChoose.setText("Китай можно по праву назвать страной, имеющее самую сильную экономику в мире");
                else if (menu.getSelectedItem() == "England")
                    labelChoose.setText("Раньше Англия была могущественной державой, сейчас эта страна пытается кое-как покаазать себя на мировой арене");
                else labelChoose.setText("Многие в мире считают, что Россия - это бензоколонка, но на самом деле она имеет такие технологии, о которых мечтает весь мир");
            }
        });
        labelStart = new JLabel("Выберите страну: ");
        labelStart.setBounds(90, 100, 400, 100);
        labelChoose = new JLabel("Страна не выбрана");
        labelChoose.setBounds(90, 100, 400, 100);
        add(labelStart);
        add(menu);
        add(labelChoose);
        setVisible(true);
    }

    public static void main(String [] args){
        new Menu();
    }
}
