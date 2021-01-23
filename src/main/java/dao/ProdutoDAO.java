package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Produto;
import util.JPAUtil;

public class ProdutoDAO {
	public void inserir(Produto produto) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.persist(produto);
		transacao.commit();

		sessao.close();
	}

	public Produto buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Produto produto = sessao.find(Produto.class, codigo);

		sessao.close();
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> buscarTudo() {
		String jpql = "from Produto p order by p.nome";
		EntityManager sessao = JPAUtil.getEntityManager();

		Query consulta = sessao.createQuery(jpql);
		List<Produto> produtos = consulta.getResultList();

		sessao.close();
		return produtos;
	}

	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Produto produto = sessao.find(Produto.class, codigo);

		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.remove(produto);
		transacao.commit();

		sessao.close();
	}

	public void salvar(Produto produto) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.merge(produto);
		transacao.commit();

		sessao.close();
	}
}
