// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(IsiLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdmat}.
	 * @param ctx the parse tree
	 */
	void enterCmdmat(IsiLangParser.CmdmatContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdmat}.
	 * @param ctx the parse tree
	 */
	void exitCmdmat(IsiLangParser.CmdmatContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdexp}.
	 * @param ctx the parse tree
	 */
	void enterCmdexp(IsiLangParser.CmdexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdexp}.
	 * @param ctx the parse tree
	 */
	void exitCmdexp(IsiLangParser.CmdexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdraiz}.
	 * @param ctx the parse tree
	 */
	void enterCmdraiz(IsiLangParser.CmdraizContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdraiz}.
	 * @param ctx the parse tree
	 */
	void exitCmdraiz(IsiLangParser.CmdraizContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdlog}.
	 * @param ctx the parse tree
	 */
	void enterCmdlog(IsiLangParser.CmdlogContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdlog}.
	 * @param ctx the parse tree
	 */
	void exitCmdlog(IsiLangParser.CmdlogContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdtesta}.
	 * @param ctx the parse tree
	 */
	void enterCmdtesta(IsiLangParser.CmdtestaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdtesta}.
	 * @param ctx the parse tree
	 */
	void exitCmdtesta(IsiLangParser.CmdtestaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdcaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdcaso(IsiLangParser.CmdcasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdcaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdcaso(IsiLangParser.CmdcasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdenq}.
	 * @param ctx the parse tree
	 */
	void enterCmdenq(IsiLangParser.CmdenqContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdenq}.
	 * @param ctx the parse tree
	 */
	void exitCmdenq(IsiLangParser.CmdenqContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(IsiLangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(IsiLangParser.FatorContext ctx);
}