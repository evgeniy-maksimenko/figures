package gontzov;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MoveRect extends JPanel implements MouseListener, MouseMotionListener {
    int pos = 0;
    Point point = null;

    public MoveRect(int pos) {
        this.pos = pos;
        setSize(10, 10);
        setBackground(Color.black);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void move()
    {
        int w = getParent().getWidth();
        int h = getParent().getHeight();
        switch (pos)
        {
            case 1: setLocation(0, h/2); break;
            case 2: setLocation(w-10, h/2); break;
            case 3: setLocation(w/2, h-10); break;
            case 4: setLocation(w/2, 0); break;
            case 5: setLocation(0, h-10); break;
            case 6: setLocation(w-10, 0); break;
            case 7: setLocation(0, 0); break;
            case 8: setLocation(w-10, h-10); break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point = e.getPoint();
    }



    @Override
    public void mouseEntered(MouseEvent e) {
        int type = Cursor.DEFAULT_CURSOR;
        switch(pos)
        {
            case 1: type = Cursor.W_RESIZE_CURSOR;  break;
            case 2: type = Cursor.E_RESIZE_CURSOR;  break;
            case 3: type = Cursor.S_RESIZE_CURSOR;  break;
            case 4: type = Cursor.N_RESIZE_CURSOR;  break;
            case 5: type = Cursor.SW_RESIZE_CURSOR; break;
            case 6: type = Cursor.NE_RESIZE_CURSOR; break;
            case 7: type = Cursor.NW_RESIZE_CURSOR; break;
            case 8: type = Cursor.SE_RESIZE_CURSOR; break;
        }
        setCursor(new Cursor(type));
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Point epoint = e.getPoint();

        int dx = epoint.x - point.x;
        int dy = epoint.y - point.y;

        Dimension dimension = getParent().getSize();
        dimension.width  += dx;
        dimension.height += dy;
        getParent().setSize(dimension);

        point = epoint;

        // *************************************************************************************************************

        this.setBackground(Color.white);

        for(Component component : getParent().getComponents()) {
            MoveRect moveRect = (MoveRect) component;
            if(this != moveRect) {
                getParent().remove(moveRect);
                getParent().repaint();
            }
        }

        for(int i = 1; i <=8; i++)
        {
            MoveRect moveRect = new MoveRect(i);
            getParent().add(moveRect);
            moveRect.move();
        }


    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}
}
