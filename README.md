# uid-generator
Function:
Generates UID and random passkey from user inputted data.

Dependencies: 
Compiled using JDK 11.

Details:
UID Generator is used to convert user input 'seed' data into a unique code using a cipher algorithm. The program will also generate a random alphanumeric passkey and store both sets of data in a log file located in the working directory. The program can operate via command line or GUI interface.

The UID and passkey are unlikely to be cracked as some seed data is cropped during the cipher process. However should a user have access to your seed variables the UID will be replicated. For these reasons the use of biographical or easily guessable input data is strongly discouraged, and the use of a trusted virtual keyboard is recommended to protect against possible keyloggers. 

It is important to note that the UID output is generated from the seed data inputted by the user, however the passkey is randomised at each iteration. This means that users can retrieve their UID by rerunning the program and inputting the same variables however users will not be able to retrieve a passkey via the same method. The requirement of three memorable keywords and a key number as seeds should add sufficient variation to the inputted data to prevent others from reproducing your UID.

The log file outputted is stored in the local directory in clear text (uid.log). Users wishing to keep inputted personal data secure should ensure that the log file is properly deleted and the data wiped from memory. Inputted seed data is not saved in the log file, and the log is overwritten upon each new UID generation. 

The code is freely available to use and reproduce under the GPL, however it is unlikely to be useful to anyone other than the intended end-users.
