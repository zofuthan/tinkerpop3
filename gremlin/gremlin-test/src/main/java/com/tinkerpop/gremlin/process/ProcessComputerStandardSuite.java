package com.tinkerpop.gremlin.process;

import com.tinkerpop.gremlin.AbstractGremlinSuite;
import com.tinkerpop.gremlin.process.graph.filter.FilterTest;
import com.tinkerpop.gremlin.process.graph.filter.HasTest;
import com.tinkerpop.gremlin.process.graph.filter.IntervalTest;
import com.tinkerpop.gremlin.process.graph.filter.RangeTest;
import com.tinkerpop.gremlin.process.graph.map.BackTest;
import com.tinkerpop.gremlin.process.graph.map.JumpTest;
import com.tinkerpop.gremlin.process.graph.map.PathTest;
import com.tinkerpop.gremlin.process.graph.map.SelectTest;
import com.tinkerpop.gremlin.process.graph.map.TraversalTest;
import com.tinkerpop.gremlin.process.graph.sideEffect.TreeTest;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * The ProcessComputerStandardSuite is a custom JUnit test runner that executes the Gremlin Test Suite over a Graph
 * implementation.  This specialized test suite and runner is for use by Blueprints implementers to test their
 * Graph implementations.  The StructureStandardSuite ensures consistency and validity of the implementations that they
 * test.
 * <p/>
 * To use the ProcessComputerStandardSuite define a class in a test module.  Simple naming would expect the name of the
 * implementation followed by "ProcessComputerStandardSuite".  This class should be annotated as follows (note that the "Suite"
 * implements ProcessComputerStandardSuite.GraphProvider as a convenience only...it could be implemented in a separate class file):
 * <code>
 *
 * @author Stephen Mallette (http://stephen.genoprime.com)
 * @RunWith(ProcessComputerStandardSuite.class)
 * @BlueprintsSuite.GraphProviderClass(MsAccessBlueprintsTest.class) public class MsAccessBlueprintsTest implements GraphProvider {
 * }
 * </code>
 * Implementing {@link com.tinkerpop.gremlin.GraphProvider} provides a way for the ProcessComputerStandardSuite to
 * instantiate Graph instances from the implementation being tested to inject into tests in the suite.  The
 * ProcessStandardSuite will utilized Features defined in the suite to determine which tests will be executed.
 */
public class ProcessComputerStandardSuite extends AbstractGremlinSuite {

    // todo: all tests are not currently passing. see specific todos in each test

    /**
     * This list of tests in the suite that will be executed.  Gremlin developers should add to this list
     * as needed to enforce tests upon implementations.
     */
    private static final Class<?>[] testsToExecute = new Class<?>[]{
            FilterTest.JavaComputerFilterTest.class,
            HasTest.JavaComputerHasTest.class,
            IntervalTest.JavaComputerIntervalTest.class,
            RangeTest.JavaComputerRangeTest.class,
            BackTest.JavaComputerBackTest.class,
            JumpTest.JavaComputerJumpTest.class,
            PathTest.JavaComputerPathTest.class,
            SelectTest.JavaComputerSelectTest.class,
            TraversalTest.JavaComputerTraversalTest.class,
            TreeTest.JavaProcessTreeTest.class
    };

    /**
     * Tests that will be enforced by the suite where instances of them should be in the list of testsToExecute.
     */
    protected static final Class<?>[] testsToEnforce = new Class<?>[]{
            FilterTest.class,
            HasTest.class,
            IntervalTest.class,
            RangeTest.class,
            BackTest.class,
            JumpTest.class,
            PathTest.class,
            SelectTest.class,
            Traversal.class,
            TreeTest.class
    };

    public ProcessComputerStandardSuite(final Class<?> klass, final RunnerBuilder builder) throws InitializationError {
        super(klass, builder, testsToExecute, testsToEnforce);
    }

    public ProcessComputerStandardSuite(final Class<?> klass, final RunnerBuilder builder, final Class<?>[] testsToExecute, final Class<?>[] testsToEnforce) throws InitializationError {
        super(klass, builder, testsToExecute, testsToEnforce);
    }
}
