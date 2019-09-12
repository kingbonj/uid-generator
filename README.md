# uid-generator
Generates UID and random passkey from user inputted data.

This UID Generator is used to convert various user input data into a   unique code using a cipher algorithm. The program will also generate a random alphanumeric passkey and store data in a log file.

It is important to note that the UID output is dependant on the seed data inputted by the user, however the passkey is randomised at each iteration. This means that users can retrieve their UID by rerunning the program but users will not be able to retrieve a passkey.

Due to a deliberate design choice the UID can not be cracked by persons attempting to reverse engineer the code of this program as some data is cropped during the cipher process. However should a user have access to your seed text the UID will be reiterated. For these reasons the use of biographical data is strongly discouraged. The use of memorable keywords as foundation seeds should add sufficient variation to the inputted data.

The log file outputted at the request of the user is stored in the local directory in clear text (uid.log). Users wishing to keep inputted personal data secure should ensure that the log file is properly deleted and the data wiped from memory. Seed data is not saved in the log file.
