package com.br.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
	private int Id;
	private int IdLivro;
	private int IdUsuario;
	private Date DataInicioEmp;
	private Date DataFimEmp;
	private long SetId;
	
	SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	String datainicio = fmt.format(DataInicioEmp);
	String datafim = fmt.format(DataFimEmp);
	
	public String getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}

	public String getDatafim() {
		return datafim;
	}

	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public long getSetId() {
		return SetId;
	}

	public void setSetId(long setId) {
		SetId = setId;
	}

	public long getId() {
		return Id;
	}

	public int getIdLivro() {
		return IdLivro;
	}

	public void setIdLivro(int idLivro) {
		IdLivro = idLivro;
	}

	public Date getDataInicioEmp() {
		return DataInicioEmp;
	}

	public void setDataInicioEmp(Date dataInicioEmp) {
		DataInicioEmp = dataInicioEmp;
	}

	public Date getDataFimEmp() {
		return DataFimEmp;
	}

	public void setDataFimEmp(Date dataFimEmp) {
		DataFimEmp = dataFimEmp;
	}

	public void setId(long setId) {
		SetId = setId;

	}
}