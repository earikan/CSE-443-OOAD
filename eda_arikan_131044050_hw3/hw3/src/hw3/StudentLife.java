/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

/**
 *
 * @author arika
 */
public class StudentLife {

    State chronicIllness;
    State needingSleep;
    State ready;
    State graduate;
    State fit;
    State unableToBecomeARodForAnAxe;

    State state;

    public StudentLife() {

        chronicIllness = new ChronicIllness(this);
        needingSleep = new NeedingSleep(this);
        ready = new Ready(this);
        graduate = new Graduate(this);
        fit = new Fit(this);
        unableToBecomeARodForAnAxe = new UnableToBecomeARodForAnAxe(this);
        state = ready;

    }

    public State getChronicIllness() {
        return chronicIllness;
    }

    public State getNeedingSleep() {
        return needingSleep;
    }

    public State getReady() {
        return ready;
    }

    public State getGraduate() {
        return graduate;
    }

    public State getFit() {
        return fit;
    }

    public State getUnableToBecomeARodForAnAxe() {
        return unableToBecomeARodForAnAxe;
    }

    public State getState() {
        return state;
    }

    public void coffeeAndWork() {
        state.coffeeAndWork();
    }

    public void sleep() {
        state.sleep();
    }

    public void outTillLate() {
        state.outTillLate();

    }

    public void perseveranceAndHardwork() {
        state.perseveranceAndHardwork();
    }

    public void exercise() {
        state.exercise();
    }

    public void buyingAGTX1080Ti() {
        state.buyingAGTX1080Ti();
    }

    public void cheating() {
        state.cheating();
    }

    void setState(State state) {
        this.state = state;
    }
}
