package com.pilu.mundi.ui;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.entity.ComplexSequence;
import com.pilu.mundi.entity.ComplexSequenceMatrix;
import com.pilu.mundi.generator.Generator;
import org.apache.commons.math3.complex.Complex;

public class ViewPort {

    private final Generator generator;
    private Point2D.Double origo;
    private int width;
    private int height;
    private double scale;

    public ViewPort(Generator generator, Point2D.Double origo, double scale, int width, int height) {
        this.generator = generator;
        this.origo = origo;
        this.scale = scale;
        this.width = width;
        this.height = height;
    }

    public void setOrigo(Point2D.Double origo) {
        this.origo = origo;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void zoom(double zoom) {
        scale *= zoom;
    }

    public void zoomTo(Point from, Point to) {

        int width = to.x - from.x;
        int height = to.y - from.y;

        double zoomX = (double)width / (double)this.width;
        double zoomY = (double)height / (double)this.height;

        double zoom = zoomX > zoomY ? zoomX : zoomY;

        center(new Point(from.x + width/2, from.y + height/2));
        zoom(zoom);
    }

    public void center(Point point) {
        origo = new Point2D.Double(scale * ((double)point.x - width / 2.0) + origo.x,
                scale * ((double)point.y - height / 2.0) + origo.y);
    }

    private Point getViewPoint(Complex n) {
        return new Point(
            (int)Math.round((n.getReal() - origo.x) / scale  + width / 2.0),
            (int)Math.round((n.getImaginary() - origo.y) / scale + height / 2.0)
        );
    }

    public ComplexSequenceMatrix render() {

        ComplexSequenceMatrix matrix = new ComplexSequenceMatrix(width, height);

        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {

                double x = scale * (i - width / 2.0) + origo.x;
                double y = scale * (j - height / 2.0) + origo.y;

                matrix.set(i, j, generator.generate(new Complex(x, y)));
            }
        }

        return density(matrix);
    }

    private ComplexSequenceMatrix density(ComplexSequenceMatrix matrix) {
        ComplexSequenceMatrix density = new ComplexSequenceMatrix(width, height);
        for(int j = 0; j< height; j++) {
            for(int i = 0; i < width; i++) {
                for(Complex p : matrix.get(i,j).getSequence()){
                    Point vp = getViewPoint(p);
                    density.add(vp.x, vp.y, p);
                }
            }
        }

        return density;
    }
}
