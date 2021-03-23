package Mechanics;

import UI.MainWindow;

import java.awt.*;
import java.util.Random;

public class MineGenerator {
    public static MineGenerator instance;
    public static MineGenerator getInstance(){
        if(instance==null){
            instance=new MineGenerator();
            return instance;
        }
        return instance;
    }

    int width=10;
    int height=10;
    int imageLabelOffset=5;
    int imageLabelWidth=64;
    int imageLabelHeight=64;
    float gemChance=0.3f;
    Tile[][] tiles;
    public void GenerateMine() {
        tiles=new Tile[height][width];
        for (int y = 5, i = 0; i < height; i++, y += imageLabelHeight + imageLabelOffset) {
            for (int x = 10, j = 0; j < width; j++, x += imageLabelWidth + imageLabelOffset) {
                Tile newTile = new Tile();
                newTile.setBackground(Color.lightGray);
                newTile.setOpaque(true);
                newTile.setBounds(x, y, imageLabelWidth, imageLabelHeight);
                newTile.setVisible(true);
                MainWindow.getInstance().getMainFrame().add(newTile);
                tiles[i][j] = newTile;
            }
        }
        MainWindow.getInstance().getMainFrame().repaint();
    }
    public void GenerateGems(){
        ClearMine();
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(Math.random()<=gemChance){
                    tiles[i][j].AddGem();
                }
            }
        }
    }
    void ClearMine(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                tiles[i][j].RemoveGem();
            }
        }
    }
}
