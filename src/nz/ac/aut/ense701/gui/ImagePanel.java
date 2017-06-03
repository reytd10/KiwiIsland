/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author Michael Jordan (14868336)
 */
public class ImagePanel extends JPanel{
    private Image image;
    
    public ImagePanel(Image image){
        super();
        this.image = image;
    }
    
    @Override protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.image = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
        g.drawImage(image, 0, 0, null);
        
    }
    
}
