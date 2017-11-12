package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate() {
        mSwing = CLOSED;
    }
    public boolean setSwing(int direction) {
        boolean res = true;
        if (direction == IN || direction == OUT) {
            mSwing = direction;
        }
        else {
            res = false;
        }

        return res;
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public boolean open(int direction) {
        return setSwing(direction);
    }

    public void close() {
        mSwing = CLOSED;
    }

    public int thru(int count) {
        return count * mSwing;
    }

    public String toString() {
        String res;
        if (mSwing == CLOSED) {
            res = "This gate is closed";
        }
        else if (mSwing == IN) {
            res = "This gate is open and swings to enter the pen only";
        }
        else if (mSwing == OUT) {
            res = "This gate is open and swings to exit the pen only";
        }
        else {
            res = "This gate has an invalid swing direction";
        }

        return res;
    }
}
