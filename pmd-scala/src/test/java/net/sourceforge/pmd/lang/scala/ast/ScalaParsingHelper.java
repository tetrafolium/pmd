/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import java.io.File;
import java.io.StringReader;

import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDException;
import net.sourceforge.pmd.Report;
import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleSet;
import net.sourceforge.pmd.RuleSetFactory;
import net.sourceforge.pmd.RuleSets;
import net.sourceforge.pmd.lang.ast.test.BaseParsingHelper;
import net.sourceforge.pmd.lang.scala.ScalaLanguageModule;

public final class ScalaParsingHelper extends BaseParsingHelper<ScalaParsingHelper, ASTSource> {

    public static final ScalaParsingHelper DEFAULT = new ScalaParsingHelper(Params.getDefaultProcess());

    private ScalaParsingHelper(final Params params) {
        super(ScalaLanguageModule.NAME, ASTSource.class, params);
    }

    @Override
    protected ScalaParsingHelper clone(final Params params) {
        return new ScalaParsingHelper(params);
    }


    public Report getReportForTestString(final Rule rule, final String testSourceCode) {
        PMD p = new PMD();
        RuleContext ctx = new RuleContext();
        Report report = new Report();
        ctx.setReport(report);
        ctx.setSourceCodeFile(new File("test.scala"));
        RuleSet rules = new RuleSetFactory().createSingleRuleRuleSet(rule);
        try {
            p.getSourceCodeProcessor().processSourceCode(new StringReader(testSourceCode), new RuleSets(rules), ctx);
        } catch (PMDException e) {
            throw new AssertionError(e);
        }
        return report;
    }

    public Report getReportForResource(final Rule rule, final String resourcePath) {
        return getReportForTestString(rule, readResource(resourcePath));
    }
}
