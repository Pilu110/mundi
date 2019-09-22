package com.pilu.mundi.ui;

import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.entity.ComplexSequenceMatrix;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class GraphicUI {

    private final ViewPort viewPort;
    private final Colorer colorer;

    public GraphicUI(ViewPort viewPort, Colorer colorer) {
        this.viewPort = viewPort;
        this.colorer = colorer;
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
                System.out.println(e.getPoint());
                viewPort.center(e.getPoint());
                drawOnPanel(panel);
            }
        });

        panel.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e);
            }
        });
    }

    private void drawOnPanel(JPanel panel) {
        ComplexSequenceMatrix matrix = viewPort.render();
        BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), TYPE_INT_RGB);

        for(int j=0; j<matrix.getHeight(); j++){
            for(int i=0; i<matrix.getWidth(); i++) {
                image.setRGB(i, j, colorer.getColor(matrix.get(i,j)));
            }
        }

        panel.removeAll();
        panel.add(new JLabel(new ImageIcon(image)));
        panel.updateUI();
    }
}
