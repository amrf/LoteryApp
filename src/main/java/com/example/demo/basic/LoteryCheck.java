package com.example.demo.basic;

import java.util.TreeSet;

public class LoteryCheck {

	private final String content;

	private TreeSet<Integer> resultado;

	public LoteryCheck(String content, TreeSet<Integer> resultado) {
		super();
		this.content = content;
		this.resultado = resultado;
	}

	public TreeSet<Integer> getResultado() {
		return resultado;
	}

	public void setResultado(TreeSet<Integer> resultado) {
		this.resultado = resultado;
	}

	public String getContent() {
		return content;
	}

}