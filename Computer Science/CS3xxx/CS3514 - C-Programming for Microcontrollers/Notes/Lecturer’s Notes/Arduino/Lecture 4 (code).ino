//Toggle output pin with a noisey input.  
//Switching transition, from LOW to HIGH or from HIGH to LOW can be specified.
//The success of this solution depends on the characteristics of the device generating 
//the noisey input. Here it is assumed to be a switch with will bounce for no more than
//MAX_BOUNCE_TIME milliseconds. In that respect, this code is not strictly portable
//although it may work for a variety of inputs with this character of "noisiness"
//John P. Morrison 26/9/13

#define IN_PIN 8
#define OUT_PIN 13
#define MAX_BOUNCE_TIME 5

void setup(){
  pinMode(IN_PIN,  INPUT);
  pinMode(OUT_PIN, OUTPUT);
}

boolean debouncedRead(int pin, boolean state){
  if (digitalRead(pin) != state){
    delay(MAX_BOUNCE_TIME);
    return digitalRead(pin);
  } 
  return state;
}

void toggleOutPinWithInPin(int outPin, int inPin, int from, int to){
  static int currentInputState = LOW;
  static int prevInputState    = LOW;
  static int state             = LOW;
  
  currentInputState = debouncedRead(inPin, currentInputState);
  if (prevInputState == from && currentInputState == to)
    digitalWrite(outPin, (state = !state));
  prevInputState = currentInputState;
}


void loop(){
  toggleOutPinWithInPin(OUT_PIN, IN_PIN, LOW, HIGH);
}
