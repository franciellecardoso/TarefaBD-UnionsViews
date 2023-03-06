package model;

public class Viagem {
	private int codigo;
	private String placa;
	private int hora_saida;
	private int hora_chegada;
	private String partida;
	private String destino;
	private Motorista motorista;
	private Onibus onibus;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(int hora_saida) {
		this.hora_saida = hora_saida;
	}
	public int getHora_chegada() {
		return hora_chegada;
	}
	public void setHora_chegada(int hora_chegada) {
		this.hora_chegada = hora_chegada;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	@Override
	public String toString() {
		return "Viagem [codigo=" + codigo + ", placa=" + placa + ", hora_saida=" + hora_saida + ", hora_chegada="
				+ hora_chegada + ", partida=" + partida + ", destino=" + destino + ", motorista=" + motorista
				+ ", onibus=" + onibus + "]";
	}
}
