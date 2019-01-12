package com.ybinsure.auth.enums;

public enum CodeTypeEnum {

    // 机构
    COMPANY((byte) 1),

    // 管理员
    ADMIN((byte) 2),

    // 内勤人员
    USER((byte) 3),

    // 业务员
    SALES((byte) 4);

    private byte value;

    CodeTypeEnum(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
