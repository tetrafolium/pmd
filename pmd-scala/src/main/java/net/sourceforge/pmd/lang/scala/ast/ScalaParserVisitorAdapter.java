/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

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
 * An Adapter for the Scala Parser that implements the Visitor Pattern.
 *
 * @param <D>
 *            The type of the data input
 * @param <R>
 *            The type of the returned data
 */
public class ScalaParserVisitorAdapter<D, R> implements ScalaParserVisitor<D, R> {

    /** Initial value when combining values returned by children. */
    protected R zero() {
        return null;
    }

    /** Merge two values of type R, used to combine values returned by children. */
    protected R combine(final R acc, final R r) {
        return r;
    }

    @Override
    public R visit(final ScalaNode<?> node, final D data) {
        R returnValue = zero();
        for (ScalaNode<?> child : node.children()) {
            returnValue = combine(returnValue, child.accept(this, data));
        }
        return returnValue;
    }

    @Override
    public R visit(final ASTSource node, final D data) {
        return visit((ScalaNode<Source>) node, data);
    }

    @Override
    public R visit(final ASTCase node, final D data) {
        return visit((ScalaNode<Case>) node, data);
    }

    @Override
    public R visit(final ASTCtorPrimary node, final D data) {
        return visit((ScalaNode<Ctor.Primary>) node, data);
    }

    @Override
    public R visit(final ASTCtorSecondary node, final D data) {
        return visit((ScalaNode<Ctor.Secondary>) node, data);
    }

    @Override
    public R visit(final ASTDeclDef node, final D data) {
        return visit((ScalaNode<Decl.Def>) node, data);
    }

    @Override
    public R visit(final ASTDeclType node, final D data) {
        return visit((ScalaNode<Decl.Type>) node, data);
    }

    @Override
    public R visit(final ASTDeclVal node, final D data) {
        return visit((ScalaNode<Decl.Val>) node, data);
    }

    @Override
    public R visit(final ASTDeclVar node, final D data) {
        return visit((ScalaNode<Decl.Var>) node, data);
    }

    @Override
    public R visit(final ASTDefnClass node, final D data) {
        return visit((ScalaNode<Defn.Class>) node, data);
    }

    @Override
    public R visit(final ASTDefnDef node, final D data) {
        return visit((ScalaNode<Defn.Def>) node, data);
    }

    @Override
    public R visit(final ASTDefnMacro node, final D data) {
        return visit((ScalaNode<Defn.Macro>) node, data);
    }

    @Override
    public R visit(final ASTDefnObject node, final D data) {
        return visit((ScalaNode<Defn.Object>) node, data);
    }

    @Override
    public R visit(final ASTDefnTrait node, final D data) {
        return visit((ScalaNode<Defn.Trait>) node, data);
    }

    @Override
    public R visit(final ASTDefnType node, final D data) {
        return visit((ScalaNode<Defn.Type>) node, data);
    }

    @Override
    public R visit(final ASTDefnVal node, final D data) {
        return visit((ScalaNode<Defn.Val>) node, data);
    }

    @Override
    public R visit(final ASTDefnVar node, final D data) {
        return visit((ScalaNode<Defn.Var>) node, data);
    }

    @Override
    public R visit(final ASTEnumeratorGenerator node, final D data) {
        return visit((ScalaNode<Enumerator.Generator>) node, data);
    }

    @Override
    public R visit(final ASTEnumeratorGuard node, final D data) {
        return visit((ScalaNode<Enumerator.Guard>) node, data);
    }

    @Override
    public R visit(final ASTEnumeratorVal node, final D data) {
        return visit((ScalaNode<Enumerator.Val>) node, data);
    }

    @Override
    public R visit(final ASTImport node, final D data) {
        return visit((ScalaNode<Import>) node, data);
    }

    @Override
    public R visit(final ASTImporteeName node, final D data) {
        return visit((ScalaNode<Importee.Name>) node, data);
    }

    @Override
    public R visit(final ASTImporteeRename node, final D data) {
        return visit((ScalaNode<Importee.Rename>) node, data);
    }

    @Override
    public R visit(final ASTImporteeUnimport node, final D data) {
        return visit((ScalaNode<Importee.Unimport>) node, data);
    }

    @Override
    public R visit(final ASTImporteeWildcard node, final D data) {
        return visit((ScalaNode<Importee.Wildcard>) node, data);
    }

    @Override
    public R visit(final ASTImporter node, final D data) {
        return visit((ScalaNode<Importer>) node, data);
    }

    @Override
    public R visit(final ASTInit node, final D data) {
        return visit((ScalaNode<Init>) node, data);
    }

    @Override
    public R visit(final ASTLitBoolean node, final D data) {
        return visit((ScalaNode<Lit.Boolean>) node, data);
    }

