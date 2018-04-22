public class EvalVisitor extends ExprBaseVisitor<Integer>{
	
	@Override public Integer visitAssign(ExprParser.AssignContext ctx) { 
		String id = ctx.ID().getText();
		System.out.print("(" + id + " ");
		visit(ctx.expr());
		System.out.print(")");
		System.out.println();
		return 0;

	}

	@Override public Integer visitBlank(ExprParser.BlankContext ctx) {
		System.out.println();
		return 0;
	}

	@Override public Integer visitParenc(ExprParser.ParencContext ctx) { 
		visit(ctx.expr());
		return 0;
	}

	@Override public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
		String op;
		if (ctx.op.getType() == ExprParser.MUL) op = "*";
		else if (ctx.op.getType() == ExprParser.DIV) op = "/";
		else op = "mod";
		System.out.print("(" + op + " ");
		visit(ctx.expr(0));
		System.out.print(" ");
		visit(ctx.expr(1));
		System.out.print(")");
		return 0;
	}

	@Override public Integer visitAddSub(ExprParser.AddSubContext ctx) {
		char op;
		if (ctx.op.getType() == ExprParser.ADD) op = '+';
		else op = '-';
		System.out.print("(" + op + " ");
		visit(ctx.expr(0));
		System.out.print(" ");
		visit(ctx.expr(1));
		System.out.print(")");	
		return 0;
	}

	@Override public Integer visitId(ExprParser.IdContext ctx) {
		String id = ctx.ID().getText();
		System.out.print(id);
		return 0;
	}

	@Override public Integer visitInt(ExprParser.IntContext ctx) {
		int value = Integer.valueOf(ctx.INT().getText());
		System.out.print(value);
		return 0;
	}


}
