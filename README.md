
server:
java -cp target/day06-workshop-1.0-SNAPSHOT.jar sg.edu.nus.iss.app.server.ServerApp 12345 "cookies_file.txt"



client:
java -cp target/day06-workshop-1.0-SNAPSHOT.jar sg.edu.nus.iss.app.client.ClientApp localhost:12345



get-cookie