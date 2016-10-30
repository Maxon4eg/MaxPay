# MaxPay
Test Task

for max pay 
using Selenium web driver with page object pattern
also used io.github.bonigarcia lib for running test on latest browser versions 

there will be 1 failed test because of bug in registration page 

Description 
when user inputed not valid conformation password 
and after that input valid conformation password 
error popup is not disappear 

Steps: 
1. input valid email 
2. input valid password 
3. input NOT valid conformation password 
4. click somwere 
5. assert error pop up appeared 
6. input valid conformation password 

EP: 
pop up is dissapeared 

AP : 
Pop up is not dissapeared 
