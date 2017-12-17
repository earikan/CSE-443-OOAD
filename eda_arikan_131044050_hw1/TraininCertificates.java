/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eda
 */
public class TraininCertificates extends CharacterDecorator {

    public TraininCertificates(Snake character) {
        super(character);
    }

    @Override
    public String snakeName() {
        return character.snakeName();
    }

    @Override
    public double getMultiplier() {
        return character.getMultiplier() * 3;
    }

}
