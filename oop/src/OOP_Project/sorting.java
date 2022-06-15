package OOP_Project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

//Inherit JPanel Class
public class sorting extends JPanel {
    //Rectangle width
    public static final int line_width = 4;
    //Number of lines in the JPanel
    public static final int numLines = visualizer.width / line_width;
    private Random rand = new Random();
    public final int[] array;
    //Swingworker for timers
    public SwingWorker<Void, Void> shuffle, bubblesort, insertionsort, selectionsort;
    //JButtons for the following functions
    JButton bubble = new JButton("BubbleSort");
    JButton reset = new JButton("Shuffle");
    JButton insert = new JButton("InsertionSort");
    JButton select = new JButton("SelectionSort");

    //Main Function
    public sorting(){
        this.add(bubble);
        this.add(insert);
        this.add(select);
        this.add(reset);
        setBackground(Color.black);
        //Initializing array and its indexes being as much as the numLines variable
        array = new int[numLines];
        for (int i = 0; i < numLines; i++) {
            array[i] = i;
        }
        //To start of shuffled
        shuffle();
        setBackground(Color.BLACK);
        //Executing the action listener through the button
        bubble.addActionListener(e -> bubbleSort(array));
        insert.addActionListener(e -> insertionsort(array));
        reset.addActionListener(e -> shuffle());
        select.addActionListener(e -> selectionsort(array));
    }

    //Shuffle Method
    void shuffle() {
        shuffle = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws InterruptedException {
                //Randomises the indexes
                for (int i = 0; i < numLines; i++) {
                    int swapindex = rand.nextInt(numLines - 1);
                    int temp = array[i];
                    array[i] = array[swapindex];
                    array[swapindex] = temp;
                    Thread.sleep(1);
                    repaint();
                }
            return null;
        }
    };shuffle.execute();
}

    //paintComponent for JPanel and graphics for the rectangles
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(g);
        graphics.setColor(Color.white);
        //Loops through to create a staircase of rectangles
        for (int x = 0; x < numLines; x++) {
            //Initializing locations of the rectangles
            int height = array[x] * 3;
            int x_coordinate = x + (line_width - 1) * x;
            int y_coordinate = visualizer.height - height;
            graphics.fillRect(x_coordinate, y_coordinate, line_width, height);
        }
    }

    //Bubble Sort initialization, taken from GeeksForGeeks.org
    void bubbleSort(int arr[]) {
        bubblesort = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws InterruptedException {
                int n = arr.length;
                for (int i = 0; i < n - 1; i++)
                    for (int j = 0; j < n - i - 1; j++)
                        if (arr[j] > arr[j + 1]) {
                            // swap arr[j+1] and arr[j]
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                            Thread.sleep(1);
                            repaint();
                    }
            return null;
        }
    };bubblesort.execute();
}
    //Insertion Sort initialization, taken from GeeksForGeeks.org
    void insertionsort(int arr[]) {
        insertionsort = new SwingWorker<>() {
            @Override
           protected Void doInBackground() throws InterruptedException {
                int n = arr.length;
                for (int i = 1; i < n; ++i) {
                    int key = arr[i];
                    int j = i - 1;
        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
                    while (j >= 0 && arr[j] > key) {
                         arr[j + 1] = arr[j];
                         j = j - 1;
                    }
                    arr[j + 1] = key;
                    Thread.sleep(10);
                     repaint();
                }
                return null;
            }
        };insertionsort.execute();
    }
    //Selection Sort initialization, taken from GeeksForGeeks.org
    void selectionsort(int arr[]) {
        selectionsort = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws InterruptedException {
                // One by one move boundary of unsorted subarray
                int n = arr.length;
                for (int i = 0; i < n-1; i++)
                {
                    // Find the minimum element in unsorted array
                    int min_idx = i;
                    for (int j = i+1; j < n; j++)
                        if (arr[j] < arr[min_idx])
                            min_idx = j;

                    // Swap the found minimum element with the first
                    // element
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                }
                Thread.sleep(1);
                repaint();
                return null;
            }
        };selectionsort.execute();
    }
}



