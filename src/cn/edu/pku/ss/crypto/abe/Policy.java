package cn.edu.pku.ss.crypto.abe;

import it.unisa.dia.gas.jpbc.Element;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.ss.crypto.abe.serialize.Serializable;
import cn.edu.pku.ss.crypto.abe.serialize.SimpleSerializable;

public class Policy implements SimpleSerializable{
	
	@Serializable
	int k;          
	@Serializable
	String attr;     
	@Serializable(group="G1")
	Element Cy;      
	@Serializable(group="G1")
	Element _Cy;    

	@Serializable
	Policy[] children;
	
	/* only used during encryption */
	transient Polynomial q;

	/* only used during decryption */
	transient int satisfiable;
	transient int min_leaves;
	transient int attri;
	transient List<Integer> satl;
}