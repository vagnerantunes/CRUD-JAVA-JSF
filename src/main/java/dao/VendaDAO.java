package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Venda;
import util.JPAUtil;

public class VendaDAO {
	
	public void inserir(Venda venda) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.persist(venda);
		transacao.commit();
		
		sessao.close();
	}
	
	public Venda buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Venda venda = sessao.find(Venda.class, codigo);
		
		sessao.close();
		return venda;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> buscarTudo(){
		String jpql = "from Venda v";
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Query consulta = sessao.createQuery(jpql);
		List<Venda> vendas = consulta.getResultList();
		
		sessao.close();
		return vendas;		
	}
	
	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Venda venda = sessao.find(Venda.class, codigo);
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.remove(venda);
		transacao.commit();
		sessao.close();
	}
	
	
}
