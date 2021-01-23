package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Funcionario;
import util.JPAUtil;

public class FuncionarioDAO {

	public void inserir(Funcionario funcionario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.persist(funcionario);
		transacao.commit();

		sessao.clear();
	}

	public Funcionario buscarPorCodigo(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Funcionario funcionario = sessao.find(Funcionario.class, codigo);

		sessao.close();
		return funcionario;

	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTudo() {
		String jpql = "from Funcionario f";
		EntityManager sessao = JPAUtil.getEntityManager();

		Query consulta = sessao.createQuery(jpql);
		List<Funcionario> funcionarios = consulta.getResultList();

		sessao.close();
		return funcionarios;
	}

	public void excluir(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();

		Funcionario funcionario = sessao.find(Funcionario.class, codigo);

		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		sessao.remove(funcionario);
		transacao.commit();

		sessao.close();
	}

	public void editar(Integer codigo, Funcionario funcionarioEntrada) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Funcionario funcionario = sessao.find(Funcionario.class, codigo);
		EntityTransaction transacao = sessao.getTransaction();

		transacao.begin();
		funcionario.setNome(funcionarioEntrada.getNome());
		funcionario.setCpf(funcionarioEntrada.getCpf());
		transacao.commit();

		sessao.close();
	}

	public void inserirOuEditar(Funcionario funcionario) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		
		transacao.begin();
		sessao.merge(funcionario);
		transacao.commit();
		
		sessao.close();
	}
}
