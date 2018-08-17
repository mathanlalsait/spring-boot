package com.candid.spring.tokenizer;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.batch.item.file.transform.RangeArrayPropertyEditor;

public class PersonFixedLengthTokenizer extends FixedLengthTokenizer {

    public PersonFixedLengthTokenizer() {
        setNames(new String[]{"rollno", "name", "dept"
        });
    }

}
