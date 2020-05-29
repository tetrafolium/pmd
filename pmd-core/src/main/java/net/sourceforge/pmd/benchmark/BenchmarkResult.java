/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.benchmark;

@Deprecated
class BenchmarkResult implements Comparable<BenchmarkResult> {

    public final Benchmark type;
    public final String name;
    private long time;
    private long count;

    BenchmarkResult(final Benchmark type, final String name) {
        this.type = type;
        this.name = name;
    }

    BenchmarkResult(final Benchmark type, final long time, final long count) {
        this(type, type.name);
        this.time = time;
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public long getCount() {
        return count;
    }

    public void update(final long time, final long count) {
        this.time += time;
        this.count += count;
    }

    @Override
    public int compareTo(final BenchmarkResult benchmarkResult) {
        int cmp = Integer.compare(type.index, benchmarkResult.type.index);
        if (cmp == 0) {
            cmp = Long.compare(this.time, benchmarkResult.time);
        }
        return cmp;
    }
}
