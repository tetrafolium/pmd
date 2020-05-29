/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.ant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Reference;

import net.sourceforge.pmd.ant.internal.PMDTaskImpl;

public class PMDTask extends Task {

    private Path classpath;
    private Path auxClasspath;
    private final List<Formatter> formatters = new ArrayList<>();
    private final List<FileSet> filesets = new ArrayList<>();
    private boolean failOnError;
    private boolean failOnRuleViolation;
    private boolean shortFilenames;
    private String suppressMarker;
    private String rulesetFiles;
    private boolean noRuleSetCompatibility;
    private String encoding;
    private int threads;
    private int minimumPriority;
    private int maxRuleViolations = 0;
    private String failuresPropertyName;
    private SourceLanguage sourceLanguage;
    private String cacheLocation;
    private boolean noCache;
    private final Collection<RuleSetWrapper> nestedRules = new ArrayList<>();

    @Override
    public void execute() throws BuildException {
        validate();

        ClassLoader oldClassloader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(PMDTask.class.getClassLoader());
        try {
            PMDTaskImpl mirror = new PMDTaskImpl(this);
            mirror.execute();
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassloader);
        }
    }

    private void validate() throws BuildException {
        if (formatters.isEmpty()) {
            Formatter defaultFormatter = new Formatter();
            defaultFormatter.setType("text");
            defaultFormatter.setToConsole(true);
            formatters.add(defaultFormatter);
        } else {
            for (Formatter f : formatters) {
                if (f.isNoOutputSupplied()) {
                    throw new BuildException("toFile or toConsole needs to be specified in Formatter");
                }
            }
        }

        if (rulesetFiles == null) {
            if (nestedRules.isEmpty()) {
                throw new BuildException("No rulesets specified");
            }
            rulesetFiles = getNestedRuleSetFiles();
        }
    }

    private String getNestedRuleSetFiles() {
        final StringBuilder sb = new StringBuilder();
        for (Iterator<RuleSetWrapper> it = nestedRules.iterator(); it.hasNext();) {
            RuleSetWrapper rs = it.next();
            sb.append(rs.getFile());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public void setShortFilenames(final boolean reportShortNames) {
        this.shortFilenames = reportShortNames;
    }

    public void setSuppressMarker(final String suppressMarker) {
        this.suppressMarker = suppressMarker;
    }

    public void setFailOnError(final boolean fail) {
        this.failOnError = fail;
    }

    public void setFailOnRuleViolation(final boolean fail) {
        this.failOnRuleViolation = fail;
    }

    public void setMaxRuleViolations(final int max) {
        if (max >= 0) {
            this.maxRuleViolations = max;
            this.failOnRuleViolation = true;
        }
    }

    public void setRuleSetFiles(final String ruleSets) {
        this.rulesetFiles = ruleSets;
    }

    public void setEncoding(final String sourceEncoding) {
        this.encoding = sourceEncoding;
    }

    public void setThreads(final int threads) {
        this.threads = threads;
    }

    public void setFailuresPropertyName(final String failuresPropertyName) {
        this.failuresPropertyName = failuresPropertyName;
    }

    public void setMinimumPriority(final int minPriority) {
        this.minimumPriority = minPriority;
    }

    public void addFileset(final FileSet set) {
        filesets.add(set);
    }

    public void addFormatter(final Formatter f) {
        formatters.add(f);
    }

    public void addConfiguredSourceLanguage(final SourceLanguage version) {
        this.sourceLanguage = version;
    }

    public void setClasspath(final Path classpath) {
        this.classpath = classpath;
    }

    public Path getClasspath() {
        return classpath;
    }

    public Path createClasspath() {
        if (classpath == null) {
            classpath = new Path(getProject());
        }
        return classpath.createPath();
    }

    public void setClasspathRef(final Reference r) {
        createClasspath().setRefid(r);
    }

    public void setAuxClasspath(final Path auxClasspath) {
        this.auxClasspath = auxClasspath;
    }

    public Path getAuxClasspath() {
        return auxClasspath;
    }

    public Path createAuxClasspath() {
        if (auxClasspath == null) {
            auxClasspath = new Path(getProject());
        }
        return auxClasspath.createPath();
    }

    public void setAuxClasspathRef(final Reference r) {
        createAuxClasspath().setRefid(r);
    }

    public void addRuleset(final RuleSetWrapper r) {
        nestedRules.add(r);
    }

    public List<Formatter> getFormatters() {
        return formatters;
    }

    public List<FileSet> getFilesets() {
        return filesets;
    }

    public boolean isFailOnError() {
        return failOnError;
    }

    public boolean isFailOnRuleViolation() {
        return failOnRuleViolation;
    }

    public boolean isShortFilenames() {
        return shortFilenames;
    }

    public String getSuppressMarker() {
        return suppressMarker;
    }

    public String getRulesetFiles() {
        return rulesetFiles;
    }

    public String getEncoding() {
        return encoding;
    }

    public int getThreads() {
        return threads;
    }

    public int getMinimumPriority() {
        return minimumPriority;
    }

    public int getMaxRuleViolations() {
        return maxRuleViolations;
    }

    public String getFailuresPropertyName() {
        return failuresPropertyName;
    }

    public SourceLanguage getSourceLanguage() {
        return sourceLanguage;
    }

    public Collection<RuleSetWrapper> getNestedRules() {
        return nestedRules;
    }

    public boolean isNoRuleSetCompatibility() {
        return noRuleSetCompatibility;
    }

    public void setNoRuleSetCompatibility(final boolean noRuleSetCompatibility) {
        this.noRuleSetCompatibility = noRuleSetCompatibility;
    }

    public String getCacheLocation() {
        return cacheLocation;
    }

    public void setCacheLocation(final String cacheLocation) {
        this.cacheLocation = cacheLocation;
    }


    public boolean isNoCache() {
        return noCache;
    }

    public void setNoCache(final boolean noCache) {
        this.noCache = noCache;
    }
}
