package OOP_Project;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class sorting extends JPanel {
    public static final int line_width = 4;
    public static final int numLines = visualizer.width / line_width;

    private Random rand = new Random();
    private final int[] array;

    JButton start = new JButton("start");
    JButton reset = new JButton("reset");

    public sorting() {
        array = new int[numLines];
        for (int i = 0; i < numLines; i++) {
            array[i] = i;
        }
        shuffle();
        setBackground(Color.BLACK);
        new Algorithms().bubbleSort(array);
    }

    private void shuffle() {
        for (int i = 0; i < numLines; i++) {
            int swapindex = rand.nextInt(numLines - 1);
            int temp = array[i];
            array[i] = array[swapindex];
            array[swapindex] = temp;
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);
        graphics.setColor(Color.white);

        for (int x = 0; x < numLines; x++) {
            int height = array[x] * 3;
            int x_coordinate = x + (line_width - 1) * x;
            int y_coordinate = visualizer.height - height;
            int val = array[x] * 2;
            graphics.fillRect(x_coordinate, y_coordinate, line_width, height);
        }
    }
}

