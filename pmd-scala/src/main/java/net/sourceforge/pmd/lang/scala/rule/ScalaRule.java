/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.scala.ScalaLanguageModule;
import net.sourceforge.pmd.lang.scala.ast.ASTCase;
import net.sourceforge.pmd.lang.scala.ast.ASTCtorPrimary;
import net.sourceforge.pmd.lang.scala.ast.ASTCtorSecondary;
import net.sourceforge.pmd.lang.scala.ast.ASTDeclDef;
import net.sourceforge.pmd.lang.scala.ast.ASTDeclType;
import net.sourceforge.pmd.lang.scala.ast.ASTDeclVal;
import net.sourceforge.pmd.lang.scala.ast.ASTDeclVar;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnClass;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnDef;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnMacro;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnObject;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnTrait;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnType;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnVal;
import net.sourceforge.pmd.lang.scala.ast.ASTDefnVar;
import net.sourceforge.pmd.lang.scala.ast.ASTEnumeratorGenerator;
import net.sourceforge.pmd.lang.scala.ast.ASTEnumeratorGuard;
import net.sourceforge.pmd.lang.scala.ast.ASTEnumeratorVal;
import net.sourceforge.pmd.lang.scala.ast.ASTImport;
import net.sourceforge.pmd.lang.scala.ast.ASTImporteeName;
import net.sourceforge.pmd.lang.scala.ast.ASTImporteeRename;
import net.sourceforge.pmd.lang.scala.ast.ASTImporteeUnimport;
import net.sourceforge.pmd.lang.scala.ast.ASTImporteeWildcard;
import net.sourceforge.pmd.lang.scala.ast.ASTImporter;
import net.sourceforge.pmd.lang.scala.ast.ASTInit;
import net.sourceforge.pmd.lang.scala.ast.ASTLitBoolean;
import net.sourceforge.pmd.lang.scala.ast.ASTLitByte;
import net.sourceforge.pmd.lang.scala.ast.ASTLitChar;
import net.sourceforge.pmd.lang.scala.ast.ASTLitDouble;
import net.sourceforge.pmd.lang.scala.ast.ASTLitFloat;
import net.sourceforge.pmd.lang.scala.ast.ASTLitInt;
import net.sourceforge.pmd.lang.scala.ast.ASTLitLong;
import net.sourceforge.pmd.lang.scala.ast.ASTLitNull;
import net.sourceforge.pmd.lang.scala.ast.ASTLitShort;
import net.sourceforge.pmd.lang.scala.ast.ASTLitString;
import net.sourceforge.pmd.lang.scala.ast.ASTLitSymbol;
import net.sourceforge.pmd.lang.scala.ast.ASTLitUnit;
import net.sourceforge.pmd.lang.scala.ast.ASTModAbstract;
import net.sourceforge.pmd.lang.scala.ast.ASTModAnnot;
import net.sourceforge.pmd.lang.scala.ast.ASTModCase;
import net.sourceforge.pmd.lang.scala.ast.ASTModContravariant;
import net.sourceforge.pmd.lang.scala.ast.ASTModCovariant;
import net.sourceforge.pmd.lang.scala.ast.ASTModFinal;
import net.sourceforge.pmd.lang.scala.ast.ASTModImplicit;
import net.sourceforge.pmd.lang.scala.ast.ASTModInline;
import net.sourceforge.pmd.lang.scala.ast.ASTModLazy;
import net.sourceforge.pmd.lang.scala.ast.ASTModOverride;
import net.sourceforge.pmd.lang.scala.ast.ASTModPrivate;
import net.sourceforge.pmd.lang.scala.ast.ASTModProtected;
import net.sourceforge.pmd.lang.scala.ast.ASTModSealed;
import net.sourceforge.pmd.lang.scala.ast.ASTModValParam;
import net.sourceforge.pmd.lang.scala.ast.ASTModVarParam;
import net.sourceforge.pmd.lang.scala.ast.ASTNameAnonymous;
import net.sourceforge.pmd.lang.scala.ast.ASTNameIndeterminate;
import net.sourceforge.pmd.lang.scala.ast.ASTPatAlternative;
import net.sourceforge.pmd.lang.scala.ast.ASTPatBind;
import net.sourceforge.pmd.lang.scala.ast.ASTPatExtract;
import net.sourceforge.pmd.lang.scala.ast.ASTPatExtractInfix;
import net.sourceforge.pmd.lang.scala.ast.ASTPatInterpolate;
import net.sourceforge.pmd.lang.scala.ast.ASTPatSeqWildcard;
import net.sourceforge.pmd.lang.scala.ast.ASTPatTuple;
import net.sourceforge.pmd.lang.scala.ast.ASTPatTyped;
import net.sourceforge.pmd.lang.scala.ast.ASTPatVar;
import net.sourceforge.pmd.lang.scala.ast.ASTPatWildcard;
import net.sourceforge.pmd.lang.scala.ast.ASTPatXml;
import net.sourceforge.pmd.lang.scala.ast.ASTPkg;
import net.sourceforge.pmd.lang.scala.ast.ASTPkgObject;
import net.sourceforge.pmd.lang.scala.ast.ASTQuasi;
import net.sourceforge.pmd.lang.scala.ast.ASTSelf;
import net.sourceforge.pmd.lang.scala.ast.ASTSource;
import net.sourceforge.pmd.lang.scala.ast.ASTTemplate;
import net.sourceforge.pmd.lang.scala.ast.ASTTermAnnotate;
import net.sourceforge.pmd.lang.scala.ast.ASTTermApply;
import net.sourceforge.pmd.lang.scala.ast.ASTTermApplyInfix;
import net.sourceforge.pmd.lang.scala.ast.ASTTermApplyType;
import net.sourceforge.pmd.lang.scala.ast.ASTTermApplyUnary;
import net.sourceforge.pmd.lang.scala.ast.ASTTermAscribe;
import net.sourceforge.pmd.lang.scala.ast.ASTTermAssign;
import net.sourceforge.pmd.lang.scala.ast.ASTTermBlock;
import net.sourceforge.pmd.lang.scala.ast.ASTTermDo;
import net.sourceforge.pmd.lang.scala.ast.ASTTermEta;
import net.sourceforge.pmd.lang.scala.ast.ASTTermFor;
import net.sourceforge.pmd.lang.scala.ast.ASTTermForYield;
import net.sourceforge.pmd.lang.scala.ast.ASTTermFunction;
import net.sourceforge.pmd.lang.scala.ast.ASTTermIf;
import net.sourceforge.pmd.lang.scala.ast.ASTTermInterpolate;
import net.sourceforge.pmd.lang.scala.ast.ASTTermMatch;
import net.sourceforge.pmd.lang.scala.ast.ASTTermName;
import net.sourceforge.pmd.lang.scala.ast.ASTTermNew;
import net.sourceforge.pmd.lang.scala.ast.ASTTermNewAnonymous;
import net.sourceforge.pmd.lang.scala.ast.ASTTermParam;
import net.sourceforge.pmd.lang.scala.ast.ASTTermPartialFunction;
import net.sourceforge.pmd.lang.scala.ast.ASTTermPlaceholder;
import net.sourceforge.pmd.lang.scala.ast.ASTTermRepeated;
import net.sourceforge.pmd.lang.scala.ast.ASTTermReturn;
import net.sourceforge.pmd.lang.scala.ast.ASTTermSelect;
import net.sourceforge.pmd.lang.scala.ast.ASTTermSuper;
import net.sourceforge.pmd.lang.scala.ast.ASTTermThis;
import net.sourceforge.pmd.lang.scala.ast.ASTTermThrow;
import net.sourceforge.pmd.lang.scala.ast.ASTTermTry;
import net.sourceforge.pmd.lang.scala.ast.ASTTermTryWithHandler;
import net.sourceforge.pmd.lang.scala.ast.ASTTermTuple;
import net.sourceforge.pmd.lang.scala.ast.ASTTermWhile;
import net.sourceforge.pmd.lang.scala.ast.ASTTermXml;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeAnd;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeAnnotate;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeApply;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeApplyInfix;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeBounds;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeByName;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeExistential;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeFunction;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeImplicitFunction;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeLambda;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeMethod;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeName;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeOr;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeParam;
import net.sourceforge.pmd.lang.scala.ast.ASTTypePlaceholder;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeProject;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeRefine;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeRepeated;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeSelect;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeSingleton;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeTuple;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeVar;
import net.sourceforge.pmd.lang.scala.ast.ASTTypeWith;
import net.sourceforge.pmd.lang.scala.ast.ScalaNode;
import net.sourceforge.pmd.lang.scala.ast.ScalaParserVisitor;

