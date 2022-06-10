package OOP_Project;
import javax.swing.*;
import java.awt.*;

public class visualizer extends JFrame {
    public static final int width = 600;
    public static final int height = 600;
    private sorting sorting;
    JButton button;
    private sorting panel = new sorting();

    public visualizer(){
        this.setTitle("Sorting");
        this.getContentPane().setPreferredSize(new Dimension( 603, 603));
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.pack();
        panel.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public sorting getPanel(){
        return this.panel;
    }
    public static void main(String[] args){
        visualizer visualizer = new visualizer();
    }
}
