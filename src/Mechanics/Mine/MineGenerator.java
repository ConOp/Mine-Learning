package Mechanics.Mine;
import Utility.SettingsManager;

public class MineGenerator {
    public static MineGenerator instance;
    public static MineGenerator getInstance(){
        if(instance==null){
            instance=new MineGenerator();
            return instance;
        }
        return instance;
    }


    Tile[][] tiles;

    /***
     * Generates the main mine.
     */
    public void  GenerateMine(){
        ClearMine();
        tiles=new Tile[SettingsManager.height][SettingsManager.width];
        for(int i = 0; i< SettingsManager.height; i++){
            for(int j=0;j<SettingsManager.width;j++){
                tiles[i][j]=new Tile();
            }
        }
    }

    /***
     * Generates the gems in the mine.
     */
    public void GenerateGems(){
        ClearMine();
        for(int i = 0; i< SettingsManager.height; i++){
            for(int j=0;j<SettingsManager.width;j++){
                if(Math.random()<=SettingsManager.gemChance){
                    tiles[i][j].AddGem();
                }
            }
        }
    }

    /***
     * Clears the mine from gems.
     */
    void ClearMine(){
        if(tiles!=null) {
            for (int i = 0; i < SettingsManager.height; i++) {
                for (int j = 0; j < SettingsManager.width; j++) {
                    tiles[i][j].RemoveGem();
                }
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
