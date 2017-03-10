package cn.edu.pku.ss.crypto.abe.apiV2;

import cn.edu.pku.ss.crypto.abe.CPABEImplWithoutSerialize;
import cn.edu.pku.ss.crypto.abe.CPABEImplWithoutSerialize.KeyPair;


public class Server {
	private KeyPair pair;
	
	public Server(){
		this.pair = CPABEImplWithoutSerialize.setup();
	}
	
	public String getPublicKeyInString(){
		System.out.println(pair.getPKJSONString());
		return pair.getPKJSONString();
	}
	public String getMasterKeyInString(){
		System.out.println(pair.getMKJSONString());
		return pair.getMKJSONString();
	}
	
	public String generateSecretKey(String[] attrs){
		return CPABEImplWithoutSerialize.keygen(attrs, pair.getPK(), pair.getMK());
	}
}
