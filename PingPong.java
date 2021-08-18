import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
class PingPong extends JPanel implements KeyListener{
    long lastFrameTime = System.currentTimeMillis() ;  
    Rectangle rect1 = new Rectangle( 3 , 200 ) ;
    Rectangle rect2 = new Rectangle( 570  , 200 ) ;
    Circle ball = new Circle( 5 ,  5 ) ;

    @Override
    protected void paintComponent(Graphics g ){
        long currentFrameTime = System.currentTimeMillis() ;
        double deltaTime = ( currentFrameTime - lastFrameTime ) / 1000.0 ;
        g.setColor( Color.BLACK) ;
        g.fillRect( 0 , 0 , getWidth() , getHeight() ) ;   
        rect1.draw(g) ;
        rect2.draw(g) ;
        ball.draw(g) ;
        rect1.moveRect( deltaTime , getWidth() , getHeight() ) ;
        rect2.moveRect( deltaTime , getWidth() , getHeight() ) ;
        ball. moveCircle( deltaTime , getWidth() , getHeight() ) ;
        if( rect1.checkCollision(ball)){
            ball.speedX = Math.abs( ball.speedX) ;
            ball.speedY *= -1 ;
        }
        else if( rect2.checkCollision(ball)){
            ball.speedX = -1 * Math.abs( ball.speedX) ;
            ball.speedY *= -1 ;
        }
        lastFrameTime = currentFrameTime ;
        this.repaint();  
    } 
    public void keyPressed(KeyEvent e){
        switch ( e.getKeyCode()){
            case 38 :
                rect2.UP() ;
              //  
                break;
            case 40 :
                rect2.Down() ;
                break;
            case 83 :
                rect1.Down() ;
                break;
            case 87 :
                rect1.UP() ;
                break;
        }
    }
    public void keyReleased(KeyEvent e){
        if( e.getKeyCode() == 87 || e.getKeyCode() == 83 )
            rect1.Stop() ;
        else if( e.getKeyCode() == 38 || e.getKeyCode() == 40 )
            rect2.Stop() ;
    }
    public void keyTyped(KeyEvent e){
    }
}