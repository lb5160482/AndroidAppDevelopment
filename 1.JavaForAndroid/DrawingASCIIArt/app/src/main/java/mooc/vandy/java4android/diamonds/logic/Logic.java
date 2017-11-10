package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        int width = 2 * size + 2;
        int height = 2 * size + 1;
        String line = "";
        for (int i = 0; i < height; ++i) {
            if (i % 2 == 1) {
                line = "=";
            }
            else {
                line = "-";
            }

            if (i == 0 || i == height - 1) {
                printEdgeRow(width);
            }
            else if (i == height / 2) { // mid row
                printMidRow(width, line);
            }
            else {
                printGeneralRow(i, width, height, line);
            }
        }
    }

    private void printGeneralRow(int rowInd, int width, int height, String line) {
        String str = "";
        int lineNum = 0;
        if (rowInd < height / 2) {
            lineNum = (rowInd - 1) * 2;
        }
        else {
            lineNum = (height - rowInd - 2) * 2;
        }
        for (int i = 0; i < lineNum; ++i) {
            str += line;
        }
        if (rowInd < height / 2) {
            str = "/" + str + "\\";
        }
        else {
            str = "\\" + str + "/";
        }
        while (str.length() != width - 2) {
            str = " " + str + " ";
        }
        str = "|" + str + "|";
        mOut.println(str);
    }

    private void printMidRow(int width, String line) {
        String str = "";
        for (int i = 0; i < width; ++i) {
            if (i == 0 || i == width - 1) {
                str += "|";
            }
            else if (i == 1) {
                str += "<";
            }
            else if (i == width - 2) {
                str += ">";
            }
            else {
                str += line;
            }
        }
        mOut.println(str);
    }

    private void printEdgeRow(int width) {
        String str = "+";
        for (int i = 0; i < width - 2; ++i) {
            str += "-";
        }
        str += "+";
        mOut.println(str);
    }
}
