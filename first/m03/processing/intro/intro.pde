Ball b1;

void setup(){
  
  size(500,500);
  b1 = new Ball(width/2, height/2);
}

void draw(){
  background(255);
  b1.update();
  b1.checkEdges();
  b1.display();
}
