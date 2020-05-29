/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.xpath;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;
import org.jaxen.Context;
import org.jaxen.Function;
import org.jaxen.FunctionCallException;
import org.jaxen.SimpleFunctionContext;
import org.jaxen.XPathFunctionContext;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTAnyTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.MethodLikeNode;
import net.sourceforge.pmd.lang.java.metrics.api.JavaClassMetricKey;
import net.sourceforge.pmd.lang.java.metrics.api.JavaOperationMetricKey;
import net.sourceforge.pmd.lang.metrics.MetricKey;
import net.sourceforge.pmd.lang.metrics.MetricsUtil;


/**
 * Implements the {@code metric()} XPath function. Takes the
 * string name of a metric and the context node and returns
 * the result if the metric can be computed, otherwise returns
 * {@link Double#NaN}.
 *
 * @author Clément Fournier
 * @since 6.0.0
 */
@InternalApi
@Deprecated
public class MetricFunction implements Function {


    private static final Map<String, JavaClassMetricKey> CLASS_METRIC_KEY_MAP = EnumUtils.getEnumMap(JavaClassMetricKey.class);
    private static final Map<String, JavaOperationMetricKey> OPERATION_METRIC_KEY_MAP = EnumUtils.getEnumMap(JavaOperationMetricKey.class);


    @Override
    public Object call(final Context context, final List args) throws FunctionCallException {

        if (args.isEmpty()) {
            throw new IllegalArgumentException(badMetricKeyArgMessage());
        }

        if (!(args.get(0) instanceof String)) {
            throw new IllegalArgumentException(badMetricKeyArgMessage());
        }

        String metricKeyName = (String) args.get(0);
        Node n = (Node) context.getNodeSet().get(0);

        return getMetric(n, metricKeyName);
    }


    public static String badOperationMetricKeyMessage() {
        return "This is not the name of an operation metric";
    }


    public static String badClassMetricKeyMessage() {
        return "This is not the name of a class metric";
    }


    public static String genericBadNodeMessage() {
        return "Incorrect node type: the 'metric' function cannot be applied";
    }


    public static String badMetricKeyArgMessage() {
        return "The 'metric' function expects the name of a metric key";
    }


    public static double getMetric(final Node n, final String metricKeyName) {
        if (n instanceof ASTAnyTypeDeclaration) {
            return computeMetric(getClassMetricKey(metricKeyName), (ASTAnyTypeDeclaration) n);
        } else if (n instanceof MethodLikeNode) {
            return computeMetric(getOperationMetricKey(metricKeyName), (MethodLikeNode) n);
        } else {
            throw new IllegalStateException(genericBadNodeMessage());
        }
    }

    private static <T extends Node> double computeMetric(final MetricKey<T> metricKey, final T n) {
        return metricKey.supports(n) ? MetricsUtil.computeMetric(metricKey, n) : Double.NaN;
    }


    private static JavaClassMetricKey getClassMetricKey(final String s) {
        String constantName = s.toUpperCase(Locale.ROOT);
        if (!CLASS_METRIC_KEY_MAP.containsKey(constantName)) {
            throw new IllegalArgumentException(badClassMetricKeyMessage());
        }
        return CLASS_METRIC_KEY_MAP.get(constantName);
    }


    private static JavaOperationMetricKey getOperationMetricKey(final String s) {
        String constantName = s.toUpperCase(Locale.ROOT);
        if (!OPERATION_METRIC_KEY_MAP.containsKey(constantName)) {
            throw new IllegalArgumentException(badOperationMetricKeyMessage());
        }
        return OPERATION_METRIC_KEY_MAP.get(constantName);
    }


    public static void registerSelfInSimpleContext() {
        ((SimpleFunctionContext) XPathFunctionContext.getInstance()).registerFunction(null,
                                                                                      "metric",
                                                                                      new MetricFunction());
    }
}
