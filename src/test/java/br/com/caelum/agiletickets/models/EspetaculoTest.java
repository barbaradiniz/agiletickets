package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EspetaculoTest {
	private Espetaculo espetaculo;
	
	@Before
	public void setup() {
		espetaculo = new Espetaculo();
	}
	
	@Test
	public void criarSessoesInicioEFimIguaisPeriodicidadeDiaria() {
		
		LocalDate inicio = new LocalDate(2012,1,5);
		LocalTime horario = new LocalTime(3, 15);
		LocalDate fim = new LocalDate(2012,1,5);
		
		espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(2, espetaculo.getSessoes().size());
		
		Sessao sessao1 = espetaculo.getSessoes().get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
		
	}
	
	@Test
	public void criarSessoesInicioEFimIguaisPeriodicidadeSemanal() {
		LocalDate inicio = new LocalDate(2012, 1, 5);
		LocalTime horario = new LocalTime(3, 15);
		LocalDate fim = new LocalDate(2012, 1, 5);
				
		espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(1, espetaculo.getSessoes().size());
		
		Sessao sessao1 = espetaculo.getSessoes().get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
	}
	
	@Test
	public void criarSessoesIntervaloSeteDiasPeriodicidadeDiaria() {
		LocalDate inicio = new LocalDate(2012, 1, 5);
		LocalDate fim = new LocalDate(2012, 1, 11);
		
		LocalTime horario = new LocalTime(3, 16);
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(7, sessoes.size());
		
		for (Sessao sessao : sessoes) {
			Assert.assertEquals(inicio.toDateTime(horario), sessao.getInicio());
			inicio = inicio.plusDays(1);
		}
		
	
	}
	
	@Test
	public void criarSessoesIntervaloSeteDiasPeriodicidadeSemanal() {
		LocalDate inicio = new LocalDate(2012, 1, 5);
		LocalDate fim = new LocalDate(2012, 1, 11);
		
		LocalTime horario = new LocalTime(3, 16);
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(1, sessoes.size());
		
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao.getInicio());
		
	}
	
	@Test
	public void criarSessoesIntervaloOitoDiasPeriodicidadeSemanal() {
		LocalDate inicio = new LocalDate(2012, 1, 5);
		LocalDate fim = new LocalDate(2012, 1, 12);
		
		LocalTime horario = new LocalTime(3, 16);
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(2, sessoes.size());
		
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao.getInicio());
		
		inicio = inicio.plusDays(7);
		
		sessao = sessoes.get(1);
		Assert.assertEquals(inicio.toDateTime(horario), sessao.getInicio());
		
	}
	
	@Ignore
	@Test(expected=Exception.class)
	public void criarSessoesDataFinalMenorQueInicial() {
        
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2012,1,5);
		LocalDate fim = new LocalDate(2012,1,4);
		
		espetaculo.criaSessoes(inicio, fim, null, Periodicidade.DIARIA);
		
	}

	
}
