import processing.serial.*;

Serial myPort;  // Create object from Serial class
String val;     // Data received from the serial port
float prevY = 0;

void setup()
{
  // I know that the first port in the serial list on my mac
  // is Serial.list()[0].
  // On Windows machines, this generally opens COM1.
  // Open whatever port is the one you're using.
  String portName = Serial.list()[0]; //change the 0 to a 1 or 2 etc. to match your port
  myPort = new Serial(this, portName, 9600);
  size(2000,1080);
  background(0);
  stroke(255);
}
void draw()
{
  
  if ( myPort.available() > 0) 
  {  // If data is available,
  val = myPort.readStringUntil('\n');         // read it and store it in val
  } 
println(val); //print it out in the console

//CHANGE THIS VARIABLE TO THE VARIABLE YOU WANNA PLOT:
  if (val != null){
   float f = float(trim(val))*(-10)+1000;
    stroke(255, 255, 255);
    strokeWeight(3);
    
  line(frameCount-1, prevY, frameCount, f);
  prevY = f;
  }
  else {
    line(frameCount-1, prevY, frameCount, prevY);
  }
if(frameCount >= 2000){
  background(0);
  frameCount = 0;
}
 
}
