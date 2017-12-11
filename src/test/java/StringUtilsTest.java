/*
 * Copyright (C) 2017 BullyBoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.Test;
import utils.StringUtils;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void invertString() throws Exception {
        String s = StringUtils.invertString(null);
        assertTrue(s == null);

        s = StringUtils.invertString("");
        assertTrue(s.equals(""));

        s = StringUtils.invertString("a");
        assertTrue(s.equals("a"));

        s = StringUtils.invertString("ab");
        assertTrue(s.equals("ba"));

        s = StringUtils.invertString("abc");
        assertTrue(s.equals("cba"));

        s = StringUtils.invertString("abcdef");
        assertTrue(s.equals("fedcba"));
    }

    @Test
    public void invertWords() throws Exception {
        String s = StringUtils.invertWords(null);
        assertTrue(s == null);

        s = StringUtils.invertWords("");
        assertTrue(s.equals(""));

        s = StringUtils.invertWords("word");
        assertTrue(s.equals("word"));

        s = StringUtils.invertWords("hello java world");
        assertTrue(s.equals("world java hello"));
    }

    @Test
    public void toCapitalLetter() throws Exception {
        String s = null;

        s = StringUtils.toCapitalLetter(s);
        assertTrue(s == null);

        s = StringUtils.toCapitalLetter("");
        assertTrue(s.equals(""));

        s = StringUtils.toCapitalLetter("a");
        assertTrue(s.equals("A"));

        s = StringUtils.toCapitalLetter("ab");
        assertTrue(s.equals("Ab"));

        s = StringUtils.toCapitalLetter("abc");
        assertTrue(s.equals("Abc"));
    }

    @Test
    public void toCapitalLetter1() throws Exception {
        String[] array = null;

        array = StringUtils.toCapitalLetter(array);
        assertTrue(array == null);

        array = new String[]{};

        array = StringUtils.toCapitalLetter(array);
        assertTrue(array.length == 0);

        array = new String[]{
                null,
                "",
                "a",
                "abc"
        };

        array = StringUtils.toCapitalLetter(array);

        assertTrue(array[0] == null);
        assertTrue(array[1].length() == 0);
        assertTrue(array[2].equals("A"));
        assertTrue(array[3].equals("Abc"));
    }

    @Test
    public void getCharacterCount() throws Exception {
        int count = StringUtils.getCharacterCount(null, '0');
        assertTrue(count == 0);

        count = StringUtils.getCharacterCount("", '0');
        assertTrue(count == 0);

        count = StringUtils.getCharacterCount("abc", 'd');
        assertTrue(count == 0);

        count = StringUtils.getCharacterCount("abc", 'a');
        assertTrue(count == 1);

        count = StringUtils.getCharacterCount("abcabc", 'a');
        assertTrue(count == 2);
    }

    @Test
    public void similar() throws Exception {
        int count = StringUtils.similar("test", "teste");
        assertTrue(count == 1);
    }

}