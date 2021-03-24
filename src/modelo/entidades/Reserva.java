package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDoQuarto, Date entrada, Date saida) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public Integer getNumeroDoQuarto() {
		return this.numeroDoQuarto;
	}
	
	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}
	
	public Date getEntrada() {
		return this.entrada;
	}
	
	public Date getSaida() {
		return this.saida;
	}
	
	public long duracao() {
		// diferença entre as duas datas em milisegundos
		long diferenca = saida.getTime() - entrada.getTime();
		
		// conversão milisegundos para dia
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
		
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroDoQuarto
				+ ", entrada: "
				+ sdf.format(entrada)
				+ ", saida: "
				+ sdf.format(saida)
				+ ", "
				+ duracao()
				+ " noites";
	}

}
