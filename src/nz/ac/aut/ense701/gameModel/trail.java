/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

/**
 *
 * @author chw0584
 */
public class trail extends Occupant{

    public trail(Position position, String name, String description) {
        super(position, name, description);
    }

    @Override
    public String getStringRepresentation() {
        return "TR";
    }
    
}
