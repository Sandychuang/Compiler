package Parser.ASTs;

import Parser.*;
import Parser.IR.*;
import Parser.TypeSys.*;

public class ExprAccs_App extends AST {
	ExprAccs pre_accs;
	Gnrc_ArgLst gnrc_args;
	ExprPri_Var var;
	FuncApp_ArgLst arg_lst;
	String rst_val;
	String ref_type;
	String rst_type;
	String rst_func;
	String func_name;
	String func_sig;
	
	public void lnkApp(ExprAccs pre_accs,Gnrc_ArgLst g_lst,ExprPri_Var var,FuncApp_ArgLst arg_lst){
		this.pre_accs=pre_accs;
		this.gnrc_args=g_lst;
		this.var=var;
		this.arg_lst=arg_lst;
	}
	public void setApp(Gnrc_ArgLst g_lst, ExprPri_Var var, FuncApp_ArgLst arg_lst){
		this.var=var;
		this.arg_lst=arg_lst;
		this.gnrc_args=g_lst;
	}
	public boolean genCode(CodeGenerator codegen){
		if(this.pre_accs!=null)
			this.pre_accs.genCode(codegen);
		if(this.gnrc_args!=null)
			this.gnrc_args.genCode(codegen);
		if(this.arg_lst!=null)
			this.arg_lst.genCode(codegen);
		IRCode code=new IRCode("getFunc",this.rst_func,this.func_name,this.func_sig);
		codegen.addCode(code);
		codegen.incLineNo();1234
		//getMethod TODO
		code=new IRCode("invoke",this.rst_val,this.rst_func,String.valueOf(this.gnrc_args.size+this.arg_lst.size));
		codegen.addCode(code);
		codegen.incLineNo();
		return true;
	}
	public boolean genSymTb(CodeGenerator codegen){
		if(this.pre_accs!=null&&!this.pre_accs.genCode(codegen))
			return false;
		if(this.gnrc_args!=null&&!this.gnrc_args.genSymTb(codegen))
			return false;
		if(this.arg_lst!=null&&this.arg_lst.genSymTb(codegen))
			return false;
		this.rst_val="%"+codegen.getTmpSn();
		return true;
	}
	public boolean checkType(CodeGenerator codegen){
		if(this.pre_accs!=null&&!this.pre_accs.checkType(codegen))
			return false;
		if(this.gnrc_args!=null&&!this.gnrc_args.checkType(codegen))
			return false;
		if(this.arg_lst!=null&&!this.arg_lst.checkType(codegen))
			return false;
		R_Function f=codegen.getFuncInSymTb(this.var.name);
		
		if(f.isMulti()){2345
			for(R_Function f1:f.getMulti().values()){
				if(codegen.type_sys.checkFuncEx(f1, this.gnrc_args.gnrc_args, this.arg_lst.arg_types))
					return true;	
			}
			for(R_Function f1:f.getMulti().values()){
				if(codegen.type_sys.checkFuncCs(f1, this.gnrc_args.gnrc_args, this.arg_lst.arg_types))
					return true;	
			}
		}else{
			if(codegen.type_sys.checkFuncEx(f, this.gnrc_args.gnrc_args, this.arg_lst.arg_types))
				this.rst_val=f.getFuncName();
		}
		return true;
	}
}
