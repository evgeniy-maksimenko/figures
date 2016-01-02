package gontzov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkedPanel extends JPanel implements MouseListener{
    Point p;

    public WorkedPanel() {
        setLayout(null);
        addMouseListener(this);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        p = e.getPoint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        add(new Figure(p, e.getPoint()));
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

}
