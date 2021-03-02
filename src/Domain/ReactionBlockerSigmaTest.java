package Domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReactionBlockerSigmaTest {
	ReactionBlockerSigma reactionBlockerSigma;
	@Test
	void testExpectedException() {
	  assertThrows(IllegalArgumentException.class, () -> {
		  reactionBlockerSigma = new ReactionBlockerSigma(300, 300, 40, 2, 0);
	  });
	}
	@Test
	void testReactionBlockerSigma() {
		reactionBlockerSigma = new ReactionBlockerSigma(300, 300, 40, 0, 0);
		assertEquals(300,reactionBlockerSigma.getXpos());
	}
	@Test
	void testReactionBlockerSigmaBB() {
		reactionBlockerSigma = new ReactionBlockerSigma(300, 300, 40, 0, 0);
		int radius = reactionBlockerSigma.getYpos();
		Assertions.assertNotNull(radius);
	}
	@Test
	void testReactionBlockerSigmaBBB() {
		reactionBlockerSigma = new ReactionBlockerSigma(300, 300, 40, 0, 0);
		MatcherAssert.assertThat(reactionBlockerSigma, instanceOf(MoleculeAlpha.class));
	}
	@Test
	void testReactionBlockerSigmaB() {
		reactionBlockerSigma = new ReactionBlockerSigma(300, 300, 40, 0, 0);
		assertEquals(3,reactionBlockerSigma.getType());
	}
}
