package cn.edu.pku.ss.crypto.abe;

import it.unisa.dia.gas.jpbc.Element;

import cn.edu.pku.ss.crypto.abe.serialize.Serializable;
import cn.edu.pku.ss.crypto.abe.serialize.SimpleSerializable;

public class PublicKey implements SimpleSerializable {
	@Serializable(group="G1")
	Element g; 
	
	@Serializable(group="G2")
	Element gp; 
	
	@Serializable(group="GT")
	Element g_hat_alpha; 
	
	@Serializable(group="G1")
	Element h; 

}
