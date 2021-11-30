package repositorios;

import modelos.Usuario;

public class UsuarioRepositorio extends Repositorio<Usuario,Integer>{

	@Override
	public Class<Usuario> minhaClasse() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

}
