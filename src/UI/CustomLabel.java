package UI;
import javax.swing.*;

public class CustomLabel extends JLabel {
    Icon prevIcon;


    @Override
    public void setIcon(Icon icon) {
        prevIcon=this.getIcon();
        super.setIcon(icon);
    }

    /***
     * Sets the previous icon as the current one.
     */
    public void setPrevIcon(){
        super.setIcon(prevIcon);
        prevIcon=null;
    }
}
