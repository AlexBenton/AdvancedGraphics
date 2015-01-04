package com.bentonian.hellosquare;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.awt.GLCanvas;

public class HelloSquare {

  public static void main(String[] args) {
    new Thread() {
      @Override
      public void run() {
        Frame frame = new Frame("Hello Square");
        GLCanvas canvas = new GLCanvas();

        // Setup GL canvas
        frame.add(canvas);
        canvas.addGLEventListener(new HelloSquareRenderer());
        
        // Setup AWT frame
        frame.setSize(400, 400);
        frame.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
        frame.setVisible(true);

        // Render loop
        while (true) {
          canvas.display();
        }
      }
    }.start();
  }
}
