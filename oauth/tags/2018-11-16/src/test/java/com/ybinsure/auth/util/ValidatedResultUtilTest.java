package com.ybinsure.auth.util;

import com.ybinsure.auth.help.FakerUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ValidatedResultUtilTest {

    @Mock
    private BindingResult bindingResult;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkField() {
        List<FieldError> fieldErrors = fakerFieldErrors();
        when(bindingResult.hasFieldErrors()).thenReturn(true);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);
        assertThat(ValidatedResultUtil.checkField(bindingResult).get(), CoreMatchers.equalTo(fieldErrors.get(0).getDefaultMessage()));

        when(bindingResult.hasFieldErrors()).thenReturn(false);
        assertThat(ValidatedResultUtil.checkField(bindingResult), CoreMatchers.equalTo(Optional.empty()));
    }

    private List<FieldError> fakerFieldErrors() {
        List<FieldError> list = new ArrayList<>();
        list.add(fakerFiledError());
        list.add(fakerFiledError());
        return list;
    }

    private FieldError fakerFiledError() {
        return new FieldError(
                FakerUtils.faker.team().name(),
                FakerUtils.faker.file().fileName(),
                FakerUtils.faker.address().cityName()
        );
    }
}