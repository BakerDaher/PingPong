import java.awt.Color;
import java.awt.Graphics;
class Circle extends Drawable{
    public int r = 10 ;
    public int speedX = 100 ;
    public int speedY = 100 ;

    public Circle( double x , double y ){
        super( x , y ) ;
    }
    @Override
    public void draw(Graphics g){
        g.setColor( Color.RED) ;
        g.fillOval( (int)super.x , (int)super.y , r ,r) ;
    }
    public void moveCircle( double deltaTime , int windowWidth , int windowHeight ){
        super.x += deltaTime * speedX ;
        super.y += deltaTime * speedY ;
        if(super.checkYCollision ( windowHeight , r ) ) {
            speedY *= -1 ;   
        }
    }
}