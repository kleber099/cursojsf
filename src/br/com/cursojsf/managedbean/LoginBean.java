package br.com.cursojsf.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.cursojsf.business.UsuarioBusiness;
import br.com.cursojsf.business.UsuarioInvalidoException;
import br.com.cursojsf.model.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	@ManagedProperty("#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuarioAutenticado;
	private String cpf;
	private String senha;
	

	public Usuario getUsuarioAutenticado() {
		return usuarioAutenticado;
	}



	public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}



	public String autenticar() {
		try {
			usuarioAutenticado = usuarioBusiness.autenticarUsuario(cpf, senha);
			return "index?faces-redirect=true";
		} catch (UsuarioInvalidoException e) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setDetail("Usuário Inválido");
			FacesContext.getCurrentInstance().addMessage("loginForm", message);
			return null;
		} finally {
			cpf = null;
			senha = null;
		}
	}
	
}
