package SnakeCringe;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button extends JButton {

    private Spot spot;

    public Button() {super();}

    public Button(Spot spot) {
        super();
        this.spot = new Spot(spot);
        if ((this.getSpot().getContent() != null) && (this.getSpot().getContent().getImage() != null))
            this.setIcon(new ImageIcon(spot.getContent().getImage()));
    }

    public Button(Spot spot, Color color) {
        super();
        setSpot(spot);
        setBackground(color);
        if (getSpot().getContent() != null)
            this.setIcon(new ImageIcon(spot.getContent().getImage()));
    }

    public void setSpot(Spot spot) {this.spot = spot;}

    public Spot getSpot() {return this.spot;}
}

