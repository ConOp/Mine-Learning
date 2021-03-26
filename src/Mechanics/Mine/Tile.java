package Mechanics.Mine;

public class Tile {
    boolean containsGem;
    public Tile(Tile copied){
        this.containsGem=copied.containsGem;
    }
    public Tile(){
        containsGem=false;
    }

    /***
     * Adds a gem to the tile.
     */
    public void AddGem(){
        containsGem=true;
    }
    /***
     * Removes the gem from the tile.
     */
    public void RemoveGem(){
        containsGem=false;
    }

    /***
     * Checks whether a tiles is containing a gem.
     * @return True if tile is containing a gem, False if not.
     */
    public boolean  isContainingGem(){
        return containsGem;
    }

}
