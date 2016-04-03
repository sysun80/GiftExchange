# GiftExchange

HOW TO USE:
1. package a jar file. mvn clean compile assembly:single
   packaged jar also available at https://github.com/tonysun-sf/GiftExchange/tree/master/src/main/resources.
2. have a list of users ready in a text file. All user from the same family will be together, and different family will be seperated by an empty line. eg. https://github.com/tonysun-sf/GiftExchange/blob/master/src/main/resources/participants.txt.
3. In order to send emails, it requires a gmail username and password
4. command line arguments
-f text file location - required
-u gmail account username - optional
-p gmail account password - optional
5. run java command(java 8 is recommended)
java -jar com.tonysun.giftexchange-0.0.1-SNAPSHOT-jar-with-dependencies.jar -f /??/??/participants.txt -u ??? -p ???
