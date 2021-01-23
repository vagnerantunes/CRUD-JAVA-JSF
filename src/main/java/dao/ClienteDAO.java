package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Cliente;
import util.JPAUtil;

public class ClienteDAO {

	public void inserir(Cliente cliente) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.persist(cliente);
		transacao.commit();

		sessao.close();
	}

	public Cliente buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Cliente cliente = sessao.find(Cliente.class, codigo);
		sessao.close();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTudo() {
		String jpql = "from Cliente c";
		EntityManager sessao = JPAUtil.getEntityManager();

		Query consulta = sessao.createQuery(jpql);
		List<Cliente> clientes = consulta.getResultList();

		sessao.clear();
		return clientes;
	}

	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Cliente cliente = sessao.find(Cliente.class, codigo);

		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.remove(cliente);
		transacao.commit();

		sessao.close();
	}
	
	public void editar(Integer codigo, Cliente clienteEntreda) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Cliente cliente = sessao.find(Cliente.class, codigo);
		
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		cliente.setNome(clienteEntreda.getNome());
		cliente.setCpf(clienteEntreda.getCpf());
		transacao.commit();
		
		sessao.close();
	}
	
	public void inserirOuEditar(Cliente cliente) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.merge(cliente);
		transacao.commit();
		
		sessao.close();
	}	
}