package br.com.caelum.agiletickets.models;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EspetaculoTest {
	
	@Before
	public void setup() {
	}
	
	@Test
	public void criarSessoesInicioEFimIguaisPeriodicidadeDiaria() {
		
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2012,1,5);
		LocalTime horario = new LocalTime(3, 15);
		LocalDate fim = new LocalDate(2012,1,5);
		
		espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		
		Assert.assertEquals(1, espetaculo.getSessoes().size());
		
		Sessao sessao1 = espetaculo.getSessoes().get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
		
	}
	
	//public void criarSessoesIntervaloSeteDiasPeriodicidade
	
	@Test
	public void criarSessoesInicioEFimIguaisPeriodicidadeSemanal() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = new LocalDate(2012,1,5);
		LocalTime horario = new LocalTime(3, 15);
		LocalDate fim = new LocalDate(2012,1,5);
				
		espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		
		Assert.assertEquals(1, espetaculo.getSessoes().size());
		
		Sessao sessao1 = espetaculo.getSessoes().get(0);
		Assert.assertEquals(inicio.toDateTime(horario), sessao1.getInicio());
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