import scala.meta.Case;
import scala.meta.Ctor;
import scala.meta.Decl;
import scala.meta.Defn;
import scala.meta.Enumerator;
import scala.meta.Import;
import scala.meta.Importee;
import scala.meta.Importer;
import scala.meta.Init;
import scala.meta.Lit;
import scala.meta.Mod;
import scala.meta.Name;
import scala.meta.Pat;
import scala.meta.Pkg;
import scala.meta.Self;
import scala.meta.Source;
import scala.meta.Template;
import scala.meta.Term;
import scala.meta.Tree.Quasi;
import scala.meta.Type;

/**
 * The default base implementation of a PMD Rule for Scala. Uses the Visitor
 * Pattern to traverse the AST.
 */
public class ScalaRule extends AbstractRule implements ScalaParserVisitor<RuleContext, RuleContext> {

    /**
     * Create a new Scala Rule.
     */
    public ScalaRule() {
        super.setLanguage(LanguageRegistry.getLanguage(ScalaLanguageModule.NAME));
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        for (Node node : nodes) {
            if (node instanceof ASTSource) {
                visit((ASTSource) node, ctx);
            }
        }
    }

    @Override
    public RuleContext visit(final ScalaNode<?> node, final RuleContext data) {
        for (ScalaNode<?> child : node.children()) {
            child.accept(this, data);
        }
        return data;
    }

