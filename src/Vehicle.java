/**
 * The vehicle should contain:
 * Start
 * Accelerate
 * Decelerate
 * Stop
 * Turn left
 * Turn right
 */
public class Vehicle {
    boolean start;
    boolean stop;
    boolean turnLeft;
    boolean turnRight;
    boolean goForward;
    boolean goReverse;
    boolean engineRunning;
    int speed;

    Vehicle() {
        stop = true;
        start = ! stop;
        turnLeft = false;
        turnRight = false;
        goForward = false;
        goReverse = false;
        engineRunning = false;
        speed = 0;
    }
    /*
    Vehicle() {
        stop = true;
        start = ! stop;
        turnLeft = false;
        turnRight = false;
        goForward = false;
        goReverse = false;
        speed = 0;
    }

     */

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isTurnLeft() {
        return turnLeft;
    }

    public void setTurnLeft(boolean turnLeft) {
        this.turnLeft = turnLeft;
    }

    public boolean isTurnRight() {
        return turnRight;
    }

    public void setTurnRight(boolean turnRight) {
        this.turnRight = turnRight;
    }

    public boolean isGoForward() {
        return goForward;
    }

    public void setGoForward(boolean goForward) {
        this.goForward = goForward;
    }

    public boolean isGoReverse() {
        return goReverse;
    }

    public void setGoReverse(boolean goReverse) {
        this.goReverse = goReverse;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    public void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }
}