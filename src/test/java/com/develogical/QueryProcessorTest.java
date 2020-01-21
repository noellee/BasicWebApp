package com.develogical;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutPlusQuery() throws Exception {
        assertThat(queryProcessor.process("what is 2 plus 3"), is("5"));
    }

    @Test
    public void knowsAboutMinusQuery() throws Exception {
        assertThat(queryProcessor.process("what is 3 minus 2"), is("1"));
    }
}
