import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
	public static int PORT;
	public static void main(String[] args) throws IOException {
		PORT = Integer.parseInt(args[0]);
		ServerSocket s = new ServerSocket(PORT); /**/
		System.out.println("Started: " + s);



		try {

			Socket socket1 = s.accept();
			System.out.println("Connection accepted: " + socket1);
			Socket socket2 = s.accept();
			System.out.println("Connection accepted: " + socket2);


			try {
				BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
				PrintWriter out1 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream())), true);
				BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
				PrintWriter out2 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream())), true);

				System.out.println("100");

				String player1_name = in1.readLine();
				System.out.println("player1 name input");

				String player2_name = in2.readLine();
				System.out.println("player2 name input");



				System.out.println(player1_name + " vs " + player2_name);

				Random rand = new Random();
				int num = rand.nextInt(2);
				/*0:koutei, 1:dorei*/
				if (num == 0) {
					out1.println("0");
					out2.println("1");
				} else {
					out1.println("1");
					out2.println("0");
				}

				while (true) {

					String player1_card = in1.readLine();
					String player2_card = in2.readLine();



					System.out.println(player1_name + ", selecter_card = " + player1_card);
					System.out.println(player2_name + ", selected_card = " + player2_card);

					/*syoubu hanntei*/
					int result = Card.fight(player1_card, player2_card);



					if (result == 0) {
						System.out.println(player1_name + " won.");
						out1.println("Won!");
						out2.println("Lost");
						System.out.println("END");
						break;
					} else if (result == 1) {
						System.out.println("Draw");
						out1.println("Draw");
						out2.println("Draw");
					} else {
						System.out.println(player2_name + " won.");
						out1.println("Lost");
						out2.println("Won!");
						System.out.println("END");
						break;
					}

				}

			} finally {
				System.out.println("Closing...");
				socket1.close();
				socket2.close();
			}
		} finally {
			s.close();
		}
	}
}
