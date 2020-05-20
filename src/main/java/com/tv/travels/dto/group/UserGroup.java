package com.tv.travels.dto.group;

import javax.validation.GroupSequence;

public interface UserGroup {

    @GroupSequence({ADD.USERNAME.class,
            ADD.PASSWORD.class,
            ADD.EMAIL.class,
            ADD.CODE.class})

    interface ADD {
        interface USERNAME {}
        interface PASSWORD {}
        interface EMAIL {}
        interface CODE {}
    }

    interface UPDATE {

    }

}
