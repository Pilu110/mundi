package com.pilu.mundi.ui;

import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.entity.ComplexSequenceMatrix;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class GraphicUI {

    private final ViewPort viewPort;
    private final Colorer colorer;

    private boolean hasMouseDrag;
    private Point mouseDragStartingPoint;

    public GraphicUI(ViewPort viewPort, Colorer colorer) {
        this.viewPort = viewPort;
        this.colorer = colorer;
        this.hasMouseDrag = false;
    }

    public void display() {
        JPanel panel = new JPanel();
        drawOnPanel(panel);
        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Mundi Fractal Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        panel.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1 : {
                        viewPort.center(e.getPoint());
                        drawOnPanel(panel);
                        break;
                    }

                    case MouseEvent.BUTTON2 : {
                        viewPort.setOrigo(new Point2D.Double(0,0));
                        viewPort.setScale(0.02);
                        drawOnPanel(panel);
                        break;
                    }

                    case MouseEvent.BUTTON3 : {
                        viewPort.zoom(2);
                        drawOnPanel(panel);
                        break;
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    mouseDragStartingPoint = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(hasMouseDrag && e.getButton() == MouseEvent.BUTTON1) {
                    viewPort.zoomTo(mouseDragStartingPoint, e.getPoint());
                    drawOnPanel(panel);
                    hasMouseDrag = false;
                }
            }

        });

        panel.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                hasMouseDrag = true;
            }
        });
    }

    private void drawOnPanel(JPanel panel) {
        ComplexSequenceMatrix matrix = viewPort.render();
        BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), TYPE_INT_RGB);

        int maxSize = matrix.getMaxSize();

        for(int j=0; j<matrix.getHeight(); j++){
            for(int i=0; i<matrix.getWidth(); i++) {
                image.setRGB(i, j, colorer.getColor(matrix.get(i,j), maxSize));
            }
        }

        panel.removeAll();
        panel.add(new JLabel(new ImageIcon(image)));
        panel.updateUI();
    }
}
