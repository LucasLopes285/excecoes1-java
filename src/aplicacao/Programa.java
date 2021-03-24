package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.println("Data da entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(sc.next());
		System.out.println("Data da saida (dd/MM/yyyy): ");
		Date saida = sdf.parse(sc.next());

		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva: a data de saida deve ser posterior a data de entrada.");
		} else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.println("Atualizar as datas: ");
			System.out.println("Data da entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(sc.next());
			System.out.println("Data da saida (dd/MM/yyyy): ");
			saida = sdf.parse(sc.next());

			Date agora = new Date();
			if (entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro na reserva: as datas devem ser datas futuras");
			} else if (!saida.after(entrada)) {
				System.out.println("Erro na reserva: a data de saida deve ser posterior a data de entrada.");
			} else {
				reserva.atualizarDatas(entrada, saida);
				System.out.println("Reserva: " + reserva);

			}

		}

		sc.close();
	}

}
