import java.awt.Color;
import java.awt.Graphics;
class Rectangle extends Drawable {
    public int speed = 0 ;
    public Rectangle( double x , double y ){
        super( x , y );
    }
    @Override 
    public void draw(Graphics g){
        g.setColor( Color.RED) ;
        g.fillRect( (int)super.x , (int)super.y , super.w , super.h) ;
    }
    public void UP(){
        speed = -200 ;
    }
    public void Down(){
        speed = 200 ;
    }
    public void Stop(){
        speed = 0 ;
    }
    public void moveRect( double deltaTime , int windowWidth , int windowHeight ){
        super.y += speed * deltaTime ;
        if( y <= 0 && speed < 0 ){
            this.Stop() ;
        }
        else if( ( y + h ) >= windowHeight && speed > 0  ){
            this.Stop() ;
        }
    }
}