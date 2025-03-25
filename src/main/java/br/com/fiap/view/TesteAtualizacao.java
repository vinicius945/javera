package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;

public class TesteAtualizacao {

	public static void main(String[] args) {
		//Instanciar um Cliente com um Id valido
		Cliente cliente  = new Cliente("1berto", 
				new GregorianCalendar(2013, Calendar.OCTOBER, 25), 
				100.0, "2225646546", Genero.OUTROS);
		
		cliente.setId(16);
		
		//Criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Criar o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Atualizar o cliente no banco de dados
		Cliente copiaGerenciada = em.merge(cliente);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		copiaGerenciada.setNome("Felipe Tranquilo");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Cliente atualizado!");
	}
}