    @Override
    public R visit(final ASTLitByte node, final D data) {
        return visit((ScalaNode<Lit.Byte>) node, data);
    }

    @Override
    public R visit(final ASTLitChar node, final D data) {
        return visit((ScalaNode<Lit.Char>) node, data);
    }

    @Override
    public R visit(final ASTLitDouble node, final D data) {
        return visit((ScalaNode<Lit.Double>) node, data);
    }

    @Override
    public R visit(final ASTLitFloat node, final D data) {
        return visit((ScalaNode<Lit.Float>) node, data);
    }

    @Override
    public R visit(final ASTLitInt node, final D data) {
        return visit((ScalaNode<Lit.Int>) node, data);
    }

    @Override
    public R visit(final ASTLitLong node, final D data) {
        return visit((ScalaNode<Lit.Long>) node, data);
    }

    @Override
    public R visit(final ASTLitNull node, final D data) {
        return visit((ScalaNode<Lit.Null>) node, data);
    }

    @Override
    public R visit(final ASTLitShort node, final D data) {
        return visit((ScalaNode<Lit.Short>) node, data);
    }

    @Override
    public R visit(final ASTLitString node, final D data) {
        return visit((ScalaNode<Lit.String>) node, data);
    }

    @Override
    public R visit(final ASTLitSymbol node, final D data) {
        return visit((ScalaNode<Lit.Symbol>) node, data);
    }

    @Override
    public R visit(final ASTLitUnit node, final D data) {
        return visit((ScalaNode<Lit.Unit>) node, data);
    }

    @Override
    public R visit(final ASTModAbstract node, final D data) {
        return visit((ScalaNode<Mod.Abstract>) node, data);
    }

    @Override
    public R visit(final ASTModAnnot node, final D data) {
        return visit((ScalaNode<Mod.Annot>) node, data);
    }

    @Override
    public R visit(final ASTModCase node, final D data) {
        return visit((ScalaNode<Mod.Case>) node, data);
    }

    @Override
    public R visit(final ASTModContravariant node, final D data) {
        return visit((ScalaNode<Mod.Contravariant>) node, data);
    }

    @Override
    public R visit(final ASTModCovariant node, final D data) {
        return visit((ScalaNode<Mod.Covariant>) node, data);
    }

    @Override
    public R visit(final ASTModFinal node, final D data) {
        return visit((ScalaNode<Mod.Final>) node, data);
    }

    @Override
    public R visit(final ASTModImplicit node, final D data) {
        return visit((ScalaNode<Mod.Implicit>) node, data);
    }

    @Override
    public R visit(final ASTModInline node, final D data) {
        return visit((ScalaNode<Mod.Inline>) node, data);
    }

    @Override
    public R visit(final ASTModLazy node, final D data) {
        return visit((ScalaNode<Mod.Lazy>) node, data);
    }

    @Override
    public R visit(final ASTModOverride node, final D data) {
        return visit((ScalaNode<Mod.Override>) node, data);
    }

    @Override
    public R visit(final ASTModPrivate node, final D data) {
        return visit((ScalaNode<Mod.Private>) node, data);
    }

    @Override
    public R visit(final ASTModProtected node, final D data) {
        return visit((ScalaNode<Mod.Protected>) node, data);
    }

    @Override
    public R visit(final ASTModSealed node, final D data) {
        return visit((ScalaNode<Mod.Sealed>) node, data);
    }

    @Override
    public R visit(final ASTModValParam node, final D data) {
        return visit((ScalaNode<Mod.ValParam>) node, data);
    }

    @Override
    public R visit(final ASTModVarParam node, final D data) {
        return visit((ScalaNode<Mod.VarParam>) node, data);
    }

    @Override
    public R visit(final ASTNameAnonymous node, final D data) {
        return visit((ScalaNode<Name.Anonymous>) node, data);
    }

    @Override
    public R visit(final ASTNameIndeterminate node, final D data) {
        return visit((ScalaNode<Name.Indeterminate>) node, data);
    }

    @Override
    public R visit(final ASTPatAlternative node, final D data) {
        return visit((ScalaNode<Pat.Alternative>) node, data);
    }

    @Override
    public R visit(final ASTPatBind node, final D data) {
        return visit((ScalaNode<Pat.Bind>) node, data);
    }

    @Override
    public R visit(final ASTPatExtract node, final D data) {
        return visit((ScalaNode<Pat.Extract>) node, data);
    }

    @Override
    public R visit(final ASTPatExtractInfix node, final D data) {
        return visit((ScalaNode<Pat.ExtractInfix>) node, data);
    }

    @Override
    public R visit(final ASTPatInterpolate node, final D data) {
        return visit((ScalaNode<Pat.Interpolate>) node, data);
    }

