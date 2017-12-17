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
public class RandomJobOfferTimer extends Thread {

    private volatile boolean value = false;

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 5000));
            value = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(StaminaTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean getValue() {
        return value;
    }

}
