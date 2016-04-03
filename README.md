# GiftExchange

Usage:
1. package a jar file eg. game.jar.
2. have a list of participants ready in a text file. All participants from the same family will be together, and different family will be seperated by an empty line. eg.
#file start
Brendan Lee <blee@example.com>
Peter Lee <peter@example.com>

Kevin Chen <kevin@example.com>
Tuan Chen <tchen@example.com>
#file end
3. In order to send emails, it requires a gmail username and password
4. command line arguments
-f text file location - required
-u gmail account username - optional
-p gmail account password - optional
5. run java command
java -jar game.jar -f /??/??/participants.txt -u ??? -p ???
