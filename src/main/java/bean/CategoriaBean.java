package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.sun.faces.application.view.FaceletFullStateManagementStrategy;

import dao.CategoriaDAO;
import domain.Categoria;
import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class CategoriaBean {
	private Categoria categoria;
	private List<Categoria> categorias;

	private Integer codigo;

	private CategoriaDAO categoriaDAO = new CategoriaDAO();

	public void novo() {
		categoria = new Categoria();
	}

	public void salvar() {
		categoriaDAO.inserirOuEditar(categoria);

		Messages.addFlashGlobalInfo("Categoria salva com sucesso");

		Faces.navigate("categoria-listar.xhtml?faces-redirect-true");
	}

	public void listar() {
		categorias = categoriaDAO.buscarTudo();

	}

	public void selecionar() {
		if (codigo == null) {
			Messages.addFlashGlobalInfo("Selecione uma categoria");
			Faces.navigate("categoria-listar.xhtml?faces-redirect-true");
		} else {
			categoria = categoriaDAO.buscarPorCodigo(codigo);

			if (categoria == null) {
				Messages.addFlashGlobalInfo("Selecione uma categoria");
				Faces.navigate("categoria-listar.xhtml?faces-redirect-true");
			}
		}
	}

	public void exluir() {
		categoriaDAO.excluir(codigo);

		Messages.addFlashGlobalInfo("Categoria removida com sucesso");

		Faces.navigate("categoria-listar.xhtml?faces-redirect-true");
	}

	public void editar() {

	}
}