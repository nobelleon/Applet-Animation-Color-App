/**
 * @(#) ColorAnimation.java
 *
 * ColorAnimation Applet application
 *
 * @author nObeLLeon
 * @version 1.00 2020/6/6
 ***********************************************  Program Successful  *******************************************************************
 */

import java.awt.*;
import java.applet.*;


/*
 * <html>
	<head>
	</head>
	<body bgcolor="000000">
		<center>
			<applet
				code	= "ColorAnimation.class"
				width	= "315"
				height	= "315"
				>
			</applet>
		</center>
	</body>
</html>
 */

 public class ColorAnimation extends Applet implements Runnable {
 
     Image Buffer;
     Graphics gBuffer;
     Color myColors[];
     Thread runner;
     
     public void init(){
        // Menyediakan tempat dimana kita dapat melakukan penggambaran
        Buffer = createImage(size().width, size().height);
        gBuffer = Buffer.getGraphics();
        myColors = new Color[100];
     }

     public void start(){
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
     }

     public void stop(){
        if (runner != null) {
            runner.stop();
            runner = null;
        }
     }

     public void run(){
        while (true) {
            try {
                // Waktu tunda sebesar 100 miliseconds
                runner.sleep(100);
            }
            catch (Exception e) {
               
            }
            getNewColors();
            repaint();
        }
     }
      
     public void getNewColors(){
        int i=0;

        // Membuat warna baru secara acak
        for(int x=0; x<300; x+=30)
        for(int y=0; y<300; y+=30){
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            myColors[i] = new Color(red,green,blue);
            gBuffer.setColor(myColors[i]);
            gBuffer.fillRect(x, y, 60, 60);
            i++;
        }
     }

     public void update(Graphics g){
       paint(g);
     }

     public void paint(Graphics g){
        // Menduplikat buffer ke layar
        g.drawImage(Buffer,0,0,this);
     }
 }