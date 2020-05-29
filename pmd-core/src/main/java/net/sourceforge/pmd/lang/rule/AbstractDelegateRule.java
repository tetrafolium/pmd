/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.rule;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RulePriority;
import net.sourceforge.pmd.lang.Language;
import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.properties.MultiValuePropertyDescriptor;
import net.sourceforge.pmd.properties.PropertyDescriptor;
import net.sourceforge.pmd.properties.PropertySource;

/**
 * Base class for Rule implementations which delegate to another Rule instance.
 *
 * @deprecated This is only relevant to {@link RuleReference}, but prevents sharing the implementation
 * of {@link net.sourceforge.pmd.properties.AbstractPropertySource}. Will be removed in 7.0.0
 */
@Deprecated
public abstract class AbstractDelegateRule implements Rule {

    private Rule rule;

    public Rule getRule() {
        return rule;
    }


    /**
     * @deprecated This will be removed in 7.0.0
     * I mark it specially deprecated because it's inherited by rule reference,
     * even though a RuleReference has no business setting its rule after construction
     */
    @Deprecated
    public void setRule(final Rule rule) {
        this.rule = rule;
    }

    @Override
    public Language getLanguage() {
        return rule.getLanguage();
    }

    @Override
    public void setLanguage(final Language language) {
        rule.setLanguage(language);
    }

    @Override
    public LanguageVersion getMinimumLanguageVersion() {
        return rule.getMinimumLanguageVersion();
    }

    @Override
    public void setMinimumLanguageVersion(final LanguageVersion minimumlanguageVersion) {
        rule.setMinimumLanguageVersion(minimumlanguageVersion);
    }

    @Override
    public LanguageVersion getMaximumLanguageVersion() {
        return rule.getMaximumLanguageVersion();
    }

    @Override
    public void setMaximumLanguageVersion(final LanguageVersion maximumlanguageVersion) {
        rule.setMaximumLanguageVersion(maximumlanguageVersion);
    }

    @Override
    public boolean isDeprecated() {
        return rule.isDeprecated();
    }

    @Override
    public void setDeprecated(final boolean deprecated) {
        rule.setDeprecated(deprecated);
    }

    /**
     * @see PropertySource#dysfunctionReason()
     */
    @Override
    public String dysfunctionReason() {
        return rule.dysfunctionReason();
    }

    @Override
    public Set<PropertyDescriptor<?>> ignoredProperties() {
        return rule.ignoredProperties();
    }

    @Override
    public String getName() {
        return rule.getName();
    }

    @Override
    public void setName(final String name) {
        rule.setName(name);
    }

    @Override
    public String getSince() {
        return rule.getSince();
    }

    @Override
    public void setSince(final String since) {
        rule.setSince(since);
    }

    @Override
    public String getRuleClass() {
        return rule.getRuleClass();
    }

    @Override
    public void setRuleClass(final String ruleClass) {
        rule.setRuleClass(ruleClass);
    }

    @Override
    public String getRuleSetName() {
        return rule.getRuleSetName();
    }

    @Override
    public void setRuleSetName(final String name) {
        rule.setRuleSetName(name);
    }

    @Override
    public String getMessage() {
        return rule.getMessage();
    }

    @Override
    public void setMessage(final String message) {
        rule.setMessage(message);
    }

    @Override
    public String getDescription() {
        return rule.getDescription();
    }

    @Override
    public void setDescription(final String description) {
        rule.setDescription(description);
    }

    @Override
    public List<String> getExamples() {
        return rule.getExamples();
    }

    @Override
    public void addExample(final String example) {
        rule.addExample(example);
    }

    @Override
    public String getExternalInfoUrl() {
        return rule.getExternalInfoUrl();
    }

    @Override
    public void setExternalInfoUrl(final String url) {
        rule.setExternalInfoUrl(url);
    }

    @Override
    public RulePriority getPriority() {
        return rule.getPriority();
    }

    @Override
    public void setPriority(final RulePriority priority) {
        rule.setPriority(priority);
    }

    @Override
    public ParserOptions getParserOptions() {
        return rule.getParserOptions();
    }

    @Override
    public void definePropertyDescriptor(final PropertyDescriptor<?> propertyDescriptor) throws IllegalArgumentException {
        rule.definePropertyDescriptor(propertyDescriptor);
    }

    @Override
    public PropertyDescriptor<?> getPropertyDescriptor(final String name) {
        return rule.getPropertyDescriptor(name);
    }

    @Override
    public List<PropertyDescriptor<?>> getPropertyDescriptors() {
        return rule.getPropertyDescriptors();
    }

    @Override
    public <T> T getProperty(final PropertyDescriptor<T> propertyDescriptor) {
        return rule.getProperty(propertyDescriptor);
    }

    @Override
    public <T> void setProperty(final PropertyDescriptor<T> propertyDescriptor, final T value) {
        rule.setProperty(propertyDescriptor, value);
    }


    @Override
    public <V> void setProperty(final MultiValuePropertyDescriptor<V> propertyDescriptor, final V... values) {
        rule.setProperty(propertyDescriptor, values);
    }

    @Override
    public boolean isPropertyOverridden(final PropertyDescriptor<?> propertyDescriptor) {
        return rule.isPropertyOverridden(propertyDescriptor);
    }

    @Override
    public Map<PropertyDescriptor<?>, Object> getPropertiesByPropertyDescriptor() {
        return rule.getPropertiesByPropertyDescriptor();
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public void setUsesDFA() {
        rule.setDfa(true);
    }

    @Override
    public void setDfa(final boolean isDfa) {
        rule.setDfa(isDfa);
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public boolean usesDFA() {
        return rule.isDfa();
    }

    @Override
    public boolean isDfa() {
        return rule.isDfa();
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public void setUsesTypeResolution() {
        rule.setTypeResolution(true);
    }

    @Override
    public void setTypeResolution(final boolean usingTypeResolution) {
        rule.setTypeResolution(usingTypeResolution);
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public boolean usesTypeResolution() {
        return rule.isTypeResolution();
    }

    @Override
    public boolean isTypeResolution() {
        return rule.isTypeResolution();
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public void setUsesMultifile() {
        rule.setMultifile(true);
    }

    @Override
    public void setMultifile(final boolean multifile) {
        rule.setMultifile(multifile);
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public boolean usesMultifile() {
        return rule.isMultifile();
    }

    @Override
    public boolean isMultifile() {
        return rule.isMultifile();
    }

    @Override
    @Deprecated // To be removed in PMD 7.0.0
    public boolean usesRuleChain() {
        return rule.isRuleChain();
    }

    @Override
    public boolean isRuleChain() {
        return rule.isRuleChain();
    }

    @Override
    public List<String> getRuleChainVisits() {
        return rule.getRuleChainVisits();
    }

    @Override
    public void addRuleChainVisit(final Class<? extends Node> nodeClass) {
        rule.addRuleChainVisit(nodeClass);
    }

    @Override
    public void addRuleChainVisit(final String astNodeName) {
        rule.addRuleChainVisit(astNodeName);
    }

    @Override
    public void start(final RuleContext ctx) {
        rule.start(ctx);
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        rule.apply(nodes, ctx);
    }

    @Override
    public void end(final RuleContext ctx) {
        rule.end(ctx);
    }

    /**
     * @see Rule#hasDescriptor(PropertyDescriptor)
     */
    @Override
    public boolean hasDescriptor(final PropertyDescriptor<?> descriptor) {
        return rule.hasDescriptor(descriptor);
    }
}
