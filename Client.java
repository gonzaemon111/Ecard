import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Client {
	public static String my_num;
	static int num;
	public static int PORT;
	static String name;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String selected_card = "";
		String result;
		int i = 0;
		InetAddress addr = InetAddress.getByName("192.168.11.11");
		System.out.println("addr = " + addr);
		PORT = Integer.parseInt(args[0]);
		Socket socket = new Socket(addr, PORT);

		try {
			System.out.println("socket = " + socket);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

			System.out.print("Input your name: ");
			name = scanner.next();
			System.out.println(name + ", let's begin Ecard!");

			out.println(name);

			while (true) {
				my_num = in.readLine();
				if (my_num.equals("0") || my_num.equals("1")) {
					break;
				}
			}

			if (my_num.equals("0")) {
				System.out.println("<Emperor>");
			} else {
				System.out.println("<Slave>");
			}


			Emperor emp = new Emperor();
			Slave sla = new Slave();



			while (true) {
				while(true) {

					if (my_num.equals("0")) {
						System.out.println("You have Emperor * " + emp.emperor + ", Citizen * " + emp.citizen);
						System.out.println("");
						System.out.println("[Emperor : 0, Citizen : 1]");
					} else {
						System.out.println("You have Slave * " + sla.slave + ", Citizen * " + sla.citizen);
						System.out.println("");
						System.out.println("[Slave : 0, Citizen : 1]");
					}

					System.out.print("Choose the card: ");
					num = scanner.nextInt();

					if (my_num.equals("0")) {
						if ((emp.emperor != 0 && num == 0) || (emp.citizen != 0 && num == 1)) {
							break;
						}
					} else {
						if ((sla.slave != 0 && num == 0) || (sla.citizen != 0 && num == 1)) {
							break;
						}
					}

					System.out.println("Choice error! Try again.");
					System.out.println("");
					System.out.println("------------------------------");
					System.out.println("");
				}


				if (my_num.equals("0")) {
					if (num == 0) {
						selected_card = "Emperor";

					} else {
						selected_card = "Citizen";
					}
					emp.choose(num);
				} else {
					if (num == 0) {
						selected_card = "Slave";
					} else {
						selected_card = "Citizen";
					}
					sla.choose(num);
				}

				out.println(selected_card);

				System.out.println("You chose " + selected_card);

				result = in.readLine();
				if (result.equals("Won!") || result.equals("Lost")) {
					System.out.println("You " + result);
					System.out.println("");
					System.out.println("END");
					break;
				} else {
					System.out.println(result);
					System.out.println("");
					System.out.println("------------------------------");
					System.out.println("");
				}

				/*kokoha while bun wo tukau
				ima karini citizen wo erandatoki*/

				//String selected_card = "citizen";

				/*String selected_card = "";
				if (my_num.equals("0")) {
					selected_card = "emperor";
				} else {
					selected_card = "citizen";
				}*/

				/*
				while (true) {
					out.println(my_num);
					out.println(selected_card);
					if (my_num.equals("0")) {
						emp.choose(selected_card);
					} else {
						sla.choose(selected_card);
					}



				}
				*/

				/*
					String result = in.readLine();
					System.out.println(result);
					i++;
					if (i == 2) {
						break;
					}
				*/
			}



			/*
			for (int i = 0; i < 10; i++) {
				out.println("howdy " + i);
				String str = in.readLine();
				System.out.println("str = " + str);
				System.out.println(str);
			}
			*/

			//out.println("END");
		} finally {
			System.out.println("closing...");
			socket.close();
		}





	}
}
