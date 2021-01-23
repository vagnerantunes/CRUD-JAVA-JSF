package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Lote;
import util.JPAUtil;

public class LoteDAO {

	public void inserir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		Lote lote = sessao.find(Lote.class, codigo);

		transacao.begin();
		sessao.persist(lote);
		transacao.commit();

		sessao.close();
	}

	public Lote buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Lote lote = sessao.find(Lote.class, codigo);

		sessao.close();
		return lote;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lote> buscarTudo(){
		String jpql = "from Lote l";
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Query consulta = sessao.createQuery(jpql);
		List<Lote> lotes = consulta.getResultList();
		
		sessao.close();
		return lotes;
	}
	
	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Lote lote = sessao.find(Lote.class, codigo);
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.remove(lote);
		transacao.commit();
		sessao.close();
	}
	
	public void inserieOuEditar(Lote lote) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(lote);
		transacao.commit();
		sessao.close();	
	}	
}
