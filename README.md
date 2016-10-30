# MaxPay
Test Task

for max pay 
using Selenium web driver with page object pattern
also used io.github.bonigarcia lib for running test on latest browser versions 

There is 1 failing test because of a bug in the registration page.

Description 
Error popup does not disappear when user enters wrong confirmation password and then fixes it.

Steps: 
1. Enter valid email 
2. Enter valid password 
3. Enter NOT valid conformation password 
4. click somwere 
5. assert error pop up appeared 
6. Enter valid conformation password 

ER: 
pop up is dissapeared 

AR : 
Pop up is not dissapeared 
