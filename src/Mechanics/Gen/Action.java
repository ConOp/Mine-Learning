package Mechanics.Gen;
import Mechanics.Mine.MineGenerator;
import Utility.SettingsManager;

public enum Action {
    MOVE_UP{
        public boolean isValidAction(Agent agent) {return agent.position.y + 1 < MineGenerator.getInstance().getHeight();}
        @Override
        public void ExecuteAction(Agent agent) {
           if(isValidAction(agent))
               agent.position.y+=1;
           else
               agent.ModifyScore(SettingsManager.getInstance().getObstacleScore());
        }
    },
    MOVE_DOWN{
        public boolean isValidAction(Agent agent) {return agent.position.y - 1 >= 0;}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent))
                agent.position.y-=1;
            else
                agent.ModifyScore(SettingsManager.getInstance().getObstacleScore());
        }
    },
    MOVE_LEFT{
        public boolean isValidAction(Agent agent) {return agent.position.x - 1 >= 0;}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent))
                agent.position.x-=1;
            else
                agent.ModifyScore(SettingsManager.getInstance().getObstacleScore());
        }
    },
    MOVE_RIGHT{
        public boolean isValidAction(Agent agent) {return agent.position.x + 1 < MineGenerator.getInstance().getWidth();}
        @Override
        public void ExecuteAction(Agent agent) {
            if(isValidAction(agent))
                agent.position.x+=1;
            else
                agent.ModifyScore(SettingsManager.getInstance().getObstacleScore());

        }
    };

    private int id;

    /***
     * Executes the selected agent action.
     * @param agent
     */
    public abstract void ExecuteAction(Agent agent);
}
