package Exercise3;

import javax.swing.*;

public class StarShipController {
    private StarShip model;
    private StarShipView view;

    StarShipController(StarShip model, StarShipView view){
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView(){
        view.getTextName().setText(model.getName());
        view.getTextSpeed().setText(String.valueOf(model.getSpeed()));
        view.getTextDisplacement().setText(String.valueOf(model.getSpaceDisplacement()));
    }

    public void initController(){
        view.getButtonName().addActionListener(e -> setStarShipName());
        view.getButtonSpeed().addActionListener(e -> setStarShipSpeed());
        view.getButtonDisplacement().addActionListener(e -> setStarShipSpaceDisplacement());
        view.getButtonShow().addActionListener(e -> printDetails());
    }

    public void setStarShipName(){
        model.setName(view.getTextName().getText());
        JOptionPane.showMessageDialog(null, "Имя сохранено",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    public void setStarShipSpeed(){
        model.setSpeed(Integer.parseInt(view.getTextSpeed().getText()));
        JOptionPane.showMessageDialog(null, "Скорость сохранена",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    public void setStarShipSpaceDisplacement(){
        model.setSpaceDisplacement(Integer.parseInt(view.getTextDisplacement().getText()));
        JOptionPane.showMessageDialog(null, "Космоизмещение сохранено",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printDetails(){
        JOptionPane.showMessageDialog(null,
                "Корабль: " + model.getName() + ", Скорость: " + model.getSpeed() + ", Космоизмещение: " + model.getSpaceDisplacement(),
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
