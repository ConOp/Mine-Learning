package Mechanics;

import javax.swing.*;

public class Tile extends JLabel {
    boolean containsGem;
    public void AddGem(){
        containsGem=true;
        this.setIcon(new ImageIcon("Resources/gem.png"));
    }
    public void RemoveGem(){
        containsGem=false;
        this.setIcon(null);
    }
    public boolean  isContainingGem(){
        return containsGem;
    }
}
