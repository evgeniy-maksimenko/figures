package gontzov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Figure extends JPanel implements MouseListener, MouseMotionListener, FocusListener{
    Point point;
    Color color;
    Color tmpColor;

    public Figure(Point p1, Point p2) {
        setLayout(null);
        setBounds(p1.x, p1.y, p2.x-p1.x,p2.y-p1.y);
        color = getRandomRGBColor();
        this.setBackground(Color.white);

        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
    }

    private Color getRandomRGBColor(){
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setColor(color);
        graphics2d.drawRect(0,0, getWidth()-1, getHeight()-1);

    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        for(int i = 1; i <=8; i++)
        {
            MoveRect moveRect = new MoveRect(i);
            add(moveRect);
            moveRect.move();
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        removeAll();
        getParent().repaint();
    }



    @Override
    public void mousePressed(MouseEvent e) {
        point = e.getPoint();
        requestFocus();
    }



    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        tmpColor = color;
        color = Color.black;
        getParent().repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        color = tmpColor;
        getParent().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point tmp = e.getPoint();
        int dx = tmp.x - point.x;
        int dy = tmp.y - point.y;

        Point p = getLocation();
        p.translate(dx, dy);
        setLocation(p);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}
}
