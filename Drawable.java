import java.awt.Graphics;
class Drawable{
    public double x , y ;
    public int w = 10 ;
    public int h = 100 ;
    public Drawable( double x , double y ){
        this.x = x ;
        this.y = y ;
    }
    public void draw(Graphics g){
    } 
    public boolean checkCollision( Drawable object ){
        if( this == object)
            return false ;
        return(checkInside( object.x , object.y ) ||
               checkInside( object.x + object.w , object.y) ||
               checkInside( object.x , object.y + object.h ) ||
               checkInside( object.x + object.w , object.y+ object.h )  ) ;
    }
    public boolean checkInside( double x , double y ){
        return ( x >= this.x && x <= this.x + w && y >= this.y && y <= this.y + h ) ;
    } 
    public boolean checkXCollision (int windowWidth  ) {
        return ( ( x <= 0 )|| ( x + w ) >= windowWidth );
    }
    public boolean checkYCollision (int windowHeight , int i ){
        return (y <= 0 || ( y + i ) >= windowHeight );
    }
}