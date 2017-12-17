/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eda
 */
public class Anaconda extends Snake {

    public Anaconda() {
        stamina = 100;
        score = 0;
        length = 8;
        scoreFactor = 2;
    }

    @Override
    public String snakeName() {
        return "Anaconda";
    }

}
