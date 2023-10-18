// java.util
import java.util.Random;
// java.awt
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
// javax.swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton; // addActionListener?


/**
 * This class extends JFrame to create a GUI application.
 * It represents the main window of a simple screensaver application with the help of class ScreenSaverPanel.
 * The application displays a changing pattern and provides an "Exit" button.
 * Users can close the application by clicking the "Exit" button.
 * The main executable file for the application is ScreenSaverTest.
 * @see ScreenSaverPanel
 * @see ScreenSaverTest
 */
public class ScreenSaverFrame extends JFrame{

    /**
     * ScreenSaverPanel object that represents the screensaver.
     */
    private final ScreenSaverPanel screenSaver;


    /**
     * Creates a GUI environment similar to JFrame environment for components to be added.
     * Initializes an "Exit" button.
     * Initializes a ScreenSaver panel for the main screensaver portion with the changing patterns.
     */
    public ScreenSaverFrame() {

        // add "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            System.exit(0); // terminate the application
        });
        add(exitButton, BorderLayout.PAGE_START);

        // add ScreenSaverPanel
        screenSaver = new ScreenSaverPanel();
        screenSaver.setBackground(Color.BLACK);
        add(screenSaver);
    }


    /**
     * This class extends JPanel to create an environment suitable for drawing.
     * It represents the main screensaver portion of the screensaver application.
     * 100 lines are with random color and random placement are drawn before the panel clears and begins again.
     * @see ScreenSaverFrame
     */
    public class ScreenSaverPanel extends JPanel {

        /**
         * Maximum number of lines to be drawn before panel clears.
         */
        private static final int MAX_LINES = 100;

        /**
         * Random object for random placement of lines and selection of color.
         */
        private Random random = new Random();


        /**
         * Commences a loop of drawing lines, clearing the panel, and then drawing lines again.
         * For each cycle, 100 lines of random placement and color are drawn.
         * @param g the <code>Graphics</code> object to protect
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // ensure that component displays correctly, clears the drawing area

            int lineCount = 0;
            while(lineCount<MAX_LINES) {

                // line coordinates are chosen randomly
                int x1 = random.nextInt(getWidth());
                int y1 = random.nextInt(getHeight());
                int x2 = random.nextInt(getWidth());
                int y2 = random.nextInt(getHeight());

                // generate random RGB color for the line
                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

                // draw a line
                g.drawLine(x1, y1, x2, y2);

                // increment count
                lineCount++;
            }
            // clear panel and redraw lines
            repaint();
        }
    }
}