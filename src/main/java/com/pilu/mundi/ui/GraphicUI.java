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

        ComplexSequenceMatrix matrix = viewPort.render();
        BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), TYPE_INT_RGB);

        for(int j=0; j<matrix.getHeight(); j++){
            for(int i=0; i<matrix.getWidth(); i++) {
                image.setRGB(i, j, colorer.getColor(matrix.get(i,j)));
            }
        }

        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        frame.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
                //todo viewPort set origin
            }
        });

        frame.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e);
            }
        });

    }
}