    @Override
    public R visit(final ASTPatSeqWildcard node, final D data) {
        return visit((ScalaNode<Pat.SeqWildcard>) node, data);
    }

    @Override
    public R visit(final ASTPatTuple node, final D data) {
        return visit((ScalaNode<Pat.Tuple>) node, data);
    }

    @Override
    public R visit(final ASTPatTyped node, final D data) {
        return visit((ScalaNode<Pat.Typed>) node, data);
    }

    @Override
    public R visit(final ASTPatVar node, final D data) {
        return visit((ScalaNode<Pat.Var>) node, data);
    }

    @Override
    public R visit(final ASTPatWildcard node, final D data) {
        return visit((ScalaNode<Pat.Wildcard>) node, data);
    }

    @Override
    public R visit(final ASTPatXml node, final D data) {
        return visit((ScalaNode<Pat.Xml>) node, data);
    }

    @Override
    public R visit(final ASTPkg node, final D data) {
        return visit((ScalaNode<Pkg>) node, data);
    }

    @Override
    public R visit(final ASTPkgObject node, final D data) {
        return visit((ScalaNode<Pkg.Object>) node, data);
    }

    @Override
    public R visit(final ASTQuasi node, final D data) {
        return visit((ScalaNode<Quasi>) node, data);
    }

    @Override
    public R visit(final ASTSelf node, final D data) {
        return visit((ScalaNode<Self>) node, data);
    }

    @Override
    public R visit(final ASTTemplate node, final D data) {
        return visit((ScalaNode<Template>) node, data);
    }

    @Override
    public R visit(final ASTTermAnnotate node, final D data) {
        return visit((ScalaNode<Term.Annotate>) node, data);
    }

    @Override
    public R visit(final ASTTermApply node, final D data) {
        return visit((ScalaNode<Term.Apply>) node, data);
    }

    @Override
    public R visit(final ASTTermApplyInfix node, final D data) {
        return visit((ScalaNode<Term.ApplyInfix>) node, data);
    }

    @Override
    public R visit(final ASTTermApplyType node, final D data) {
        return visit((ScalaNode<Term.ApplyType>) node, data);
    }

    @Override
    public R visit(final ASTTermApplyUnary node, final D data) {
        return visit((ScalaNode<Term.ApplyUnary>) node, data);
    }

    @Override
    public R visit(final ASTTermAscribe node, final D data) {
        return visit((ScalaNode<Term.Ascribe>) node, data);
    }

    @Override
    public R visit(final ASTTermAssign node, final D data) {
        return visit((ScalaNode<Term.Assign>) node, data);
    }

    @Override
    public R visit(final ASTTermBlock node, final D data) {
        return visit((ScalaNode<Term.Block>) node, data);
    }

    @Override
    public R visit(final ASTTermDo node, final D data) {
        return visit((ScalaNode<Term.Do>) node, data);
    }

    @Override
    public R visit(final ASTTermEta node, final D data) {
        return visit((ScalaNode<Term.Eta>) node, data);
    }

    @Override
    public R visit(final ASTTermFor node, final D data) {
        return visit((ScalaNode<Term.For>) node, data);
    }

    @Override
    public R visit(final ASTTermForYield node, final D data) {
        return visit((ScalaNode<Term.ForYield>) node, data);
    }

    @Override
    public R visit(final ASTTermFunction node, final D data) {
        return visit((ScalaNode<Term.Function>) node, data);
    }

    @Override
    public R visit(final ASTTermIf node, final D data) {
        return visit((ScalaNode<Term.If>) node, data);
    }

    @Override
    public R visit(final ASTTermInterpolate node, final D data) {
        return visit((ScalaNode<Term.Interpolate>) node, data);
    }

    @Override
    public R visit(final ASTTermMatch node, final D data) {
        return visit((ScalaNode<Term.Match>) node, data);
    }

    @Override
    public R visit(final ASTTermName node, final D data) {
        return visit((ScalaNode<Term.Name>) node, data);
    }

    @Override
    public R visit(final ASTTermNewAnonymous node, final D data) {
        return visit((ScalaNode<Term.NewAnonymous>) node, data);
    }

    @Override
    public R visit(final ASTTermNew node, final D data) {
        return visit((ScalaNode<Term.New>) node, data);
    }

    @Override
    public R visit(final ASTTermParam node, final D data) {
        return visit((ScalaNode<Term.Param>) node, data);
    }

    @Override
    public R visit(final ASTTermPartialFunction node, final D data) {
        return visit((ScalaNode<Term.PartialFunction>) node, data);
    }

    @Override
    public R visit(final ASTTermPlaceholder node, final D data) {
        return visit((ScalaNode<Term.Placeholder>) node, data);
    }

    @Override
    public R visit(final ASTTermRepeated node, final D data) {
        return visit((ScalaNode<Term.Repeated>) node, data);
    }

