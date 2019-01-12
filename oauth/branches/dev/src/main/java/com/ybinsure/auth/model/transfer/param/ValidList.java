package com.ybinsure.auth.model.transfer.param;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ValidList<E> {

    @Valid
    @NotNull(message = "wrap不能为空")
    private List<E> wrap;

    public List<E> getWrap() {
        return wrap;
    }

    public void setWrap(List<E> wrap) {
        this.wrap = wrap;
    }
}
