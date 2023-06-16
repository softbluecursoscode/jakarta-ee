package br.com.softblue.javaee.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-25T11:53:08.763-0200")
@StaticMetamodel(Modulo.class)
public class Modulo_ {
	public static volatile SingularAttribute<Modulo, Integer> id;
	public static volatile SingularAttribute<Modulo, String> nome;
	public static volatile SingularAttribute<Modulo, Integer> posicao;
	public static volatile SingularAttribute<Modulo, Curso> curso;
	public static volatile ListAttribute<Modulo, Aula> aulas;
}
