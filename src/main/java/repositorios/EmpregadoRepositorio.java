package repositorios;

import modelos.Empregado;

public class EmpregadoRepositorio extends Repositorio<Empregado, Integer>{

	@Override
	public Class<Empregado> minhaClasse() {
		// TODO Auto-generated method stub
		return Empregado.class;
	}

}
