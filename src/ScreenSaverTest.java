import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * This class tests the functionality of ScreenSaverFrame to correctly represent a screensaver application.
 * It includes fullscreen capability.
 */
public class ScreenSaverTest {

    /**
     * GraphicsDevice object to determine the unique graphics environment of the user's device.
     */
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    /**
     * Entry point for ScreenSaverTest program.
     * Initializes ScreenSaverFrame object and sets it to fullscreen.
     * @param args The command-line arguments (not used in this demonstration).
     */
    public static void main(String[] args)
    {
        ScreenSaverFrame screenSaver = new ScreenSaverFrame();
        //screenSaver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate when window is closed by user
                                                                      // is this necessary to have? I made other close button

        device.setFullScreenWindow(screenSaver); // set application to fullscreen
        screenSaver.setVisible(true); // set to visible
    }
}
