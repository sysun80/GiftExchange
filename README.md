# GiftExchange

HOW TO USE:<p/>
1. package a jar file. mvn clean compile assembly:single<p/>
   packaged jar also available at https://github.com/tonysun-sf/GiftExchange/tree/master/src/main/resources.<p/>
2. have a list of users ready in a text file. All user from the same family will be together, and different family will be seperated by an empty line.<p/> eg. https://github.com/tonysun-sf/GiftExchange/blob/master/src/main/resources/participants.txt.<p/>
3. In order to send emails, it requires a gmail username and password<p/>
4. command line arguments<p/>
-f text file location - required<p/>
-u gmail account username - optional<p/>
-p gmail account password - optional<p/>
5. run java command(java 8 is recommended)<p/>
java -jar com.tonysun.giftexchange-0.0.1-SNAPSHOT-jar-with-dependencies.jar -f /??/??/participants.txt -u ??? -p ???<p/>
