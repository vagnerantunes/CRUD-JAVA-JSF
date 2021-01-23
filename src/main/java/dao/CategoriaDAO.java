package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Categoria;
import util.JPAUtil;

public class CategoriaDAO {
	
	public void inserir(Categoria categoria) {		
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.persist(categoria);
		transacao.commit();
		
		sessao.close();
	}
	
	public Categoria buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Categoria categoria = sessao.find(Categoria.class, codigo);
		
		sessao.close();
		return categoria;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTudo(){
		String jpql = "from Categoria c";
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Query consulta = sessao.createQuery(jpql);		
		List<Categoria> categorias = consulta.getResultList();		
		
		sessao.close();
		return categorias;
	}
	
	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Categoria categoria = sessao.find(Categoria.class, codigo);
		
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.remove(categoria);		
		transacao.commit();
		
		sessao.close();
	}
	
	public void editar(Integer codigo, Categoria categoriaEntreda) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		Categoria categoria = sessao.find(Categoria.class, codigo);
		
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		categoria.setNome(categoriaEntreda.getNome());
		transacao.commit();
		
		sessao.close();
	}
	
	public void inserirOuEditar(Categoria categoria) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.merge(categoria);
		transacao.commit();
		
		sessao.close();
	}
}
