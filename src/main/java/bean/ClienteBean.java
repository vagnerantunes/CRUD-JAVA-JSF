package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import dao.ClienteDAO;
import domain.Categoria;
import domain.Cliente;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class ClienteBean {
	private Cliente cliente;
	private List<Cliente> clientes;

	private Integer codigo;

	private ClienteDAO clienteDAO = new ClienteDAO();

	public void novo() {
		cliente = new Cliente();
	}

	public void salvar() {
		clienteDAO.inserirOuEditar(cliente);

		Messages.addFlashGlobalInfo("Cliente salvo com sucesso");

		Faces.navigate("cliente-listar.xhtml?faces-redirect-true");
	}

	public void listar() {
		clientes = clienteDAO.buscarTudo();
	}

	public void selecionar() {
		if (codigo == null) {
			Messages.addFlashGlobalInfo("selecione um cliente");
			Faces.navigate("cliente-listar.xhtml?faces-redirect-true");
		} else {
			cliente = clienteDAO.buscarPorCodigo(codigo);

			if (cliente == null) {
				Messages.addFlashGlobalInfo("selecione um cliente");
				Faces.navigate("cliente-listar.xhtml?faces-redirect-true");
			}

		}

	}

	public void exluir() {
		clienteDAO.excluir(codigo);

		Messages.addFlashGlobalInfo("Categoria removida com sucesso");

		Faces.navigate("cliente-listar.xhtml?faces-redirect-true");
	}

	public void editar() {

	}
}
