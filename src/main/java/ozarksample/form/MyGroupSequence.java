package ozarksample.form;

import javax.validation.GroupSequence;

/**
 * Validation Group Sequence
 * @author tada
 */
@GroupSequence({Group1.class, Group2.class, Group3.class})
public interface MyGroupSequence {
    
}
