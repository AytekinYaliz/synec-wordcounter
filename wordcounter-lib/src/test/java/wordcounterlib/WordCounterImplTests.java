
package wordcounterlib;

import com.synec.wordcounterlib.exception.InvalidWordException;
import com.synec.wordcounterlib.exception.NotARealWordException;
import com.synec.wordcounterlib.impl.WordCounterImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class WordCounterImplTests {

	WordCounterImpl wordCounterImpl;

	@Before
	public void before()
	{
		wordCounterImpl = new WordCounterImpl();
	}

	@Test(expected = InvalidWordException.class)
	public void shouldThrowErrorWhenAddingNull()
	{
		wordCounterImpl.add(null);
	}

	@Test(expected = InvalidWordException.class)
	public void shouldThrowErrorWhenAddingEmptyString()
	{
		wordCounterImpl.add("");
	}

	@Test(expected = InvalidWordException.class)
	public void shouldThrowErrorWhenAddingNumber()
	{
		wordCounterImpl.add("123");
	}

	@Test(expected = InvalidWordException.class)
	public void shouldThrowErrorWhenAddingAlphaNumeric()
	{
		wordCounterImpl.add("adsf123");
	}

	@Test(expected = NotARealWordException.class)
	public void shouldThrowErrorWhenAddingNonExistingWord()
	{
		wordCounterImpl.add("notARealWord");
	}

	@Test
	public void shouldAddARealWord()
	{
		wordCounterImpl.add("flower");
		assertThat(wordCounterImpl.getCount("flower"), is(1));
	}

	@Test
	public void shouldAddARealWordWithMultipleTranslations()
	{
		wordCounterImpl.add("flower");
		wordCounterImpl.add("blume");

		assertThat(wordCounterImpl.getCount("flower"), is(2));
		assertThat(wordCounterImpl.getCount("blume"), is(2));
		assertThat(wordCounterImpl.getCount("flor"), is(2));
	}

	@Test
	public void shouldAddMultipleRealWords()
	{
		wordCounterImpl.add("flor");
		wordCounterImpl.add("tableDE");
		wordCounterImpl.add("carES");

		assertThat(wordCounterImpl.getCount("flower"), is(1));
		assertThat(wordCounterImpl.getCount("table"), is(1));
		assertThat(wordCounterImpl.getCount("car"), is(1));
	}

	@Test
	public void shouldAddMultipleWordsWithTranslations()
	{
		wordCounterImpl.add("flor");
		wordCounterImpl.add("car");
		wordCounterImpl.add("tableDE");
		wordCounterImpl.add("carES");
		wordCounterImpl.add("flower");
		wordCounterImpl.add("flower");

		assertThat(wordCounterImpl.getCount("flower"), is(3));
		assertThat(wordCounterImpl.getCount("table"), is(1));
		assertThat(wordCounterImpl.getCount("car"), is(2));
	}
}
