package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import dao.FuncionarioDAO;
import domain.Funcionario;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class FuncionarioBean {
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;

	private Integer codigo;

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public void novo() {
		funcionario = new Funcionario();
	}

	public void salvar() {
		funcionarioDAO.inserirOuEditar(funcionario);

		Messages.addFlashGlobalInfo("Funcionario salvo com sucesso");

		Faces.navigate("funcionario-listar.xhtml?faces-redirect-true");
	}

	public void listar() {
		funcionarios = funcionarioDAO.buscarTudo();
	}

	public void selecionar() {
		if (codigo == null) {
			Messages.addFlashGlobalInfo("Selecione um funcionario");
			Faces.navigate("funcionario-listar.xhtml?faces-redirect-true");
		} else {
			funcionario = funcionarioDAO.buscarPorCodigo(codigo);

			if (funcionario == null) {
				Messages.addFlashGlobalInfo("Selecione um funcionario");
				Faces.navigate("funcionario-listar.xhtml?faces-redirect-true");
			}

		}

	}

	public void excluir() {
		funcionarioDAO.excluir(codigo);

		Messages.addFlashGlobalInfo("Funcionario removido com sucesso");

		Faces.navigate("funcionario-listar.xhtml?faces-redirect-true");
	}

	public void editar() {

	}
}