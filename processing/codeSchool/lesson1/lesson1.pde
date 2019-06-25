void setup() {
  size(800, 600);
  background(0, 0, 0);
  frameRate(60);
  noStroke();
}

void rightColumn(int x, int y) {
  fill(255, 0, 0);
  quad(0 + x, 75 + y, 62 +x, 75+ y, 62+x, 200+y, 0+x, 239+y);
}

void leftColumn(int x, int y) {
  fill(255, 0, 0);
  quad(202+x, 39+y, 264+x, 0+y, 264+x, 180+y, 202+x, 180+y);
}

void topLeftBottomRight(int x, int y) {
  fill(228, 58, 61);
  quad(0+x, 0+y, 264+x, 164+y, 264+x, 239+y, 0+x, 75+y);
}

void bottomLeftTopRight(int x, int y) {
  fill(69, 7, 48);
  quad(0+x, 239+y, 0+x, 164+y, 264+x, 0+y, 264+x, 75+y);
}

void drawLogo(int x, int y) {
  bottomLeftTopRight(x,y);
  rightColumn(x,y);
  leftColumn(x,y);
  topLeftBottomRight(x,y);
}

void draw() {
  drawLogo(0,0);
  drawLogo(300,100);
}