    @Override
    public RuleContext visit(final ASTSource node, final RuleContext data) {
        return visit((ScalaNode<Source>) node, data);
    }

    @Override
    public RuleContext visit(final ASTCase node, final RuleContext data) {
        return visit((ScalaNode<Case>) node, data);
    }

    @Override
    public RuleContext visit(final ASTCtorPrimary node, final RuleContext data) {
        return visit((ScalaNode<Ctor.Primary>) node, data);
    }

    @Override
    public RuleContext visit(final ASTCtorSecondary node, final RuleContext data) {
        return visit((ScalaNode<Ctor.Secondary>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDeclDef node, final RuleContext data) {
        return visit((ScalaNode<Decl.Def>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDeclType node, final RuleContext data) {
        return visit((ScalaNode<Decl.Type>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDeclVal node, final RuleContext data) {
        return visit((ScalaNode<Decl.Val>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDeclVar node, final RuleContext data) {
        return visit((ScalaNode<Decl.Var>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnClass node, final RuleContext data) {
        return visit((ScalaNode<Defn.Class>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnDef node, final RuleContext data) {
        return visit((ScalaNode<Defn.Def>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnMacro node, final RuleContext data) {
        return visit((ScalaNode<Defn.Macro>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnObject node, final RuleContext data) {
        return visit((ScalaNode<Defn.Object>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnTrait node, final RuleContext data) {
        return visit((ScalaNode<Defn.Trait>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnType node, final RuleContext data) {
        return visit((ScalaNode<Defn.Type>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnVal node, final RuleContext data) {
        return visit((ScalaNode<Defn.Val>) node, data);
    }

    @Override
    public RuleContext visit(final ASTDefnVar node, final RuleContext data) {
        return visit((ScalaNode<Defn.Var>) node, data);
    }

    @Override
    public RuleContext visit(final ASTEnumeratorGenerator node, final RuleContext data) {
        return visit((ScalaNode<Enumerator.Generator>) node, data);
    }

    @Override
    public RuleContext visit(final ASTEnumeratorGuard node, final RuleContext data) {
        return visit((ScalaNode<Enumerator.Guard>) node, data);
    }

    @Override
    public RuleContext visit(final ASTEnumeratorVal node, final RuleContext data) {
        return visit((ScalaNode<Enumerator.Val>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImport node, final RuleContext data) {
        return visit((ScalaNode<Import>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImporteeName node, final RuleContext data) {
        return visit((ScalaNode<Importee.Name>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImporteeRename node, final RuleContext data) {
        return visit((ScalaNode<Importee.Rename>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImporteeUnimport node, final RuleContext data) {
        return visit((ScalaNode<Importee.Unimport>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImporteeWildcard node, final RuleContext data) {
        return visit((ScalaNode<Importee.Wildcard>) node, data);
    }

    @Override
    public RuleContext visit(final ASTImporter node, final RuleContext data) {
        return visit((ScalaNode<Importer>) node, data);
    }

    @Override
    public RuleContext visit(final ASTInit node, final RuleContext data) {
        return visit((ScalaNode<Init>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitBoolean node, final RuleContext data) {
        return visit((ScalaNode<Lit.Boolean>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitByte node, final RuleContext data) {
        return visit((ScalaNode<Lit.Byte>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitChar node, final RuleContext data) {
        return visit((ScalaNode<Lit.Char>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitDouble node, final RuleContext data) {
        return visit((ScalaNode<Lit.Double>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitFloat node, final RuleContext data) {
        return visit((ScalaNode<Lit.Float>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitInt node, final RuleContext data) {
        return visit((ScalaNode<Lit.Int>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitLong node, final RuleContext data) {
        return visit((ScalaNode<Lit.Long>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitNull node, final RuleContext data) {
        return visit((ScalaNode<Lit.Null>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitShort node, final RuleContext data) {
        return visit((ScalaNode<Lit.Short>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitString node, final RuleContext data) {
        return visit((ScalaNode<Lit.String>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitSymbol node, final RuleContext data) {
        return visit((ScalaNode<Lit.Symbol>) node, data);
    }

    @Override
    public RuleContext visit(final ASTLitUnit node, final RuleContext data) {
        return visit((ScalaNode<Lit.Unit>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModAbstract node, final RuleContext data) {
        return visit((ScalaNode<Mod.Abstract>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModAnnot node, final RuleContext data) {
        return visit((ScalaNode<Mod.Annot>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModCase node, final RuleContext data) {
        return visit((ScalaNode<Mod.Case>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModContravariant node, final RuleContext data) {
        return visit((ScalaNode<Mod.Contravariant>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModCovariant node, final RuleContext data) {
        return visit((ScalaNode<Mod.Covariant>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModFinal node, final RuleContext data) {
        return visit((ScalaNode<Mod.Final>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModImplicit node, final RuleContext data) {
        return visit((ScalaNode<Mod.Implicit>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModInline node, final RuleContext data) {
        return visit((ScalaNode<Mod.Inline>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModLazy node, final RuleContext data) {
        return visit((ScalaNode<Mod.Lazy>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModOverride node, final RuleContext data) {
        return visit((ScalaNode<Mod.Override>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModPrivate node, final RuleContext data) {
        return visit((ScalaNode<Mod.Private>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModProtected node, final RuleContext data) {
        return visit((ScalaNode<Mod.Protected>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModSealed node, final RuleContext data) {
        return visit((ScalaNode<Mod.Sealed>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModValParam node, final RuleContext data) {
        return visit((ScalaNode<Mod.ValParam>) node, data);
    }

    @Override
    public RuleContext visit(final ASTModVarParam node, final RuleContext data) {
        return visit((ScalaNode<Mod.VarParam>) node, data);
    }

    @Override
    public RuleContext visit(final ASTNameAnonymous node, final RuleContext data) {
        return visit((ScalaNode<Name.Anonymous>) node, data);
    }

    @Override
    public RuleContext visit(final ASTNameIndeterminate node, final RuleContext data) {
        return visit((ScalaNode<Name.Indeterminate>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatAlternative node, final RuleContext data) {
        return visit((ScalaNode<Pat.Alternative>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatBind node, final RuleContext data) {
        return visit((ScalaNode<Pat.Bind>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatExtract node, final RuleContext data) {
        return visit((ScalaNode<Pat.Extract>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatExtractInfix node, final RuleContext data) {
        return visit((ScalaNode<Pat.ExtractInfix>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatInterpolate node, final RuleContext data) {
        return visit((ScalaNode<Pat.Interpolate>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatSeqWildcard node, final RuleContext data) {
        return visit((ScalaNode<Pat.SeqWildcard>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatTuple node, final RuleContext data) {
        return visit((ScalaNode<Pat.Tuple>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatTyped node, final RuleContext data) {
        return visit((ScalaNode<Pat.Typed>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatVar node, final RuleContext data) {
        return visit((ScalaNode<Pat.Var>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatWildcard node, final RuleContext data) {
        return visit((ScalaNode<Pat.Wildcard>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPatXml node, final RuleContext data) {
        return visit((ScalaNode<Pat.Xml>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPkg node, final RuleContext data) {
        return visit((ScalaNode<Pkg>) node, data);
    }

    @Override
    public RuleContext visit(final ASTPkgObject node, final RuleContext data) {
        return visit((ScalaNode<Pkg.Object>) node, data);
    }

    @Override
    public RuleContext visit(final ASTQuasi node, final RuleContext data) {
        return visit((ScalaNode<Quasi>) node, data);
    }

    @Override
    public RuleContext visit(final ASTSelf node, final RuleContext data) {
        return visit((ScalaNode<Self>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTemplate node, final RuleContext data) {
        return visit((ScalaNode<Template>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermAnnotate node, final RuleContext data) {
        return visit((ScalaNode<Term.Annotate>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermApply node, final RuleContext data) {
        return visit((ScalaNode<Term.Apply>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermApplyInfix node, final RuleContext data) {
        return visit((ScalaNode<Term.ApplyInfix>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermApplyType node, final RuleContext data) {
        return visit((ScalaNode<Term.ApplyType>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermApplyUnary node, final RuleContext data) {
        return visit((ScalaNode<Term.ApplyUnary>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermAscribe node, final RuleContext data) {
        return visit((ScalaNode<Term.Ascribe>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermAssign node, final RuleContext data) {
        return visit((ScalaNode<Term.Assign>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermBlock node, final RuleContext data) {
        return visit((ScalaNode<Term.Block>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermDo node, final RuleContext data) {
        return visit((ScalaNode<Term.Do>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermEta node, final RuleContext data) {
        return visit((ScalaNode<Term.Eta>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermFor node, final RuleContext data) {
        return visit((ScalaNode<Term.For>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermForYield node, final RuleContext data) {
        return visit((ScalaNode<Term.ForYield>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermFunction node, final RuleContext data) {
        return visit((ScalaNode<Term.Function>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermIf node, final RuleContext data) {
        return visit((ScalaNode<Term.If>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermInterpolate node, final RuleContext data) {
        return visit((ScalaNode<Term.Interpolate>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermMatch node, final RuleContext data) {
        return visit((ScalaNode<Term.Match>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermName node, final RuleContext data) {
        return visit((ScalaNode<Term.Name>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermNewAnonymous node, final RuleContext data) {
        return visit((ScalaNode<Term.NewAnonymous>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermNew node, final RuleContext data) {
        return visit((ScalaNode<Term.New>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermParam node, final RuleContext data) {
        return visit((ScalaNode<Term.Param>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermPartialFunction node, final RuleContext data) {
        return visit((ScalaNode<Term.PartialFunction>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermPlaceholder node, final RuleContext data) {
        return visit((ScalaNode<Term.Placeholder>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermRepeated node, final RuleContext data) {
        return visit((ScalaNode<Term.Repeated>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermReturn node, final RuleContext data) {
        return visit((ScalaNode<Term.Return>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermSelect node, final RuleContext data) {
        return visit((ScalaNode<Term.Select>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermSuper node, final RuleContext data) {
        return visit((ScalaNode<Term.Super>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermThis node, final RuleContext data) {
        return visit((ScalaNode<Term.This>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermThrow node, final RuleContext data) {
        return visit((ScalaNode<Term.Throw>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermTry node, final RuleContext data) {
        return visit((ScalaNode<Term.Try>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermTryWithHandler node, final RuleContext data) {
        return visit((ScalaNode<Term.TryWithHandler>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermTuple node, final RuleContext data) {
        return visit((ScalaNode<Term.Tuple>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermWhile node, final RuleContext data) {
        return visit((ScalaNode<Term.While>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTermXml node, final RuleContext data) {
        return visit((ScalaNode<Term.Xml>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeAnd node, final RuleContext data) {
        return visit((ScalaNode<Type.And>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeAnnotate node, final RuleContext data) {
        return visit((ScalaNode<Type.Annotate>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeApply node, final RuleContext data) {
        return visit((ScalaNode<Type.Apply>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeApplyInfix node, final RuleContext data) {
        return visit((ScalaNode<Type.ApplyInfix>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeBounds node, final RuleContext data) {
        return visit((ScalaNode<Type.Bounds>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeByName node, final RuleContext data) {
        return visit((ScalaNode<Type.ByName>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeExistential node, final RuleContext data) {
        return visit((ScalaNode<Type.Existential>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeFunction node, final RuleContext data) {
        return visit((ScalaNode<Type.Function>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeImplicitFunction node, final RuleContext data) {
        return visit((ScalaNode<Type.ImplicitFunction>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeLambda node, final RuleContext data) {
        return visit((ScalaNode<Type.Lambda>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeMethod node, final RuleContext data) {
        return visit((ScalaNode<Type.Method>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeName node, final RuleContext data) {
        return visit((ScalaNode<Type.Name>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeOr node, final RuleContext data) {
        return visit((ScalaNode<Type.Or>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeParam node, final RuleContext data) {
        return visit((ScalaNode<Type.Param>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypePlaceholder node, final RuleContext data) {
        return visit((ScalaNode<Type.Placeholder>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeProject node, final RuleContext data) {
        return visit((ScalaNode<Type.Project>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeRefine node, final RuleContext data) {
        return visit((ScalaNode<Type.Refine>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeRepeated node, final RuleContext data) {
        return visit((ScalaNode<Type.Repeated>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeSelect node, final RuleContext data) {
        return visit((ScalaNode<Type.Select>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeSingleton node, final RuleContext data) {
        return visit((ScalaNode<Type.Singleton>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeTuple node, final RuleContext data) {
        return visit((ScalaNode<Type.Tuple>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeVar node, final RuleContext data) {
        return visit((ScalaNode<Type.Var>) node, data);
    }

    @Override
    public RuleContext visit(final ASTTypeWith node, final RuleContext data) {
        return visit((ScalaNode<Type.With>) node, data);
    }
}
