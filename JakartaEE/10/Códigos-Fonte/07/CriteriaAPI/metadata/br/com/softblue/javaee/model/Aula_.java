package br.com.softblue.javaee.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-25T11:53:08.734-0200")
@StaticMetamodel(Aula.class)
public class Aula_ {
	public static volatile SingularAttribute<Aula, Integer> id;
	public static volatile SingularAttribute<Aula, String> nome;
	public static volatile SingularAttribute<Aula, Integer> duracao;
	public static volatile SingularAttribute<Aula, Integer> posicao;
	public static volatile SingularAttribute<Aula, Modulo> modulo;
}
