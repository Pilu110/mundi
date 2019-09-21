package com.pilu.mundi.component.displayer;

import com.pilu.mundi.component.Navigator;
import com.pilu.mundi.component.colorer.Colorer;
import com.pilu.mundi.entity.ComplexSequenceMatrix;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class GraphicDisplayer implements Displayer {

    private final Navigator navigator;
    private final Colorer colorer;

    public GraphicDisplayer(Navigator navigator, Colorer colorer) {
        this.navigator = navigator;
        this.colorer = colorer;
    }

    @Override
    public void display(ComplexSequenceMatrix matrix) {
        JPanel panel = new JPanel();

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
                //todo navigator set origin
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
