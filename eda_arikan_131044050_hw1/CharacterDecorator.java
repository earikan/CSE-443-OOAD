/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eda
 */
public abstract class CharacterDecorator extends Snake {

    Snake character;

    public CharacterDecorator(Snake character) {
        super();
        this.character = character;
    }

}
