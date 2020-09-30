class Ball{
  float x = 0;
  float y = 0;
  float xspeed;
  float yspeed;
  
  
  public Ball (float pX, float pY){
    
    x = pX;
    y = pY;
    xspeed = 5f;
    yspeed = 2.3f;
  }
  
  void update(){
    x += xspeed;
    y += yspeed;
  }
  
  void checkEdges(){
    
    if(x + xspeed > width || x + xspeed < 0){
      xspeed *= -1f;
    }
    
    
    if(y + yspeed> width || y + yspeed < 0){
      yspeed *= -1f;
    }
  }
  
  void display(){
    stroke(0);
    fill(127);
    ellipse(x, y, 32, 32);
  }


}
