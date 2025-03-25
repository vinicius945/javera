package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class TesteCadastro {

	public static void main(String[] args) {
		//Instanciar um Cliente sem o ID (pode criar o construtor)
		Cliente cliente = new Cliente("Pablo", new GregorianCalendar(2005, Calendar.JANUARY, 17), 
																	15000000.0, "44522233377", Genero.MASCULINO);
		//Instaciar uma fabrica de Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Chamar o metodo persist() do Entity Manager
		em.persist(cliente);
		
		//Transacao - Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Cliente cadastrado!");
	}
}