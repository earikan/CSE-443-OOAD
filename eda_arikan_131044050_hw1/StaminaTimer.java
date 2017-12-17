/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eda
 */
public class StaminaTimer extends Thread {

    private volatile int value;

    public StaminaTimer(Integer parameter) {
        value = parameter;

    }

    @Override
    public void run() {
        try {
            while (value > 0) {
                Thread.sleep(2000);
                value -= 7;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(StaminaTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getValue() {
        return value;
    }

}
