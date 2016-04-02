package Parser.TypeSys;

import java.util.*;
import Parser.*;
import Parser.IR.*;

public class T_Function extends T_Type {
	private String ret_type;
	private LinkedList<String> par_types;
	
	public String getRetType() {
		return ret_type;
	}
	public void setRetType(String ret_type) {
		this.ret_type = ret_type;
	}
	public LinkedList<String> getParTypes() {
		return par_types;
	}
	public void setParTypes(LinkedList<String> par_types) {
		this.par_types = par_types;
	}
	public void genFuncSig(CodeGenerator codegen) {
		String s="";
		if(this.isGnrc()){
			s+="<";
			for(String g:this.getGnrcPars()){
				s+=codegen.getTypeInSymTb(g).getTypeSig()+",";
			}
			s+=">";
		}
		s=codegen.getTypeInSymTb(this.ret_type).getTypeSig()+"(";
		for(String name:this.par_types){
			s+=codegen.getTypeInSymTb(name).getTypeSig()+",";
		}
		s+=")";		
		this.setTypeSig(s);
	}
}
