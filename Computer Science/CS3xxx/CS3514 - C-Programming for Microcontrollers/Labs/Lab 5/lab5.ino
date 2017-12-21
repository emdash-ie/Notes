/*
  LiquidCrystal Library - Hello World

 Demonstrates the use a 16x2 LCD display.  The LiquidCrystal
 library works with all LCD displays that are compatible with the
 Hitachi HD44780 driver. There are many of them out there, and you
 can usually tell them by the 16-pin interface.

 This sketch prints "Hello World!" to the LCD
 and shows the time.

  The circuit:
 * LCD RS pin to digital pin 12
 * LCD Enable pin to digital pin 11
 * LCD D4 pin to digital pin 5
 * LCD D5 pin to digital pin 4
 * LCD D6 pin to digital pin 3
 * LCD D7 pin to digital pin 2
 * LCD R/W pin to ground
 * LCD VSS pin to ground
 * LCD VCC pin to 5V
 * 10K resistor:
 * ends to +5V and ground
 * wiper to LCD VO pin (pin 3)

 Library originally added 18 Apr 2008
 by David A. Mellis
 library modified 5 Jul 2009
 by Limor Fried (http://www.ladyada.net)
 example added 9 Jul 2009
 by Tom Igoe
 modified 22 Nov 2010
 by Tom Igoe
 modified 7 Nov 2016
 by Arturo Guadalupi

 This example code is in the public domain.

 http://www.arduino.cc/en/Tutorial/LiquidCrystalHelloWorld

*/

// include the library code:
#include <LiquidCrystal.h>

// initialize the library by associating any needed LCD interface pin
// with the arduino pin number it is connected to
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

#define BUTTON1_PIN 8
#define BUTTON2_PIN 7
#define BUZZER 10

// countdown variables
unsigned long countdown = 1;
unsigned long countdownStart = 0;


void setup() {
  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  pinMode(BUTTON1_PIN, INPUT_PULLUP);
  pinMode(BUTTON2_PIN, INPUT_PULLUP);
  pinMode(BUZZER, OUTPUT);
}

void loop() {
    checkButton1();
    checkButton2();

    if (countdownStart && millis() > countdownStart + 1000) {
        countdown--;
        countdownStart += 1000;
    }

    printCountdown();
    delay(50);
}

void checkButton1() {
    static boolean lastState = false;
    boolean currentState = !digitalRead(BUTTON1_PIN);
    if (currentState && !lastState) {
        countdown++;
    }
    lastState = currentState;
}

void checkButton2() {
    if (!digitalRead(BUTTON2_PIN)) {
        if (!countdownStart) {
            countdownStart = millis();
        }
    }
}

void printCountdown() {
    // clear screen and move cursor to (0, 0)
    lcd.clear();
    lcd.setCursor(0, 0);
    // print the number of seconds since reset:
    lcd.print(countdown);

    if (countdownStart && countdown == 0) {
        lcd.setCursor(0, 1);
        buzz();
        countdownStart = 0;
    }
}

void buzz() {
  analogWrite(BUZZER, 127);
  delay(1000);
  analogWrite(BUZZER, 0);
}

