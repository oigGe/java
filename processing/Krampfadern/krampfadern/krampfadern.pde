void setup() {
  size(1000, 1000);
  background(0, 0, 0);
  frameRate(6000);
  noStroke();
}

void drawCircle(float x, float y) {
  
  ellipse(x, y, 1, 1);
}

int x = 500;
int y = 500;
int a = 500;
int b = 500;
void draw() {

  x += random(-1, 2);
  y += random(-1, 2);

  fill(255);
  drawCircle(x, y);
  a += random(-1, 2);
  b += random(-1, 2);
  a += random(-1, 2);
  b += random(-1, 2);
  if(a >= 1000 || a < 0){
  a = 500;
  }
  if(b >= 1000 || b < 0){
  b = 500;
  }
  drawCircle(a,b);
  println("a :" +  a);
  println("b :" + b);
}
