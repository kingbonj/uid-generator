# uid-generator
Function:
Generates UID and random passkey from user inputted data.

Dependencies: 
Compiled using JDK 11.

Details:
UID Generator is used to convert user input 'seed' data into a unique code using a cipher algorithm. The program will also generate a random alphanumeric passkey and store both sets of data in a log file located in the working directory. The program can operate via command line or GUI interface.

It is important to note that the UID output is dependant on the seed data inputted by the user, however the passkey is randomised at each iteration. This means that users can retrieve their UID by rerunning the program but users will not be able to retrieve a passkey.

The UID and pass can not be cracked as some seed data is cropped during the cipher process. However should a user have access to your seed text/number the UID will be replicated. For these reasons the use of biographical or easily guessable input data is strongly discouraged. The requirement of three memorable keywords and a key number as seeds should add sufficient variation to the inputted data.

The log file outputted is stored in the local directory in clear text (uid.log). 

Security warning:
Users wishing to keep inputted personal data secure should ensure that the log file is properly deleted and the data wiped from memory. Inputted seed data is not saved in the log file, and the log is overwritten upon each new UID generation. 
