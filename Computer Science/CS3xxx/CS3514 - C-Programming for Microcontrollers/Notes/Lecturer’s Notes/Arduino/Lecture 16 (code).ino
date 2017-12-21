#include <avr/interrupt.h>


void setup(){
   pinMode(13, OUTPUT);
   cli(); //Disable global interrupts
   TCCR1A = 0;
   TCCR1B = 0;
   OCR1A = 15625; //Set the count corresponding to 1 second
   TCCR1B |= (1 << WGM12); //Turn on CTC mode
   TCCR1B |= (1 << CS10);
   TCCR1B |= (1 << CS12); //Prescale at 1024
   TIMSK1 |= (1<< OCIE1A); //Enable CTC interrupt
   sei(); //Enable Global Interrupts
}

void loop(){}


ISR (TIMER1_COMPA_vect){
  digitalWrite(13, !digitalRead(13));
}
