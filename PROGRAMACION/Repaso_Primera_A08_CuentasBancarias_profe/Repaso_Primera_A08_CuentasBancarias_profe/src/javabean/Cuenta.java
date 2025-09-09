package javabean;

public class Cuenta {
	
	private int numeroCuenta;
	private String tipoCuenta;
	private String titular;
	private double saldo;
	
	
	
	public Cuenta(int numeroCuenta, String tipoCuenta, String titular, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}
	

	public Cuenta() {
		super();
	}
	
	

	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	


	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", titular=" + titular
				+ ", saldo=" + saldo + "]";
	}


	/*
	 * METODOS PROPIOS. RESPONSABILIDAD DE LA CLASE
	 */
	public void abono(double importe) {
		
		saldo += importe;
		
	}
	
	public boolean extraer(double importe) {
		if (importe > saldo)
			return false;
		else {
			saldo -= importe;
			return true;
		}
	}
	
	public boolean transferir(Cuenta cuentaDestino, double importe) {
		
		if (this.extraer(importe)) {
			cuentaDestino.abono(importe);
			return true;
		}else { 
			return false;
		}
		
		
		 
	}
	
	


}
