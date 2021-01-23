package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.ItemVenda;
import util.JPAUtil;

public class ItemVendaDAO {
	public void inserir(ItemVenda itemVenda) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.persist(itemVenda);
		transacao.commit();

		sessao.close();
	}

	public ItemVenda buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		ItemVenda itemVenda = sessao.find(ItemVenda.class, codigo);

		sessao.close();
		return itemVenda;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> buscatTudo() {		
		String jpql = "from ItemVenda i";
		EntityManager sessao = JPAUtil.getEntityManager();

		Query consulta = sessao.createQuery(jpql);
		List<ItemVenda> itemVendas = consulta.getResultList();

		sessao.close();
		return itemVendas;

	}

	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		ItemVenda itemVenda = sessao.find(ItemVenda.class, codigo);
		
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.remove(itemVenda);
		transacao.commit();
		
		sessao.close();
	}
	
	public void inserirOuEditar(ItemVenda itemVenda) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.merge(itemVenda);
		transacao.commit();
		
		sessao.close();
	}
}