    @Override
    public R visit(final ASTTermReturn node, final D data) {
        return visit((ScalaNode<Term.Return>) node, data);
    }

    @Override
    public R visit(final ASTTermSelect node, final D data) {
        return visit((ScalaNode<Term.Select>) node, data);
    }

    @Override
    public R visit(final ASTTermSuper node, final D data) {
        return visit((ScalaNode<Term.Super>) node, data);
    }

    @Override
    public R visit(final ASTTermThis node, final D data) {
        return visit((ScalaNode<Term.This>) node, data);
    }

    @Override
    public R visit(final ASTTermThrow node, final D data) {
        return visit((ScalaNode<Term.Throw>) node, data);
    }

    @Override
    public R visit(final ASTTermTry node, final D data) {
        return visit((ScalaNode<Term.Try>) node, data);
    }

    @Override
    public R visit(final ASTTermTryWithHandler node, final D data) {
        return visit((ScalaNode<Term.TryWithHandler>) node, data);
    }

    @Override
    public R visit(final ASTTermTuple node, final D data) {
        return visit((ScalaNode<Term.Tuple>) node, data);
    }

    @Override
    public R visit(final ASTTermWhile node, final D data) {
        return visit((ScalaNode<Term.While>) node, data);
    }

    @Override
    public R visit(final ASTTermXml node, final D data) {
        return visit((ScalaNode<Term.Xml>) node, data);
    }

    @Override
    public R visit(final ASTTypeAnd node, final D data) {
        return visit((ScalaNode<Type.And>) node, data);
    }

    @Override
    public R visit(final ASTTypeAnnotate node, final D data) {
        return visit((ScalaNode<Type.Annotate>) node, data);
    }

    @Override
    public R visit(final ASTTypeApply node, final D data) {
        return visit((ScalaNode<Type.Apply>) node, data);
    }

    @Override
    public R visit(final ASTTypeApplyInfix node, final D data) {
        return visit((ScalaNode<Type.ApplyInfix>) node, data);
    }

    @Override
    public R visit(final ASTTypeBounds node, final D data) {
        return visit((ScalaNode<Type.Bounds>) node, data);
    }

    @Override
    public R visit(final ASTTypeByName node, final D data) {
        return visit((ScalaNode<Type.ByName>) node, data);
    }

    @Override
    public R visit(final ASTTypeExistential node, final D data) {
        return visit((ScalaNode<Type.Existential>) node, data);
    }

    @Override
    public R visit(final ASTTypeFunction node, final D data) {
        return visit((ScalaNode<Type.Function>) node, data);
    }

    @Override
    public R visit(final ASTTypeImplicitFunction node, final D data) {
        return visit((ScalaNode<Type.ImplicitFunction>) node, data);
    }

    @Override
    public R visit(final ASTTypeLambda node, final D data) {
        return visit((ScalaNode<Type.Lambda>) node, data);
    }

    @Override
    public R visit(final ASTTypeMethod node, final D data) {
        return visit((ScalaNode<Type.Method>) node, data);
    }

    @Override
    public R visit(final ASTTypeName node, final D data) {
        return visit((ScalaNode<Type.Name>) node, data);
    }

    @Override
    public R visit(final ASTTypeOr node, final D data) {
        return visit((ScalaNode<Type.Or>) node, data);
    }

    @Override
    public R visit(final ASTTypeParam node, final D data) {
        return visit((ScalaNode<Type.Param>) node, data);
    }

    @Override
    public R visit(final ASTTypePlaceholder node, final D data) {
        return visit((ScalaNode<Type.Placeholder>) node, data);
    }

    @Override
    public R visit(final ASTTypeProject node, final D data) {
        return visit((ScalaNode<Type.Project>) node, data);
    }

    @Override
    public R visit(final ASTTypeRefine node, final D data) {
        return visit((ScalaNode<Type.Refine>) node, data);
    }

    @Override
    public R visit(final ASTTypeRepeated node, final D data) {
        return visit((ScalaNode<Type.Repeated>) node, data);
    }

    @Override
    public R visit(final ASTTypeSelect node, final D data) {
        return visit((ScalaNode<Type.Select>) node, data);
    }

    @Override
    public R visit(final ASTTypeSingleton node, final D data) {
        return visit((ScalaNode<Type.Singleton>) node, data);
    }

    @Override
    public R visit(final ASTTypeTuple node, final D data) {
        return visit((ScalaNode<Type.Tuple>) node, data);
    }

    @Override
    public R visit(final ASTTypeVar node, final D data) {
        return visit((ScalaNode<Type.Var>) node, data);
    }

    @Override
    public R visit(final ASTTypeWith node, final D data) {
        return visit((ScalaNode<Type.With>) node, data);
    }

}
