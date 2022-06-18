package OOP_Project;
import javax.swing.*;
import java.awt.*;

//Inherit JFrame class and as a result taking in JFrame's methods
public class Visualizer extends JFrame {
    //Initialize window size
    public static final int width = 600;
    public static final int height = 600;
    //Initialize JPanel
    private Sorting panel = new Sorting();
    //Standard window code for title and showing JPanel contents
    public Visualizer() {
        this.setTitle("Sorting");
        this.getContentPane().setPreferredSize(new Dimension(603, 603));
        //Implement JPanel
        this.getContentPane().add(panel);
        this.setVisible(true);
        //Makes sure that the window size is at or above its preferred size in line 15
        this.pack();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Visualizer();
    }
}

